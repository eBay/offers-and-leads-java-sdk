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
import com.ebay.offersandleads.generated.classifiedleads.ClassifiedLeadsApiClient;
import com.ebay.offersandleads.generated.classifiedleads.models.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public final class ClassifiedLeadsClient {
    private final ClassifiedLeadsApiClient kiota;
    private final OffersAndLeadsConfiguration config;

    public ClassifiedLeadsClient(ClassifiedLeadsApiClient kiota, OffersAndLeadsConfiguration config) {
        this.kiota = kiota;
        this.config = config;
    }

    private Map<String, String> mergedHeaders(RequestOptions requestOptions) {
        Map<String, String> headers = new HashMap<>(config.getDefaultRequestOptions().getHeaders());
        if (requestOptions != null) {
            headers.putAll(requestOptions.getHeaders());
        }
        return headers;
    }

    public CompletableFuture<ClassifiedLeadsListResponse> getAllClassifiedLeadsAsync(
            String endTime, String includeMessages, String startTime, String status, String acceptEncoding, String accessToken, RequestOptions requestOptions) {
        return CompletableFuture.supplyAsync(() -> TokenContext.runWith(accessToken, () -> {
            Map<String, String> headers = mergedHeaders(requestOptions);
            return kiota.classifiedLead().get(config -> {
                headers.forEach((k, v) -> config.headers.add(k, v));
                if (endTime != null) config.queryParameters.endTime = endTime;
                if (includeMessages != null) config.queryParameters.includeMessages = includeMessages;
                if (startTime != null) config.queryParameters.startTime = startTime;
                if (status != null) config.queryParameters.status = status;
                if (acceptEncoding != null) config.headers.add("Accept-Encoding", acceptEncoding);
            });
        }));
    }

    public CompletableFuture<ClassifiedLead> getClassifiedLeadsByItemIdAsync(
            String itemId, String endTime, String includeMessages, String startTime, String status, String acceptEncoding, String accessToken, RequestOptions requestOptions) {
        return CompletableFuture.supplyAsync(() -> TokenContext.runWith(accessToken, () -> {
            Map<String, String> headers = mergedHeaders(requestOptions);
            return kiota.classifiedLead().byItemId(Params.requireValid("itemId", itemId)).get(config -> {
                headers.forEach((k, v) -> config.headers.add(k, v));
                if (endTime != null) config.queryParameters.endTime = endTime;
                if (includeMessages != null) config.queryParameters.includeMessages = includeMessages;
                if (startTime != null) config.queryParameters.startTime = startTime;
                if (status != null) config.queryParameters.status = status;
                if (acceptEncoding != null) config.headers.add("Accept-Encoding", acceptEncoding);
            });
        }));
    }
}
