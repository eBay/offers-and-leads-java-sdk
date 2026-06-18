# eBay Offers and Leads Java SDK

A production-ready Java SDK for eBay Offers and Leads APIs, providing unified access to classified ad lead management.

## Features

- **Sell Leads API**: Retrieve classified ad leads for active listings (2 operations)
- **Strong Typing**: Internal Kiota-generated types with public client wrappers
- **Per-call Overrides**: Pass per-request headers and access tokens alongside SDK-wide defaults

## Architecture

```
src/main/java/com/ebay/offersandleads/
├── generated/                         # Kiota-generated REST clients (internal)
│   └── feed/
├── clients/
│   ├── rest/
│   │   └── LeadsClient.java           # REST client wrapper (public API)
│   └── graphql/
│       └── DynamicGraphQLClient.java  # GraphQL escape hatch
├── configuration/                     # SDK configuration and auth
├── exceptions/                        # SDK exceptions
└── OffersAndLeadsClient.java          # Main SDK facade
```

## Requirements

- Java 17+
- Maven

## Installation

```xml
<dependency>
    <groupId>com.ebay</groupId>
    <artifactId>offers-and-leads-java-sdk</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Quick Start

```java
var config = new OffersAndLeadsConfiguration();
config.setAccessToken("your-oauth-token");

try (var sdk = new OffersAndLeadsClient(config)) {
    var leads = sdk.leads.getAllClassifiedLeadsAsync(
        "2024-01-01T00:00:00Z", "2024-01-31T23:59:59Z",
        "Unanswered", "true", null, null).join();

    var itemLeads = sdk.leads.getClassifiedLeadsByItemIdAsync(
        "v1|123456789012|0", null, null, null, null, null, null).join();
}
```

Per-request headers and tokens can be passed to any method:

```java
var options = new RequestOptions();
options.addHeader("X-EBAY-C-MARKETPLACE-ID", "EBAY_US");

sdk.leads.getAllClassifiedLeadsAsync(null, null, null, null, "per-call-token", options).join();
```

## API Operations

### Sell Leads API

| Method | Description |
|---|---|
| `getAllClassifiedLeadsAsync` | Get all classified leads for seller's active listings |
| `getClassifiedLeadsByItemIdAsync` | Get leads for a specific listing |

## Rate Limiting and Retry

The SDK does not include built-in retry logic or rate-limit handling. eBay's APIs return HTTP 429 Too Many Requests when rate limits are exceeded. Implement exponential back-off in your application layer when calling bulk endpoints in loops.

Refer to eBay's API call limits documentation for per-endpoint rate limit details.

---

## Apollo GraphQL HTTP Cache

If you enable Apollo's HTTP cache, GraphQL responses including inventory details and pricing will be written to the local filesystem. Leave the cache disabled (the default) or restrict file permissions if you enable it.

---

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

## Configuration Options

| Property | Default | Description |
|---|---|---|
| `leadsBaseUrl` | `https://apiz.ebay.com` | Leads API base URL |
| `graphQLBaseUrl` | `https://api.ebay.com/graphql` | GraphQL API endpoint |
| `accessToken` | `null` | Static fallback token; per-call token takes precedence |
| `defaultRequestOptions` | `RequestOptions()` | Default headers applied to all SDK calls |
| `diagnosticLogging` | `false` | Enable diagnostic request/response logging |

## Regenerating the SDK

```bash
./generate.sh
mvn clean install
```

## Development

```bash
mvn clean install   # Build and install
mvn test            # Run tests
mvn package         # Package
```

## Specs

- `sell_feed_v1_oas3.yaml` — Sell Leads V1
- `eBay_Graph.graphqls` — eBay Graph schema

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

## License

Apache 2.0 © 2026 eBay Inc. See [LICENSE](LICENSE) for details.
