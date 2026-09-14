// Copyright 2026 eBay Inc.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.ebay.offersandleads.clients.graphql

import com.ebay.offersandleads.configuration.OffersAndLeadsConfiguration
import com.ebay.offersandleads.configuration.TokenContext
import com.ebay.offersandleads.configuration.RequestOptions
import com.ebay.offersandleads.exceptions.GraphQLException
import com.ebay.offersandleads.generated.graphql.*
import com.ebay.offersandleads.generated.graphql.type.*
import com.apollographql.apollo.ApolloClient
import kotlinx.coroutines.future.future
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class OffersGraphQLClient @JvmOverloads internal constructor(
    private val apolloClient: ApolloClient,
    private val dynamicClient: DynamicGraphQLClient,
    private val config: OffersAndLeadsConfiguration,
    private val scope: CoroutineScope = CoroutineScope(Dispatchers.IO)
) {

    suspend fun acceptOfferAsync(
        input: AcceptOfferInput,
        accessToken: String? = null
    ): AcceptOfferMutation.AcceptOffer? {
        val prev = TokenContext.CURRENT.get()
        TokenContext.CURRENT.set(accessToken ?: prev)
        try {
            val response = apolloClient.mutation(AcceptOfferMutation(input)).execute()
            if (response.hasErrors()) {
                throw GraphQLException(response.errors!!.map { it.message })
            }
            return response.dataAssertNoErrors.acceptOffer
        } finally {
            TokenContext.CURRENT.set(prev)
        }
    }

    suspend fun buyerNegotiationHistoryAsync(
        input: BuyerNegotiationHistoryInput,
        accessToken: String? = null
    ): BuyerNegotiationHistoryQuery.BuyerNegotiationHistory? {
        val prev = TokenContext.CURRENT.get()
        TokenContext.CURRENT.set(accessToken ?: prev)
        try {
            val response = apolloClient.query(BuyerNegotiationHistoryQuery(input)).execute()
            if (response.hasErrors()) {
                throw GraphQLException(response.errors!!.map { it.message })
            }
            return response.dataAssertNoErrors.buyerNegotiationHistory
        } finally {
            TokenContext.CURRENT.set(prev)
        }
    }

    suspend fun counterOfferAsync(
        input: CounterOfferInput,
        accessToken: String? = null
    ): CounterOfferMutation.CounterOffer? {
        val prev = TokenContext.CURRENT.get()
        TokenContext.CURRENT.set(accessToken ?: prev)
        try {
            val response = apolloClient.mutation(CounterOfferMutation(input)).execute()
            if (response.hasErrors()) {
                throw GraphQLException(response.errors!!.map { it.message })
            }
            return response.dataAssertNoErrors.counterOffer
        } finally {
            TokenContext.CURRENT.set(prev)
        }
    }

    suspend fun declineOfferAsync(
        input: DeclineOfferInput,
        accessToken: String? = null
    ): DeclineOfferMutation.DeclineOffer? {
        val prev = TokenContext.CURRENT.get()
        TokenContext.CURRENT.set(accessToken ?: prev)
        try {
            val response = apolloClient.mutation(DeclineOfferMutation(input)).execute()
            if (response.hasErrors()) {
                throw GraphQLException(response.errors!!.map { it.message })
            }
            return response.dataAssertNoErrors.declineOffer
        } finally {
            TokenContext.CURRENT.set(prev)
        }
    }

    suspend fun makeOfferAsync(
        input: MakeOfferInput,
        accessToken: String? = null
    ): MakeOfferMutation.MakeOffer? {
        val prev = TokenContext.CURRENT.get()
        TokenContext.CURRENT.set(accessToken ?: prev)
        try {
            val response = apolloClient.mutation(MakeOfferMutation(input)).execute()
            if (response.hasErrors()) {
                throw GraphQLException(response.errors!!.map { it.message })
            }
            return response.dataAssertNoErrors.makeOffer
        } finally {
            TokenContext.CURRENT.set(prev)
        }
    }

    suspend fun sellerNegotiationHistoryAsync(
        input: SellerNegotiationHistoryInput,
        accessToken: String? = null
    ): SellerNegotiationHistoryQuery.SellerNegotiationHistory? {
        val prev = TokenContext.CURRENT.get()
        TokenContext.CURRENT.set(accessToken ?: prev)
        try {
            val response = apolloClient.query(SellerNegotiationHistoryQuery(input)).execute()
            if (response.hasErrors()) {
                throw GraphQLException(response.errors!!.map { it.message })
            }
            return response.dataAssertNoErrors.sellerNegotiationHistory
        } finally {
            TokenContext.CURRENT.set(prev)
        }
    }

    fun acceptOfferFuture(input: AcceptOfferInput, accessToken: String?) =
        scope.future { acceptOfferAsync(input, accessToken) }

    fun buyerNegotiationHistoryFuture(input: BuyerNegotiationHistoryInput, accessToken: String?) =
        scope.future { buyerNegotiationHistoryAsync(input, accessToken) }

    fun counterOfferFuture(input: CounterOfferInput, accessToken: String?) =
        scope.future { counterOfferAsync(input, accessToken) }

    fun declineOfferFuture(input: DeclineOfferInput, accessToken: String?) =
        scope.future { declineOfferAsync(input, accessToken) }

    fun makeOfferFuture(input: MakeOfferInput, accessToken: String?) =
        scope.future { makeOfferAsync(input, accessToken) }

    fun sellerNegotiationHistoryFuture(input: SellerNegotiationHistoryInput, accessToken: String?) =
        scope.future { sellerNegotiationHistoryAsync(input, accessToken) }

    /**
     * Execute an arbitrary GraphQL query or mutation (escape hatch).
     *
     * **WARNING — GraphQL injection risk.** Never interpolate user-supplied input
     * directly into the query string. Always pass dynamic values via [variables]
     * so the server handles escaping.
     */
    fun executeRawUnsafe(
        query: String,
        variables: Any?,
        accessToken: String?,
        requestOptions: RequestOptions? = null
    ) = dynamicClient.executeRawUnsafe(query, variables, accessToken, requestOptions)
}
