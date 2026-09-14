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
 * This type provides classified lead responses including any contact information that prospective buyers have submitted.
 */
@jakarta.annotation.Generated("com.microsoft.kiota")
public class ClassifiedLeadResponses implements AdditionalDataHolder, Parsable {
    /**
     * Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     */
    private Map<String, Object> additionalData;
    /**
     * This field shows the first message that was sent from the prospective buyer to the seller. This will be the same content as in the &lt;b&gt;memberMessageExchange.question.body&lt;/b&gt; field, if returned. &lt;br&gt;&lt;br&gt;&lt;span class=&quot;tablenote&quot;&gt; &lt;strong&gt;Note:&lt;/strong&gt; Retrieve the &lt;b&gt;memberMessageExchange&lt;/b&gt; container to retrieve the entire exchange between the seller and the prospective buyer (all messages).&lt;/span&gt;
     */
    private String additionalInformation;
    /**
     * This type consists of contact information for the prospective buyer.
     */
    private ContactInformation contactInformation;
    /**
     * Email address for the prospective buyer, if that buyer was logged in to eBay.
     */
    private String email;
    /**
     * Email address for the prospective buyer as entered in the lead form on the &lt;b&gt;View Item&lt;/b&gt; page. Provides a way for sellers to contact prospective buyers who choose not to log in to eBay. This applies to only eBay Motors and eBay Motors categories.
     */
    private String externalEmail;
    /**
     * Boolean that indicates if a prospective buyer answered whether or not they would like financing. Entered on the lead form on the &lt;b&gt;View Item&lt;/b&gt; page. Applies to eBay Motors and Motors categories only.
     */
    private Boolean financingAnswer;
    /**
     * This type returns the amount charged for the lead service.
     */
    private LeadFee leadFee;
    /**
     * The enumeration value in this field indicates whether or not the seller has responded to the lead, or if this is new. For implementation help, refer to &lt;a href=&apos;https://developer.ebay.com/api-docs/sell/leads/types/api:LeadStatus&apos;&gt;eBay API documentation&lt;/a&gt;
     */
    private String leadStatus;
    /**
     * This type defines the field containing any mail message content shared between the seller and prospective buyer.
     */
    private MemberMessage memberMessage;
    /**
     * Date and time (in GMT) that the lead was submitted.
     */
    private String submittedTime;
    /**
     * The make of the vehicle the prospective buyer would like to trade in. Entered on the lead form on the &lt;b&gt;View Item&lt;/b&gt; page. Applies to eBay Motors and Motors categories only.
     */
    private String tradeInMake;
    /**
     * The model of the vehicle the prospective buyer would like to trade in. Entered on the lead form on the &lt;b&gt;View Item&lt;/b&gt; page. Applies to eBay Motors and Motors categories only.
     */
    private String tradeInModel;
    /**
     * The year of the vehicle the prospective buyer would like to trade in. Entered on the lead form on the &lt;b&gt;View Item&lt;/b&gt; page. Applies to eBay Motors and Motors categories only.
     */
    private String tradeInYear;
    /**
     * The eBay user ID of the user who is interested in the seller&apos;s item.
     */
    private String userId;
    /**
     * Instantiates a new {@link ClassifiedLeadResponses} and sets the default values.
     */
    public ClassifiedLeadResponses() {
        this.setAdditionalData(new HashMap<>());
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link ClassifiedLeadResponses}
     */
    @jakarta.annotation.Nonnull
    public static ClassifiedLeadResponses createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new ClassifiedLeadResponses();
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
     * Gets the additionalInformation property value. This field shows the first message that was sent from the prospective buyer to the seller. This will be the same content as in the &lt;b&gt;memberMessageExchange.question.body&lt;/b&gt; field, if returned. &lt;br&gt;&lt;br&gt;&lt;span class=&quot;tablenote&quot;&gt; &lt;strong&gt;Note:&lt;/strong&gt; Retrieve the &lt;b&gt;memberMessageExchange&lt;/b&gt; container to retrieve the entire exchange between the seller and the prospective buyer (all messages).&lt;/span&gt;
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getAdditionalInformation() {
        return this.additionalInformation;
    }
    /**
     * Gets the contactInformation property value. This type consists of contact information for the prospective buyer.
     * @return a {@link ContactInformation}
     */
    @jakarta.annotation.Nullable
    public ContactInformation getContactInformation() {
        return this.contactInformation;
    }
    /**
     * Gets the email property value. Email address for the prospective buyer, if that buyer was logged in to eBay.
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getEmail() {
        return this.email;
    }
    /**
     * Gets the externalEmail property value. Email address for the prospective buyer as entered in the lead form on the &lt;b&gt;View Item&lt;/b&gt; page. Provides a way for sellers to contact prospective buyers who choose not to log in to eBay. This applies to only eBay Motors and eBay Motors categories.
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getExternalEmail() {
        return this.externalEmail;
    }
    /**
     * The deserialization information for the current model
     * @return a {@link Map<String, java.util.function.Consumer<ParseNode>>}
     */
    @jakarta.annotation.Nonnull
    public Map<String, java.util.function.Consumer<ParseNode>> getFieldDeserializers() {
        final HashMap<String, java.util.function.Consumer<ParseNode>> deserializerMap = new HashMap<String, java.util.function.Consumer<ParseNode>>(13);
        deserializerMap.put("additionalInformation", (n) -> { this.setAdditionalInformation(n.getStringValue()); });
        deserializerMap.put("contactInformation", (n) -> { this.setContactInformation(n.getObjectValue(ContactInformation::createFromDiscriminatorValue)); });
        deserializerMap.put("email", (n) -> { this.setEmail(n.getStringValue()); });
        deserializerMap.put("externalEmail", (n) -> { this.setExternalEmail(n.getStringValue()); });
        deserializerMap.put("financingAnswer", (n) -> { this.setFinancingAnswer(n.getBooleanValue()); });
        deserializerMap.put("leadFee", (n) -> { this.setLeadFee(n.getObjectValue(LeadFee::createFromDiscriminatorValue)); });
        deserializerMap.put("leadStatus", (n) -> { this.setLeadStatus(n.getStringValue()); });
        deserializerMap.put("memberMessage", (n) -> { this.setMemberMessage(n.getObjectValue(MemberMessage::createFromDiscriminatorValue)); });
        deserializerMap.put("submittedTime", (n) -> { this.setSubmittedTime(n.getStringValue()); });
        deserializerMap.put("tradeInMake", (n) -> { this.setTradeInMake(n.getStringValue()); });
        deserializerMap.put("tradeInModel", (n) -> { this.setTradeInModel(n.getStringValue()); });
        deserializerMap.put("tradeInYear", (n) -> { this.setTradeInYear(n.getStringValue()); });
        deserializerMap.put("userId", (n) -> { this.setUserId(n.getStringValue()); });
        return deserializerMap;
    }
    /**
     * Gets the financingAnswer property value. Boolean that indicates if a prospective buyer answered whether or not they would like financing. Entered on the lead form on the &lt;b&gt;View Item&lt;/b&gt; page. Applies to eBay Motors and Motors categories only.
     * @return a {@link Boolean}
     */
    @jakarta.annotation.Nullable
    public Boolean getFinancingAnswer() {
        return this.financingAnswer;
    }
    /**
     * Gets the leadFee property value. This type returns the amount charged for the lead service.
     * @return a {@link LeadFee}
     */
    @jakarta.annotation.Nullable
    public LeadFee getLeadFee() {
        return this.leadFee;
    }
    /**
     * Gets the leadStatus property value. The enumeration value in this field indicates whether or not the seller has responded to the lead, or if this is new. For implementation help, refer to &lt;a href=&apos;https://developer.ebay.com/api-docs/sell/leads/types/api:LeadStatus&apos;&gt;eBay API documentation&lt;/a&gt;
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getLeadStatus() {
        return this.leadStatus;
    }
    /**
     * Gets the memberMessage property value. This type defines the field containing any mail message content shared between the seller and prospective buyer.
     * @return a {@link MemberMessage}
     */
    @jakarta.annotation.Nullable
    public MemberMessage getMemberMessage() {
        return this.memberMessage;
    }
    /**
     * Gets the submittedTime property value. Date and time (in GMT) that the lead was submitted.
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getSubmittedTime() {
        return this.submittedTime;
    }
    /**
     * Gets the tradeInMake property value. The make of the vehicle the prospective buyer would like to trade in. Entered on the lead form on the &lt;b&gt;View Item&lt;/b&gt; page. Applies to eBay Motors and Motors categories only.
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getTradeInMake() {
        return this.tradeInMake;
    }
    /**
     * Gets the tradeInModel property value. The model of the vehicle the prospective buyer would like to trade in. Entered on the lead form on the &lt;b&gt;View Item&lt;/b&gt; page. Applies to eBay Motors and Motors categories only.
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getTradeInModel() {
        return this.tradeInModel;
    }
    /**
     * Gets the tradeInYear property value. The year of the vehicle the prospective buyer would like to trade in. Entered on the lead form on the &lt;b&gt;View Item&lt;/b&gt; page. Applies to eBay Motors and Motors categories only.
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getTradeInYear() {
        return this.tradeInYear;
    }
    /**
     * Gets the userId property value. The eBay user ID of the user who is interested in the seller&apos;s item.
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getUserId() {
        return this.userId;
    }
    /**
     * Serializes information the current object
     * @param writer Serialization writer to use to serialize this model
     */
    public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
        Objects.requireNonNull(writer);
        writer.writeStringValue("additionalInformation", this.getAdditionalInformation());
        writer.writeObjectValue("contactInformation", this.getContactInformation());
        writer.writeStringValue("email", this.getEmail());
        writer.writeStringValue("externalEmail", this.getExternalEmail());
        writer.writeBooleanValue("financingAnswer", this.getFinancingAnswer());
        writer.writeObjectValue("leadFee", this.getLeadFee());
        writer.writeStringValue("leadStatus", this.getLeadStatus());
        writer.writeObjectValue("memberMessage", this.getMemberMessage());
        writer.writeStringValue("submittedTime", this.getSubmittedTime());
        writer.writeStringValue("tradeInMake", this.getTradeInMake());
        writer.writeStringValue("tradeInModel", this.getTradeInModel());
        writer.writeStringValue("tradeInYear", this.getTradeInYear());
        writer.writeStringValue("userId", this.getUserId());
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
     * Sets the additionalInformation property value. This field shows the first message that was sent from the prospective buyer to the seller. This will be the same content as in the &lt;b&gt;memberMessageExchange.question.body&lt;/b&gt; field, if returned. &lt;br&gt;&lt;br&gt;&lt;span class=&quot;tablenote&quot;&gt; &lt;strong&gt;Note:&lt;/strong&gt; Retrieve the &lt;b&gt;memberMessageExchange&lt;/b&gt; container to retrieve the entire exchange between the seller and the prospective buyer (all messages).&lt;/span&gt;
     * @param value Value to set for the additionalInformation property.
     */
    public void setAdditionalInformation(@jakarta.annotation.Nullable final String value) {
        this.additionalInformation = value;
    }
    /**
     * Sets the contactInformation property value. This type consists of contact information for the prospective buyer.
     * @param value Value to set for the contactInformation property.
     */
    public void setContactInformation(@jakarta.annotation.Nullable final ContactInformation value) {
        this.contactInformation = value;
    }
    /**
     * Sets the email property value. Email address for the prospective buyer, if that buyer was logged in to eBay.
     * @param value Value to set for the email property.
     */
    public void setEmail(@jakarta.annotation.Nullable final String value) {
        this.email = value;
    }
    /**
     * Sets the externalEmail property value. Email address for the prospective buyer as entered in the lead form on the &lt;b&gt;View Item&lt;/b&gt; page. Provides a way for sellers to contact prospective buyers who choose not to log in to eBay. This applies to only eBay Motors and eBay Motors categories.
     * @param value Value to set for the externalEmail property.
     */
    public void setExternalEmail(@jakarta.annotation.Nullable final String value) {
        this.externalEmail = value;
    }
    /**
     * Sets the financingAnswer property value. Boolean that indicates if a prospective buyer answered whether or not they would like financing. Entered on the lead form on the &lt;b&gt;View Item&lt;/b&gt; page. Applies to eBay Motors and Motors categories only.
     * @param value Value to set for the financingAnswer property.
     */
    public void setFinancingAnswer(@jakarta.annotation.Nullable final Boolean value) {
        this.financingAnswer = value;
    }
    /**
     * Sets the leadFee property value. This type returns the amount charged for the lead service.
     * @param value Value to set for the leadFee property.
     */
    public void setLeadFee(@jakarta.annotation.Nullable final LeadFee value) {
        this.leadFee = value;
    }
    /**
     * Sets the leadStatus property value. The enumeration value in this field indicates whether or not the seller has responded to the lead, or if this is new. For implementation help, refer to &lt;a href=&apos;https://developer.ebay.com/api-docs/sell/leads/types/api:LeadStatus&apos;&gt;eBay API documentation&lt;/a&gt;
     * @param value Value to set for the leadStatus property.
     */
    public void setLeadStatus(@jakarta.annotation.Nullable final String value) {
        this.leadStatus = value;
    }
    /**
     * Sets the memberMessage property value. This type defines the field containing any mail message content shared between the seller and prospective buyer.
     * @param value Value to set for the memberMessage property.
     */
    public void setMemberMessage(@jakarta.annotation.Nullable final MemberMessage value) {
        this.memberMessage = value;
    }
    /**
     * Sets the submittedTime property value. Date and time (in GMT) that the lead was submitted.
     * @param value Value to set for the submittedTime property.
     */
    public void setSubmittedTime(@jakarta.annotation.Nullable final String value) {
        this.submittedTime = value;
    }
    /**
     * Sets the tradeInMake property value. The make of the vehicle the prospective buyer would like to trade in. Entered on the lead form on the &lt;b&gt;View Item&lt;/b&gt; page. Applies to eBay Motors and Motors categories only.
     * @param value Value to set for the tradeInMake property.
     */
    public void setTradeInMake(@jakarta.annotation.Nullable final String value) {
        this.tradeInMake = value;
    }
    /**
     * Sets the tradeInModel property value. The model of the vehicle the prospective buyer would like to trade in. Entered on the lead form on the &lt;b&gt;View Item&lt;/b&gt; page. Applies to eBay Motors and Motors categories only.
     * @param value Value to set for the tradeInModel property.
     */
    public void setTradeInModel(@jakarta.annotation.Nullable final String value) {
        this.tradeInModel = value;
    }
    /**
     * Sets the tradeInYear property value. The year of the vehicle the prospective buyer would like to trade in. Entered on the lead form on the &lt;b&gt;View Item&lt;/b&gt; page. Applies to eBay Motors and Motors categories only.
     * @param value Value to set for the tradeInYear property.
     */
    public void setTradeInYear(@jakarta.annotation.Nullable final String value) {
        this.tradeInYear = value;
    }
    /**
     * Sets the userId property value. The eBay user ID of the user who is interested in the seller&apos;s item.
     * @param value Value to set for the userId property.
     */
    public void setUserId(@jakarta.annotation.Nullable final String value) {
        this.userId = value;
    }
}
