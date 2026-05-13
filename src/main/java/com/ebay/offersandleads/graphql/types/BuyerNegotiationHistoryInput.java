package com.ebay.offersandleads.graphql.types;

import java.util.HashMap;
import java.util.Map;

/**
 * Input for buyerNegotiationHistory query.
 */
public final class BuyerNegotiationHistoryInput {
    private final NegotiationHistoryFiltersInput filters;

    public BuyerNegotiationHistoryInput(NegotiationHistoryFiltersInput filters) {
        this.filters = filters;
    }

    public BuyerNegotiationHistoryInput() {
        this(null);
    }

    public NegotiationHistoryFiltersInput getFilters() {
        return filters;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        if (filters != null) {
            map.put("filters", filters.toMap());
        }
        return map;
    }
}
