package com.ebay.offersandleads.graphql.types;

import java.util.HashMap;
import java.util.Map;

/**
 * Input for counterOffer mutation.
 */
public final class CounterOfferInput {
    private final String itemId;
    private final String offerId;
    private final MoneyInput proposedPrice;
    private final Integer quantity;
    private final String message;

    public CounterOfferInput(String itemId, String offerId, MoneyInput proposedPrice, Integer quantity, String message) {
        this.itemId = itemId;
        this.offerId = offerId;
        this.proposedPrice = proposedPrice;
        this.quantity = quantity;
        this.message = message;
    }

    public CounterOfferInput(String itemId, String offerId, MoneyInput proposedPrice) {
        this(itemId, offerId, proposedPrice, null, null);
    }

    public String getItemId() {
        return itemId;
    }

    public String getOfferId() {
        return offerId;
    }

    public MoneyInput getProposedPrice() {
        return proposedPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getMessage() {
        return message;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("itemId", itemId);
        map.put("offerId", offerId);
        map.put("proposedPrice", proposedPrice.toMap());
        if (quantity != null) {
            map.put("quantity", quantity);
        }
        if (message != null) {
            map.put("message", message);
        }
        return map;
    }
}
