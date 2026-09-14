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

package com.ebay.offersandleads;

import com.ebay.offersandleads.clients.graphql.ApolloClientFactory;
import com.ebay.offersandleads.clients.graphql.BearerTokenInterceptor;
import com.ebay.offersandleads.clients.graphql.DynamicGraphQLClient;
import com.ebay.offersandleads.clients.graphql.OffersGraphQLClient;
import com.ebay.offersandleads.clients.rest.ClassifiedLeadsClient;
import com.ebay.offersandleads.configuration.KiotaAuthProvider;
import com.ebay.offersandleads.configuration.OffersAndLeadsConfiguration;
import com.ebay.offersandleads.generated.classifiedleads.ClassifiedLeadsApiClient;
import com.microsoft.kiota.authentication.BaseBearerTokenAuthenticationProvider;
import com.microsoft.kiota.http.OkHttpRequestAdapter;
import okhttp3.OkHttpClient;
import java.io.Closeable;
import java.util.concurrent.TimeUnit;

/**
 * Main facade for the Offers and Leads SDK.
 */
public final class OffersAndLeadsClient implements Closeable {
    private final OkHttpClient sharedHttpClient;
    private final OkHttpClient apolloHttpClient;

    public final ClassifiedLeadsClient classifiedLeads;
    public final OffersGraphQLClient graphQL;

    public OffersAndLeadsClient(OffersAndLeadsConfiguration config) {
        this.sharedHttpClient = new OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build();

        var authProvider = new BaseBearerTokenAuthenticationProvider(new KiotaAuthProvider(config));

        var classifiedLeadsAdapter = new OkHttpRequestAdapter(authProvider, null, null, sharedHttpClient);
        classifiedLeadsAdapter.setBaseUrl(config.getClassifiedLeadsBaseUrl());
        this.classifiedLeads = new ClassifiedLeadsClient(new ClassifiedLeadsApiClient(classifiedLeadsAdapter), config);

        this.apolloHttpClient = new OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(new BearerTokenInterceptor(config))
            .build();
        var apolloClient = ApolloClientFactory.create(
            config.getGraphQLBaseUrl(),
            apolloHttpClient
        );

        this.graphQL = new OffersGraphQLClient(
            apolloClient,
            new DynamicGraphQLClient(sharedHttpClient, config),
            config
        );
    }

    @Override
    public void close() {
        sharedHttpClient.dispatcher().executorService().shutdown();
        sharedHttpClient.connectionPool().evictAll();
        apolloHttpClient.dispatcher().executorService().shutdown();
        apolloHttpClient.connectionPool().evictAll();
    }
}
