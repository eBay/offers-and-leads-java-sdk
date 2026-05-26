// Copyright 2026 eBay Inc.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.ebay.offersandleads.configuration;

import java.net.URI;
import java.util.Set;
import java.util.HashSet;

/**
 * Configuration for the Offers and Leads SDK.
 * Provides base URLs for Leads REST API and GraphQL API, plus optional fallback access token.
 */
public final class OffersAndLeadsConfiguration {
    // Base URLs for each API
    private String leadsBaseUrl = "https://apiz.ebay.com/sell/leads/v1";
    private String graphQLBaseUrl = "https://api.ebay.com/graphql";

    private String accessToken;  // static fallback; per-call token takes precedence
    private boolean diagnosticLogging = false;

    /**
     * Default request options (headers) applied to all SDK calls.
     * Per-call RequestOptions will override these.
     */
    private RequestOptions defaultRequestOptions = new RequestOptions();

    // Getters and setters
    public String getLeadsBaseUrl() { return leadsBaseUrl; }
    public void setLeadsBaseUrl(String leadsBaseUrl) { this.leadsBaseUrl = leadsBaseUrl; }

    public String getGraphQLBaseUrl() { return graphQLBaseUrl; }
    public void setGraphQLBaseUrl(String graphQLBaseUrl) { this.graphQLBaseUrl = graphQLBaseUrl; }

    public String getAccessToken() { return accessToken; }
    public void setAccessToken(String accessToken) { this.accessToken = accessToken; }

    public boolean isDiagnosticLogging() { return diagnosticLogging; }
    public void setDiagnosticLogging(boolean diagnosticLogging) { this.diagnosticLogging = diagnosticLogging; }

    public RequestOptions getDefaultRequestOptions() { return defaultRequestOptions; }
    public void setDefaultRequestOptions(RequestOptions defaultRequestOptions) { this.defaultRequestOptions = defaultRequestOptions; }

    /**
     * All hostnames tokens may be sent to; used by AllowedHostsValidator.
     */
    public Set<String> getAllowedHosts() {
        Set<String> hosts = new HashSet<>();
        hosts.add(extractHost(leadsBaseUrl));
        hosts.add(extractHost(graphQLBaseUrl));
        return hosts;
    }

    private String extractHost(String url) {
        try {
            return URI.create(url).getHost();
        } catch (Exception e) {
            return "api.ebay.com"; // fallback
        }
    }
}
