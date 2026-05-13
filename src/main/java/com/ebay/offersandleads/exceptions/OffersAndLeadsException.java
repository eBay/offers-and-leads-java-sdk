package com.ebay.offersandleads.exceptions;

/**
 * Base exception for Offers and Leads SDK errors.
 */
public class OffersAndLeadsException extends RuntimeException {
    public OffersAndLeadsException(String message) {
        super(message);
    }

    public OffersAndLeadsException(String message, Throwable cause) {
        super(message, cause);
    }
}
