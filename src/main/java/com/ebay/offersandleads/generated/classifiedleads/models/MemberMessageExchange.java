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

package com.ebay.offersandleads.generated.classifiedleads.models;

import com.microsoft.kiota.serialization.AdditionalDataHolder;
import com.microsoft.kiota.serialization.Parsable;
import com.microsoft.kiota.serialization.ParseNode;
import com.microsoft.kiota.serialization.SerializationWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
/**
 * This type defines the fields containing detailed information about a member-to-member message.
 */
@jakarta.annotation.Generated("com.microsoft.kiota")
public class MemberMessageExchange implements AdditionalDataHolder, Parsable {
    /**
     * Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     */
    private Map<String, Object> additionalData;
    /**
     * This is the date the message was created. It is returned if the parent container is returned.
     */
    private String creationDate;
    /**
     * This contains all the information about the question being asked. It is returned if the parent container is returned.
     */
    private Question question;
    /**
     * This is an answer to the question. It contains the body of the seller&apos;s response message, if sent.
     */
    private String response;
    /**
     * Instantiates a new {@link MemberMessageExchange} and sets the default values.
     */
    public MemberMessageExchange() {
        this.setAdditionalData(new HashMap<>());
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link MemberMessageExchange}
     */
    @jakarta.annotation.Nonnull
    public static MemberMessageExchange createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new MemberMessageExchange();
    }
    /**
     * Gets the AdditionalData property value. Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     * @return a {@link Map<String, Object>}
     */
    @jakarta.annotation.Nonnull
    public Map<String, Object> getAdditionalData() {
        return this.additionalData;
    }
    /**
     * Gets the creationDate property value. This is the date the message was created. It is returned if the parent container is returned.
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getCreationDate() {
        return this.creationDate;
    }
    /**
     * The deserialization information for the current model
     * @return a {@link Map<String, java.util.function.Consumer<ParseNode>>}
     */
    @jakarta.annotation.Nonnull
    public Map<String, java.util.function.Consumer<ParseNode>> getFieldDeserializers() {
        final HashMap<String, java.util.function.Consumer<ParseNode>> deserializerMap = new HashMap<String, java.util.function.Consumer<ParseNode>>(3);
        deserializerMap.put("creationDate", (n) -> { this.setCreationDate(n.getStringValue()); });
        deserializerMap.put("question", (n) -> { this.setQuestion(n.getObjectValue(Question::createFromDiscriminatorValue)); });
        deserializerMap.put("response", (n) -> { this.setResponse(n.getStringValue()); });
        return deserializerMap;
    }
    /**
     * Gets the question property value. This contains all the information about the question being asked. It is returned if the parent container is returned.
     * @return a {@link Question}
     */
    @jakarta.annotation.Nullable
    public Question getQuestion() {
        return this.question;
    }
    /**
     * Gets the response property value. This is an answer to the question. It contains the body of the seller&apos;s response message, if sent.
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getResponse() {
        return this.response;
    }
    /**
     * Serializes information the current object
     * @param writer Serialization writer to use to serialize this model
     */
    public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
        Objects.requireNonNull(writer);
        writer.writeStringValue("creationDate", this.getCreationDate());
        writer.writeObjectValue("question", this.getQuestion());
        writer.writeStringValue("response", this.getResponse());
        writer.writeAdditionalData(this.getAdditionalData());
    }
    /**
     * Sets the AdditionalData property value. Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     * @param value Value to set for the AdditionalData property.
     */
    public void setAdditionalData(@jakarta.annotation.Nullable final Map<String, Object> value) {
        this.additionalData = value;
    }
    /**
     * Sets the creationDate property value. This is the date the message was created. It is returned if the parent container is returned.
     * @param value Value to set for the creationDate property.
     */
    public void setCreationDate(@jakarta.annotation.Nullable final String value) {
        this.creationDate = value;
    }
    /**
     * Sets the question property value. This contains all the information about the question being asked. It is returned if the parent container is returned.
     * @param value Value to set for the question property.
     */
    public void setQuestion(@jakarta.annotation.Nullable final Question value) {
        this.question = value;
    }
    /**
     * Sets the response property value. This is an answer to the question. It contains the body of the seller&apos;s response message, if sent.
     * @param value Value to set for the response property.
     */
    public void setResponse(@jakarta.annotation.Nullable final String value) {
        this.response = value;
    }
}
