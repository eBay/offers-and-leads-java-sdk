package com.ebay.offersandleads.graphql.types;

import java.util.HashMap;
import java.util.Map;

/**
 * Input for makeOffer mutation.
 */
public final class MakeOfferInput {
    private final String itemId;
    private final MoneyInput proposedPrice;
    private final Integer quantity;
    private final String message;

    public MakeOfferInput(String itemId, MoneyInput proposedPrice, Integer quantity, String message) {
        this.itemId = itemId;
        this.proposedPrice = proposedPrice;
        this.quantity = quantity;
        this.message = message;
    }

    public MakeOfferInput(String itemId, MoneyInput proposedPrice) {
        this(itemId, proposedPrice, null, null);
    }

    public String getItemId() {
        return itemId;
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
