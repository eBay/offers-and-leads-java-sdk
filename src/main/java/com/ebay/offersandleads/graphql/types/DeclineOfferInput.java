package com.ebay.offersandleads.graphql.types;

import java.util.HashMap;
import java.util.Map;

/**
 * Input for declineOffer mutation.
 */
public final class DeclineOfferInput {
    private final String itemId;
    private final String offerId;
    private final String message;

    public DeclineOfferInput(String itemId, String offerId, String message) {
        this.itemId = itemId;
        this.offerId = offerId;
        this.message = message;
    }

    public DeclineOfferInput(String itemId, String offerId) {
        this(itemId, offerId, null);
    }

    public String getItemId() {
        return itemId;
    }

    public String getOfferId() {
        return offerId;
    }

    public String getMessage() {
        return message;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("itemId", itemId);
        map.put("offerId", offerId);
        if (message != null) {
            map.put("message", message);
        }
        return map;
    }
}
