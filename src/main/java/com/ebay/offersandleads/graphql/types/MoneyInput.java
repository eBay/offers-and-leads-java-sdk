package com.ebay.offersandleads.graphql.types;

import java.util.HashMap;
import java.util.Map;

/**
 * Money input type for GraphQL queries.
 */
public final class MoneyInput {
    private final String value;
    private final String currency;

    public MoneyInput(String value, String currency) {
        this.value = value;
        this.currency = currency;
    }

    public String getValue() {
        return value;
    }

    public String getCurrency() {
        return currency;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("value", value);
        map.put("currency", currency);
        return map;
    }
}
