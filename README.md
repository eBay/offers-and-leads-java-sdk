# Offers and Leads Java SDK

A production-ready Java SDK for eBay Offers and Leads APIs, providing unified access to classified ad leads and offer negotiation management.

## Features

- **Sell Leads API**: Retrieve classified ad leads for active listings (2 operations)
- **Offers GraphQL API**: Manage offer negotiations (planned)
- **Per-Call Authentication**: Token can be passed per-call or set globally
- **Strong Typing**: Kiota-generated types with public abstraction layer
- **Custom Headers Support**: Per-call and global header configuration via RequestOptions
- **Java 17+**: Modern Java with CompletableFuture async APIs

## Architecture

```
src/main/java/com/ebay/offersandleads/
├── generated/                    # Kiota-generated REST clients (package-private)
│   └── feed/
├── clients/
│   └── rest/
│       └── LeadsClient.java      # REST client wrapper (public API)
├── configuration/                # SDK configuration and auth
├── exceptions/                   # SDK exceptions
└── OffersAndLeadsClient.java     # Main SDK facade
```

## Installation

```bash
# Build from source
mvn clean install

# Publish to local Maven repository
mvn install -DskipTests
```

Then add the dependency to your project:

```xml
<dependency>
    <groupId>com.ebay</groupId>
    <artifactId>offers-and-leads-java-sdk</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Quick Start

### 1. Basic Usage

```java
import com.ebay.offersandleads.OffersAndLeadsClient;
import com.ebay.offersandleads.configuration.OffersAndLeadsConfiguration;

var config = new OffersAndLeadsConfiguration();
config.setAccessToken("your-ebay-oauth-token");

try (var sdk = new OffersAndLeadsClient(config)) {
    // Get all classified leads
    var leads = sdk.leads.getAllClassifiedLeadsAsync(null, null, null, null, null, null);
    System.out.println("Leads: " + leads.join());
}
```

### 2. Per-Call Token (Multi-Tenant)

```java
var config = new OffersAndLeadsConfiguration();
// No global token set

try (var sdk = new OffersAndLeadsClient(config)) {
    // Pass token per-call for multi-tenant scenarios
    String userToken = getUserTokenFromRequest();
    var leads = sdk.leads.getAllClassifiedLeadsAsync(null, null, null, null, userToken, null);
}
```

### 3. Custom Headers (RequestOptions)

```java
import com.ebay.offersandleads.configuration.RequestOptions;

var config = new OffersAndLeadsConfiguration();
config.setAccessToken("token");

// Set default headers for ALL calls
config.getDefaultRequestOptions().addHeader("X-EBAY-C-MARKETPLACE-ID", "EBAY_US");
config.getDefaultRequestOptions().addHeader("Accept-Language", "en-US");

try (var sdk = new OffersAndLeadsClient(config)) {
    // Per-call headers override defaults
    var options = new RequestOptions();
    options.addHeader("X-EBAY-C-MARKETPLACE-ID", "EBAY_UK");  // Override marketplace
    options.addHeader("X-Request-ID", "correlation-123");     // Add correlation ID
    
    var leads = sdk.leads.getAllClassifiedLeadsAsync(null, null, null, null, null, options);
}
```

### 4. Get All Classified Leads

```java
// Get all leads with filters
var leads = sdk.leads.getAllClassifiedLeadsAsync(
    "2024-01-01T00:00:00.000Z",  // startTime (ISO 8601)
    "2024-01-31T23:59:59.000Z",  // endTime (ISO 8601)
    "Unanswered",                // status: 'Answered' | 'Unanswered'
    "true",                      // includeMessages: 'true' | 'false'
    token,
    null
).join();

System.out.println("Total Leads: " + leads.getTotal());
leads.getClassifiedLeads().forEach(lead -> {
    System.out.println("Lead ID: " + lead.getLeadId());
    System.out.println("Item ID: " + lead.getItemId());
    System.out.println("Status: " + lead.getStatus());
});
```

### 5. Get Leads for Specific Item

```java
// Get leads for a specific listing
var itemLeads = sdk.leads.getClassifiedLeadsByItemIdAsync(
    "v1|123456789012|0",         // itemId
    "2024-01-01T00:00:00.000Z",  // startTime (ISO 8601)
    "2024-01-31T23:59:59.000Z",  // endTime (ISO 8601)
    null,                        // status (all)
    "true",                      // includeMessages (default true for this endpoint)
    token,
    null
).join();

System.out.println("Item ID: " + itemLeads.getItemId());
System.out.println("Item Title: " + itemLeads.getItemTitle());
itemLeads.getQuestions().forEach(question -> {
    System.out.println("Question: " + question.getQuestionText());
    System.out.println("Asked on: " + question.getCreationDate());
});
```

## Configuration

### OffersAndLeadsConfiguration Options

```java
var config = new OffersAndLeadsConfiguration();

// Base URLs (defaults to apiz.ebay.com)
config.setLeadsBaseUrl("https://apiz.ebay.com");
config.setGraphQLBaseUrl("https://api.ebay.com/graphql");

// Authentication
config.setAccessToken("your-token");  // Optional fallback token

// Diagnostics
config.setDiagnosticLogging(true);    // Enable request/response logging

// Default headers (applied to all requests)
config.getDefaultRequestOptions().addHeader("X-EBAY-C-MARKETPLACE-ID", "EBAY_US");
config.getDefaultRequestOptions().addHeader("Accept-Language", "en-US");
```

## API Coverage

### Sell Leads API (2 operations)
- `getAllClassifiedLeadsAsync(startTime, endTime, status, includeMessages, token, options)` - Get all classified leads for seller's listings
- `getClassifiedLeadsByItemIdAsync(itemId, startTime, endTime, status, includeMessages, token, options)` - Get leads for a specific listing

**Parameters**:
- `startTime` - ISO 8601 timestamp — only leads created on/after this time
- `endTime` - ISO 8601 timestamp — only leads created on/before this time
- `status` - `"Answered"` or `"Unanswered"`
- `includeMessages` - `"true"` or `"false"` (default true for item-specific endpoint)
- `token` - Per-call OAuth token (overrides config fallback)
- `options` - RequestOptions for custom headers

**Response Types**:
- `ClassifiedLeadsListResponse` - Contains list of leads and pagination
- `ClassifiedLead` - Single lead with questions, responses, and metadata

**Example Lead Data**:
```java
{
  "leadId": "5678901234",
  "itemId": "v1|123456789012|0",
  "itemTitle": "Vintage Camera",
  "status": "Answered",
  "creationDate": "2024-01-15T10:30:00.000Z",
  "questions": [
    {
      "questionId": "9876543210",
      "questionText": "Does this include the lens?",
      "creationDate": "2024-01-15T10:30:00.000Z"
    }
  ],
  "contactInformation": {
    "name": "John Doe",
    "email": "buyer@example.com"
  }
}
```

### Offers GraphQL API (Planned)
- Dynamic GraphQL client for offer negotiation operations
- Typed operations for make offer, accept offer, decline offer, counter offer
- Buyer/seller negotiation history queries

## Regenerating REST Clients

If the OpenAPI specs are updated:

```bash
./generate.sh
mvn clean install
```

This will regenerate all Kiota clients from the specs in the `specs/` directory.

## Requirements

- Java 17 or higher
- Kiota CLI (for regeneration only)

## Dependencies

- `microsoft.kiota:microsoft-kiota-bundle:1.9.2` - REST client runtime
- `com.squareup.okhttp3:okhttp:4.12.0` - HTTP client
- `com.fasterxml.jackson.core:jackson-databind:2.18.2` - JSON processing

## Project Structure

```
offers-and-leads-java-sdk/
├── specs/                       # OpenAPI specs + GraphQL schema
│   ├── sell_lead_v1_oas3.yaml
│   └── eBay_Graph.graphqls (planned)
├── src/main/java/
│   └── com/ebay/offersandleads/
│       ├── OffersAndLeadsClient.java
│       ├── configuration/
│       │   ├── OffersAndLeadsConfiguration.java
│       │   ├── TokenContext.java
│       │   ├── RequestOptions.java
│       │   └── KiotaAuthProvider.java
│       ├── clients/
│       │   └── rest/
│       │       └── LeadsClient.java
│       ├── generated/           # Kiota-generated (committed)
│       │   └── feed/
│       └── exceptions/
│           └── OffersAndLeadsException.java
├── pom.xml
├── generate.sh
├── operations.json
└── README.md
```

## Consistency with .NET and PHP SDKs

This Java SDK mirrors the architecture of the .NET and PHP Offers and Leads SDKs:

- **Same API Coverage**: All Leads API operations (2 total)
- **Same Auth Pattern**: Per-call token with optional fallback
- **Same Naming**: `OffersAndLeadsClient`, `OffersAndLeadsConfiguration`
- **Same Structure**: Generated layer + thin abstraction wrappers
- **Same Tooling**: Kiota for REST code generation
- **RequestOptions Support**: Per-call and global custom headers

The main difference is the async model: Java uses `CompletableFuture`, .NET uses `Task`, and PHP is synchronous.

## Error Handling

```java
try (var sdk = new OffersAndLeadsClient(config)) {
    var leads = sdk.leads.getAllClassifiedLeadsAsync(null, null, null, null, token, null);
    var result = leads.join();  // Blocks until complete
} catch (RuntimeException e) {
    // Handle API errors
    System.err.println("Error: " + e.getMessage());
    e.printStackTrace();
}
```

## License

Internal eBay use only.
