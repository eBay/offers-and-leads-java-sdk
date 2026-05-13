package com.ebay.offersandleads;

import com.ebay.offersandleads.clients.rest.LeadsClient;
import com.ebay.offersandleads.configuration.KiotaAuthProvider;
import com.ebay.offersandleads.configuration.OffersAndLeadsConfiguration;
import com.ebay.offersandleads.generated.feed.FeedApiClient;
import com.microsoft.kiota.authentication.BaseBearerTokenAuthenticationProvider;
import com.microsoft.kiota.http.OkHttpRequestAdapter;
import okhttp3.OkHttpClient;
import java.io.Closeable;

/**
 * Main facade for the Offers and Leads SDK.
 * Provides unified access to the Sell Leads API and Offers GraphQL API.
 *
 * <pre>{@code
 * var config = new OffersAndLeadsConfiguration();
 * config.setAccessToken("your-token");
 *
 * try (var sdk = new OffersAndLeadsClient(config)) {
 *     var leads = sdk.leads.getAllClassifiedLeadsAsync(null, null, null, null, null, null);
 *     System.out.println(leads.join());
 * }
 * }</pre>
 */
public final class OffersAndLeadsClient implements Closeable {
    private final OkHttpClient sharedHttpClient;

    public final LeadsClient leads;

    public OffersAndLeadsClient(OffersAndLeadsConfiguration config) {
        // Shared OkHttpClient for all REST clients
        this.sharedHttpClient = new OkHttpClient.Builder()
            .build();

        var authProvider = new BaseBearerTokenAuthenticationProvider(new KiotaAuthProvider(config));

        // Leads API client
        var leadsAdapter = new OkHttpRequestAdapter(authProvider, null, null, sharedHttpClient);
        leadsAdapter.setBaseUrl(config.getLeadsBaseUrl());
        this.leads = new LeadsClient(new FeedApiClient(leadsAdapter), config);
    }

    /**
     * Constructor with custom OkHttpClient.
     * Useful for testing or custom HTTP configuration.
     */
    public OffersAndLeadsClient(OffersAndLeadsConfiguration config, OkHttpClient httpClient) {
        this.sharedHttpClient = httpClient;

        var authProvider = new BaseBearerTokenAuthenticationProvider(new KiotaAuthProvider(config));

        var leadsAdapter = new OkHttpRequestAdapter(authProvider, null, null, sharedHttpClient);
        leadsAdapter.setBaseUrl(config.getLeadsBaseUrl());
        this.leads = new LeadsClient(new FeedApiClient(leadsAdapter), config);
    }

    @Override
    public void close() {
        sharedHttpClient.dispatcher().executorService().shutdown();
        sharedHttpClient.connectionPool().evictAll();
    }
}
