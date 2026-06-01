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

## Error Handling

```java
try {
    var leads = sdk.leads.getAllClassifiedLeadsAsync(null, null, null, null, null, null).join();
} catch (OffersAndLeadsException ex) {
    System.err.println("SDK error: " + ex.getMessage());
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

- **microsoft-kiota-bundle**: REST client generation and runtime
- **okhttp3**: HTTP client
- **jackson-databind**: JSON processing
- **slf4j-api**: Logging facade

## License

Apache 2.0 © 2026 eBay Inc. See [LICENSE](LICENSE) for details.
