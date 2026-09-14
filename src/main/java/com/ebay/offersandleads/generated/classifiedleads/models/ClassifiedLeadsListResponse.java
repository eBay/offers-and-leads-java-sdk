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
 * This type contains an array of for the seller&apos;s active classified ad listings, the total number of items, and leads.
 */
@jakarta.annotation.Generated("com.microsoft.kiota")
public class ClassifiedLeadsListResponse implements AdditionalDataHolder, Parsable {
    /**
     * Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     */
    private Map<String, Object> additionalData;
    /**
     * An array of leads for the seller&apos;s active classified ad listings.
     */
    private java.util.List<ClassifiedLead> classifiedLeads;
    /**
     * The total number of listings returned.
     */
    private Integer totalItems;
    /**
     * The total number of leads returned for all listings.
     */
    private Integer totalLeads;
    /**
     * Instantiates a new {@link ClassifiedLeadsListResponse} and sets the default values.
     */
    public ClassifiedLeadsListResponse() {
        this.setAdditionalData(new HashMap<>());
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link ClassifiedLeadsListResponse}
     */
    @jakarta.annotation.Nonnull
    public static ClassifiedLeadsListResponse createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new ClassifiedLeadsListResponse();
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
     * Gets the classifiedLeads property value. An array of leads for the seller&apos;s active classified ad listings.
     * @return a {@link java.util.List<ClassifiedLead>}
     */
    @jakarta.annotation.Nullable
    public java.util.List<ClassifiedLead> getClassifiedLeads() {
        return this.classifiedLeads;
    }
    /**
     * The deserialization information for the current model
     * @return a {@link Map<String, java.util.function.Consumer<ParseNode>>}
     */
    @jakarta.annotation.Nonnull
    public Map<String, java.util.function.Consumer<ParseNode>> getFieldDeserializers() {
        final HashMap<String, java.util.function.Consumer<ParseNode>> deserializerMap = new HashMap<String, java.util.function.Consumer<ParseNode>>(3);
        deserializerMap.put("classifiedLeads", (n) -> { this.setClassifiedLeads(n.getCollectionOfObjectValues(ClassifiedLead::createFromDiscriminatorValue)); });
        deserializerMap.put("totalItems", (n) -> { this.setTotalItems(n.getIntegerValue()); });
        deserializerMap.put("totalLeads", (n) -> { this.setTotalLeads(n.getIntegerValue()); });
        return deserializerMap;
    }
    /**
     * Gets the totalItems property value. The total number of listings returned.
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getTotalItems() {
        return this.totalItems;
    }
    /**
     * Gets the totalLeads property value. The total number of leads returned for all listings.
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getTotalLeads() {
        return this.totalLeads;
    }
    /**
     * Serializes information the current object
     * @param writer Serialization writer to use to serialize this model
     */
    public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
        Objects.requireNonNull(writer);
        writer.writeCollectionOfObjectValues("classifiedLeads", this.getClassifiedLeads());
        writer.writeIntegerValue("totalItems", this.getTotalItems());
        writer.writeIntegerValue("totalLeads", this.getTotalLeads());
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
     * Sets the classifiedLeads property value. An array of leads for the seller&apos;s active classified ad listings.
     * @param value Value to set for the classifiedLeads property.
     */
    public void setClassifiedLeads(@jakarta.annotation.Nullable final java.util.List<ClassifiedLead> value) {
        this.classifiedLeads = value;
    }
    /**
     * Sets the totalItems property value. The total number of listings returned.
     * @param value Value to set for the totalItems property.
     */
    public void setTotalItems(@jakarta.annotation.Nullable final Integer value) {
        this.totalItems = value;
    }
    /**
     * Sets the totalLeads property value. The total number of leads returned for all listings.
     * @param value Value to set for the totalLeads property.
     */
    public void setTotalLeads(@jakarta.annotation.Nullable final Integer value) {
        this.totalLeads = value;
    }
}
