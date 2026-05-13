package com.ebay.offersandleads.graphql.types;

import java.util.HashMap;
import java.util.Map;

/**
 * Pagination input for GraphQL queries.
 */
public final class PageInfoInput {
    private final int maxPageSize;
    private final String pageCursor;

    public PageInfoInput(int maxPageSize, String pageCursor) {
        this.maxPageSize = maxPageSize;
        this.pageCursor = pageCursor;
    }

    public PageInfoInput(int maxPageSize) {
        this(maxPageSize, null);
    }

    public int getMaxPageSize() {
        return maxPageSize;
    }

    public String getPageCursor() {
        return pageCursor;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("maxPageSize", maxPageSize);
        if (pageCursor != null) {
            map.put("pageCursor", pageCursor);
        }
        return map;
    }
}
