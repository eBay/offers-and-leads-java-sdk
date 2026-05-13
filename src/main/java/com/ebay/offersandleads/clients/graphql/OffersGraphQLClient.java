package com.ebay.offersandleads.clients.graphql;

import com.ebay.offersandleads.configuration.RequestOptions;
import com.ebay.offersandleads.graphql.OfferOperations;
import com.ebay.offersandleads.graphql.types.*;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * GraphQL client for Offers API operations.
 * Provides typed async methods for offer mutations and queries.
 */
public final class OffersGraphQLClient {
    private final DynamicGraphQLClient dynamic;

    public OffersGraphQLClient(DynamicGraphQLClient dynamic) {
        this.dynamic = dynamic;
    }

    /**
     * Accept an active offer (or counteroffer).
     *
     * @param input The accept offer input.
     * @param accessToken Per-call token; overrides config fallback.
     * @param requestOptions Optional custom headers for this request.
     * @return CompletableFuture with the GraphQL response data.
     */
    public CompletableFuture<JsonNode> acceptOfferAsync(
            AcceptOfferInput input,
            String accessToken,
            RequestOptions requestOptions) {
        return CompletableFuture.supplyAsync(() -> {
            Map<String, Object> variables = new HashMap<>();
            variables.put("input", input.toMap());
            JsonNode data = dynamic.execute(OfferOperations.ACCEPT_OFFER, variables, accessToken, requestOptions);
            return data.get("acceptOffer");
        });
    }

    /**
     * Accept an active offer with default options.
     */
    public CompletableFuture<JsonNode> acceptOfferAsync(AcceptOfferInput input, String accessToken) {
        return acceptOfferAsync(input, accessToken, null);
    }

    /**
     * Decline an active offer (or counteroffer).
     *
     * @param input The decline offer input.
     * @param accessToken Per-call token; overrides config fallback.
     * @param requestOptions Optional custom headers for this request.
     * @return CompletableFuture with the GraphQL response data.
     */
    public CompletableFuture<JsonNode> declineOfferAsync(
            DeclineOfferInput input,
            String accessToken,
            RequestOptions requestOptions) {
        return CompletableFuture.supplyAsync(() -> {
            Map<String, Object> variables = new HashMap<>();
            variables.put("input", input.toMap());
            JsonNode data = dynamic.execute(OfferOperations.DECLINE_OFFER, variables, accessToken, requestOptions);
            return data.get("declineOffer");
        });
    }

    /**
     * Decline an active offer with default options.
     */
    public CompletableFuture<JsonNode> declineOfferAsync(DeclineOfferInput input, String accessToken) {
        return declineOfferAsync(input, accessToken, null);
    }

    /**
     * Counter an active offer with a new price.
     *
     * @param input The counter offer input.
     * @param accessToken Per-call token; overrides config fallback.
     * @param requestOptions Optional custom headers for this request.
     * @return CompletableFuture with the GraphQL response data.
     */
    public CompletableFuture<JsonNode> counterOfferAsync(
            CounterOfferInput input,
            String accessToken,
            RequestOptions requestOptions) {
        return CompletableFuture.supplyAsync(() -> {
            Map<String, Object> variables = new HashMap<>();
            variables.put("input", input.toMap());
            JsonNode data = dynamic.execute(OfferOperations.COUNTER_OFFER, variables, accessToken, requestOptions);
            return data.get("counterOffer");
        });
    }

    /**
     * Counter an active offer with default options.
     */
    public CompletableFuture<JsonNode> counterOfferAsync(CounterOfferInput input, String accessToken) {
        return counterOfferAsync(input, accessToken, null);
    }

    /**
     * Make an offer on a listing.
     *
     * @param input The make offer input.
     * @param accessToken Per-call token; overrides config fallback.
     * @param requestOptions Optional custom headers for this request.
     * @return CompletableFuture with the GraphQL response data.
     */
    public CompletableFuture<JsonNode> makeOfferAsync(
            MakeOfferInput input,
            String accessToken,
            RequestOptions requestOptions) {
        return CompletableFuture.supplyAsync(() -> {
            Map<String, Object> variables = new HashMap<>();
            variables.put("input", input.toMap());
            JsonNode data = dynamic.execute(OfferOperations.MAKE_OFFER, variables, accessToken, requestOptions);
            return data.get("makeOffer");
        });
    }

    /**
     * Make an offer with default options.
     */
    public CompletableFuture<JsonNode> makeOfferAsync(MakeOfferInput input, String accessToken) {
        return makeOfferAsync(input, accessToken, null);
    }

    /**
     * Retrieve the seller's negotiation history (latest offer per thread, grouped by item).
     *
     * @param input The seller negotiation history input.
     * @param accessToken Per-call token; overrides config fallback.
     * @param requestOptions Optional custom headers for this request.
     * @return CompletableFuture with the GraphQL response data.
     */
    public CompletableFuture<JsonNode> sellerNegotiationHistoryAsync(
            SellerNegotiationHistoryInput input,
            String accessToken,
            RequestOptions requestOptions) {
        return CompletableFuture.supplyAsync(() -> {
            Map<String, Object> variables = new HashMap<>();
            variables.put("input", input.toMap());
            JsonNode data = dynamic.execute(OfferOperations.SELLER_NEGOTIATION_HISTORY, variables, accessToken, requestOptions);
            return data.get("sellerNegotiationHistory");
        });
    }

    /**
     * Retrieve seller's negotiation history with default options.
     */
    public CompletableFuture<JsonNode> sellerNegotiationHistoryAsync(SellerNegotiationHistoryInput input, String accessToken) {
        return sellerNegotiationHistoryAsync(input, accessToken, null);
    }

    /**
     * Retrieve the buyer's negotiation history grouped by item.
     *
     * @param input The buyer negotiation history input.
     * @param accessToken Per-call token; overrides config fallback.
     * @param requestOptions Optional custom headers for this request.
     * @return CompletableFuture with the GraphQL response data.
     */
    public CompletableFuture<JsonNode> buyerNegotiationHistoryAsync(
            BuyerNegotiationHistoryInput input,
            String accessToken,
            RequestOptions requestOptions) {
        return CompletableFuture.supplyAsync(() -> {
            Map<String, Object> variables = new HashMap<>();
            variables.put("input", input.toMap());
            JsonNode data = dynamic.execute(OfferOperations.BUYER_NEGOTIATION_HISTORY, variables, accessToken, requestOptions);
            return data.get("buyerNegotiationHistory");
        });
    }

    /**
     * Retrieve buyer's negotiation history with default options.
     */
    public CompletableFuture<JsonNode> buyerNegotiationHistoryAsync(BuyerNegotiationHistoryInput input, String accessToken) {
        return buyerNegotiationHistoryAsync(input, accessToken, null);
    }

    /**
     * Escape hatch — send any GraphQL query/mutation and get the raw data back.
     *
     * @param query The GraphQL query string.
     * @param variables The variables map.
     * @param accessToken Per-call token; overrides config fallback.
     * @param requestOptions Optional custom headers for this request.
     * @return CompletableFuture with the raw GraphQL response data.
     */
    public CompletableFuture<JsonNode> executeRawAsync(
            String query,
            Map<String, Object> variables,
            String accessToken,
            RequestOptions requestOptions) {
        return CompletableFuture.supplyAsync(() ->
            dynamic.execute(query, variables, accessToken, requestOptions)
        );
    }

    /**
     * Execute raw query with default options.
     */
    public CompletableFuture<JsonNode> executeRawAsync(String query, Map<String, Object> variables, String accessToken) {
        return executeRawAsync(query, variables, accessToken, null);
    }
}
