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

package com.ebay.offersandleads.clients.rest;

import com.ebay.offersandleads.configuration.OffersAndLeadsConfiguration;
import com.ebay.offersandleads.configuration.RequestOptions;
import com.ebay.offersandleads.configuration.TokenContext;
import com.ebay.offersandleads.generated.feed.FeedApiClient;
import com.ebay.offersandleads.generated.feed.models.ClassifiedLead;
import com.ebay.offersandleads.generated.feed.models.ClassifiedLeadsListResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Client for the Sell Leads API.
 * Provides methods to retrieve classified ad leads for the seller's active listings.
 */
public final class LeadsClient {
    private final FeedApiClient kiota;
    private final OffersAndLeadsConfiguration config;

    public LeadsClient(FeedApiClient kiota, OffersAndLeadsConfiguration config) {
        this.kiota = kiota;
        this.config = config;
    }

    /**
     * Merges default headers from config with per-call headers.
     * Per-call headers override defaults.
     */
    private Map<String, String> mergedHeaders(RequestOptions requestOptions) {
        Map<String, String> headers = new HashMap<>(config.getDefaultRequestOptions().getHeaders());
        if (requestOptions != null) {
            headers.putAll(requestOptions.getHeaders());
        }
        return headers;
    }

    // ── Classified Leads ──────────────────────────────────────────────────

    /**
     * Retrieve all classified ad leads for the seller's active listings.
     *
     * @param startTime ISO 8601 — only leads created on/after this time
     * @param endTime ISO 8601 — only leads created on/before this time
     * @param status 'Answered' | 'Unanswered'
     * @param includeMessages 'true' | 'false'
     * @param accessToken Per-call token; overrides config fallback
     * @param requestOptions Per-call headers
     * @return ClassifiedLeadsListResponse containing all classified leads
     */
    public CompletableFuture<ClassifiedLeadsListResponse> getAllClassifiedLeadsAsync(
            String startTime,
            String endTime,
            String status,
            String includeMessages,
            String accessToken,
            RequestOptions requestOptions) {
        return CompletableFuture.supplyAsync(() -> {
            TokenContext.CURRENT.set(accessToken);
            Map<String, String> headers = mergedHeaders(requestOptions);
            try {
                return kiota.classifiedLead().get(config -> {
                    headers.forEach((k, v) -> config.headers.add(k, v));
                    if (startTime != null) {
                        config.queryParameters.startTime = startTime;
                    }
                    if (endTime != null) {
                        config.queryParameters.endTime = endTime;
                    }
                    if (status != null) {
                        config.queryParameters.status = status;
                    }
                    if (includeMessages != null) {
                        config.queryParameters.includeMessages = includeMessages;
                    }
                });
            } finally {
                TokenContext.CURRENT.remove();
            }
        });
    }

    /**
     * Retrieve classified ad leads for a specific listing.
     *
     * @param itemId The unique listing identifier
     * @param startTime ISO 8601 — only leads created on/after this time
     * @param endTime ISO 8601 — only leads created on/before this time
     * @param status 'Answered' | 'Unanswered'
     * @param includeMessages 'true' | 'false' (default true for this endpoint)
     * @param accessToken Per-call token; overrides config fallback
     * @param requestOptions Per-call headers
     * @return ClassifiedLead for the specified listing
     */
    public CompletableFuture<ClassifiedLead> getClassifiedLeadsByItemIdAsync(
            String itemId,
            String startTime,
            String endTime,
            String status,
            String includeMessages,
            String accessToken,
            RequestOptions requestOptions) {
        return CompletableFuture.supplyAsync(() -> {
            TokenContext.CURRENT.set(accessToken);
            Map<String, String> headers = mergedHeaders(requestOptions);
            try {
                return kiota.classifiedLead().byItemId(itemId).get(config -> {
                    headers.forEach((k, v) -> config.headers.add(k, v));
                    if (startTime != null) {
                        config.queryParameters.startTime = startTime;
                    }
                    if (endTime != null) {
                        config.queryParameters.endTime = endTime;
                    }
                    if (status != null) {
                        config.queryParameters.status = status;
                    }
                    if (includeMessages != null) {
                        config.queryParameters.includeMessages = includeMessages;
                    }
                });
            } finally {
                TokenContext.CURRENT.remove();
            }
        });
    }
}
