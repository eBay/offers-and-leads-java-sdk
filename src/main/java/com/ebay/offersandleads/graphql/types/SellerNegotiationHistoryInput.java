package com.ebay.offersandleads.graphql.types;

import java.util.HashMap;
import java.util.Map;

/**
 * Input for sellerNegotiationHistory query.
 */
public final class SellerNegotiationHistoryInput {
    private final NegotiationHistoryFiltersInput filters;

    public SellerNegotiationHistoryInput(NegotiationHistoryFiltersInput filters) {
        this.filters = filters;
    }

    public SellerNegotiationHistoryInput() {
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
