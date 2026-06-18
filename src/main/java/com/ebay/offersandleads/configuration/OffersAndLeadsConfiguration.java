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
    // Base URLs for each API (private final — SEC-002)
    private final String leadsBaseUrl;
    private final String graphQLBaseUrl;

    private String accessToken;  // static fallback; per-call token takes precedence
    private boolean diagnosticLogging = false;

    /**
     * Default request options (headers) applied to all SDK calls.
     * Per-call RequestOptions will override these.
     */
    private RequestOptions defaultRequestOptions = new RequestOptions();

    /** Default constructor — uses production eBay endpoints. */
    public OffersAndLeadsConfiguration() {
        this.leadsBaseUrl = "https://apiz.ebay.com";
        this.graphQLBaseUrl = "https://api.ebay.com/graphql";
    }

    /**
     * Constructor accepting custom base URLs.
     * All URLs are validated against the allowed-hosts list (SEC-002).
     *
     * @param leadsBaseUrl    Base URL for the Sell Leads REST API
     * @param graphQLBaseUrl  Base URL for the Offers GraphQL API
     */
    public OffersAndLeadsConfiguration(String leadsBaseUrl, String graphQLBaseUrl) {
        // Validate after building allowed-hosts from defaults so we can call validateHost
        // with a preliminary set before the fields are set.
        Set<String> allowed = new HashSet<>();
        allowed.add("apiz.ebay.com");
        allowed.add("api.ebay.com");
        this.leadsBaseUrl = validateHost(leadsBaseUrl, allowed);
        this.graphQLBaseUrl = validateHost(graphQLBaseUrl, allowed);
    }

    // Getters only — no setters for URL fields (SEC-002)
    public String getLeadsBaseUrl() { return leadsBaseUrl; }
    public String getGraphQLBaseUrl() { return graphQLBaseUrl; }

    /**
     * Returns the static fallback access token.
     *
     * <p><strong>Security note (SEC-002):</strong> The token is stored as a plain {@code String}
     * on the heap. Avoid logging or serialising configuration objects that hold tokens.</p>
     */
    public String getAccessToken() { return accessToken; }

    /**
     * Sets the static fallback access token.
     *
     * <p><strong>Security note (SEC-002):</strong> Prefer per-call tokens passed directly to
     * each async method. A globally-stored token on the heap may be visible to other threads
     * and heap dumps. Clear the token when it is no longer needed.</p>
     *
     * @param accessToken OAuth bearer token
     */
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

    private static String validateHost(String url, Set<String> allowedHosts) {
        try {
            String host = new java.net.URI(url).getHost();
            if (host == null || !allowedHosts.contains(host)) {
                throw new IllegalArgumentException("URL host not in allowed list: " + url);
            }
        } catch (java.net.URISyntaxException e) {
            throw new IllegalArgumentException("Invalid URL: " + url, e);
        }
        return url;
    }
}
