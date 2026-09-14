# ChangeLog

## 0.2.0 (09/14/2026)

### Breaking changes

#### Renamed clients and members

| Previous | Current |
| --- | --- |
| `LeadsClient` | `ClassifiedLeadsClient` |
| `OffersAndLeadsClient.leads` | `OffersAndLeadsClient.classifiedLeads` |

#### Changed signatures

The renamed classified-leads client retains both operations with updated parameters:

| Operation | Previous parameters | Current parameters |
| --- | --- | --- |
| `getAllClassifiedLeadsAsync` | `(String startTime, String endTime, String status, String includeMessages, String accessToken, RequestOptions requestOptions)` | `(String endTime, String includeMessages, String startTime, String status, String acceptEncoding, String accessToken, RequestOptions requestOptions)` |
| `getClassifiedLeadsByItemIdAsync` | `(String itemId, String startTime, String endTime, String status, String includeMessages, String accessToken, RequestOptions requestOptions)` | `(String itemId, String endTime, String includeMessages, String startTime, String status, String acceptEncoding, String accessToken, RequestOptions requestOptions)` |
