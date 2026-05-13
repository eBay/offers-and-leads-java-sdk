package com.ebay.offersandleads.graphql;

/**
 * GraphQL operations for Offers API.
 */
public final class OfferOperations {

    public static final String ACCEPT_OFFER = """
        mutation AcceptOffer($input: AcceptOfferInput!) {
            acceptOffer(input: $input) {
                __typename
                ... on AcceptOfferSent {
                    offer {
                        offerId
                        offerCreatorRole
                        status
                        offerCreatorUser {
                            shippingZone {
                                postalCode
                            }
                        }
                        offerPrice {
                            original { value currency }
                            converted { value currency }
                        }
                        quantity
                        createdAt
                        updatedAt
                        expiresAt
                        message
                    }
                    purchaseReference {
                        ... on ItemCommitment {
                            __typename
                            itemCommitmentId
                        }
                    }
                }
                ... on OfferBusinessRulesViolated {
                    errorCode
                    errorMessage
                    violations { ruleDescription }
                }
                ... on ReferenceArgumentsNotFound {
                    errorCode
                    errorMessage
                    argumentNames
                }
            }
        }
        """;

    public static final String DECLINE_OFFER = """
        mutation DeclineOffer($input: DeclineOfferInput!) {
            declineOffer(input: $input) {
                __typename
                ... on DeclineOfferSent {
                    offer {
                        offerId
                        status
                    }
                }
                ... on OfferBusinessRulesViolated {
                    errorCode
                    errorMessage
                    violations { ruleDescription }
                }
                ... on ReferenceArgumentsNotFound {
                    errorCode
                    errorMessage
                    argumentNames
                }
            }
        }
        """;

    public static final String COUNTER_OFFER = """
        mutation CounterOffer($input: CounterOfferInput!) {
            counterOffer(input: $input) {
                __typename
                ... on CounterOfferSent {
                    offer {
                        offerId
                        offerCreatorRole
                        status
                        offerPrice {
                            original { value currency }
                            converted { value currency }
                        }
                        quantity
                        createdAt
                        updatedAt
                        expiresAt
                        message
                    }
                }
                ... on OfferBusinessRulesViolated {
                    errorCode
                    errorMessage
                    violations { ruleDescription }
                }
                ... on ReferenceArgumentsNotFound {
                    errorCode
                    errorMessage
                    argumentNames
                }
            }
        }
        """;

    public static final String MAKE_OFFER = """
        mutation MakeOffer($input: MakeOfferInput!) {
            makeOffer(input: $input) {
                __typename
                ... on MakeOfferSent {
                    offer {
                        offerId
                        offerCreatorRole
                        status
                        offerPrice {
                            original { value currency }
                            converted { value currency }
                        }
                        quantity
                        createdAt
                        updatedAt
                        expiresAt
                        message
                    }
                }
                ... on OfferBusinessRulesViolated {
                    errorCode
                    errorMessage
                    violations { ruleDescription }
                }
                ... on ReferenceArgumentsNotFound {
                    errorCode
                    errorMessage
                    argumentNames
                }
            }
        }
        """;

    public static final String SELLER_NEGOTIATION_HISTORY = """
        query SellerNegotiationHistory($input: SellerNegotiationHistoryInput!) {
            sellerNegotiationHistory(input: $input) {
                __typename
                ... on SellerNegotiationHistorySuccess {
                    itemNegotiations {
                        item {
                            itemId
                        }
                        negotiations {
                            negotiationId
                            offers {
                                offerId
                                status
                                offerCreatorRole
                                offerPrice {
                                    original { value currency }
                                    converted { value currency }
                                }
                                quantity
                                createdAt
                                updatedAt
                                expiresAt
                                message
                            }
                            latestOffer {
                                offerId
                                status
                                offerCreatorRole
                                quantity
                                offerPrice {
                                    original { value currency }
                                    converted { value currency }
                                }
                                createdAt
                                updatedAt
                                expiresAt
                            }
                            offerCapabilities {
                                negotiable
                            }
                            target {
                                ... on Item {
                                    itemId
                                }
                            }
                        }
                    }
                    pagination {
                        nextCursor
                        previousCursor
                    }
                }
            }
        }
        """;

    public static final String BUYER_NEGOTIATION_HISTORY = """
        query BuyerNegotiationHistory($input: BuyerNegotiationHistoryInput!) {
            buyerNegotiationHistory(input: $input) {
                __typename
                ... on BuyerNegotiationHistorySuccess {
                    itemNegotiations {
                        item {
                            itemId
                        }
                        negotiations {
                            negotiationId
                            offers {
                                offerId
                                status
                                offerCreatorRole
                                offerPrice {
                                    original { value currency }
                                    converted { value currency }
                                }
                                quantity
                                createdAt
                                updatedAt
                                expiresAt
                                message
                            }
                            latestOffer {
                                offerId
                                status
                                offerCreatorRole
                                quantity
                                offerPrice {
                                    original { value currency }
                                    converted { value currency }
                                }
                                createdAt
                                updatedAt
                                expiresAt
                            }
                            offerCapabilities {
                                negotiable
                            }
                            target {
                                ... on Item {
                                    itemId
                                }
                            }
                        }
                    }
                    pagination {
                        nextCursor
                        previousCursor
                    }
                }
            }
        }
        """;

    private OfferOperations() {
        // Utility class
    }
}
