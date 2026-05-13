package com.ebay.offersandleads.graphql.types;

import java.util.HashMap;
import java.util.Map;

/**
 * Filters for sellerNegotiationHistory and buyerNegotiationHistory.
 * All fields optional — server defaults: last 90 days, ACTIONABLE status, BUYER initiator.
 */
public final class NegotiationHistoryFiltersInput {
    private final String activeAfter;
    private final String activeBefore;
    private final String negotiationCreatorRole;
    private final PageInfoInput pagination;
    private final String statusFilter;

    private NegotiationHistoryFiltersInput(Builder builder) {
        this.activeAfter = builder.activeAfter;
        this.activeBefore = builder.activeBefore;
        this.negotiationCreatorRole = builder.negotiationCreatorRole;
        this.pagination = builder.pagination;
        this.statusFilter = builder.statusFilter;
    }

    public String getActiveAfter() {
        return activeAfter;
    }

    public String getActiveBefore() {
        return activeBefore;
    }

    public String getNegotiationCreatorRole() {
        return negotiationCreatorRole;
    }

    public PageInfoInput getPagination() {
        return pagination;
    }

    public String getStatusFilter() {
        return statusFilter;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        if (activeAfter != null) map.put("activeAfter", activeAfter);
        if (activeBefore != null) map.put("activeBefore", activeBefore);
        if (negotiationCreatorRole != null) map.put("negotiationCreatorRole", negotiationCreatorRole);
        if (pagination != null) map.put("pagination", pagination.toMap());
        if (statusFilter != null) map.put("statusFilter", statusFilter);
        return map;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String activeAfter;
        private String activeBefore;
        private String negotiationCreatorRole;
        private PageInfoInput pagination;
        private String statusFilter;

        private Builder() {
        }

        public Builder activeAfter(String activeAfter) {
            this.activeAfter = activeAfter;
            return this;
        }

        public Builder activeBefore(String activeBefore) {
            this.activeBefore = activeBefore;
            return this;
        }

        public Builder negotiationCreatorRole(String negotiationCreatorRole) {
            this.negotiationCreatorRole = negotiationCreatorRole;
            return this;
        }

        public Builder pagination(PageInfoInput pagination) {
            this.pagination = pagination;
            return this;
        }

        public Builder statusFilter(String statusFilter) {
            this.statusFilter = statusFilter;
            return this;
        }

        public NegotiationHistoryFiltersInput build() {
            return new NegotiationHistoryFiltersInput(this);
        }
    }
}
