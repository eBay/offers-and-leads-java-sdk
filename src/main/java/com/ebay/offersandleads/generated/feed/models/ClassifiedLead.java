package com.ebay.offersandleads.generated.feed.models;

import com.microsoft.kiota.serialization.AdditionalDataHolder;
import com.microsoft.kiota.serialization.Parsable;
import com.microsoft.kiota.serialization.ParseNode;
import com.microsoft.kiota.serialization.SerializationWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
/**
 * This type contains the classified lead ID and other information.
 */
@jakarta.annotation.Generated("com.microsoft.kiota")
public class ClassifiedLead implements AdditionalDataHolder, Parsable {
    /**
     * Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     */
    private Map<String, Object> additionalData;
    /**
     * The unique identifier of the listing.
     */
    private String itemId;
    /**
     * The title of the listing.&lt;br&gt;&lt;br&gt;&lt;b&gt;Max length:&lt;/b&gt; 80.
     */
    private String itemTitle;
    /**
     * An array of the classified lead responses.
     */
    private java.util.List<ClassifiedLeadResponses> responses;
    /**
     * Instantiates a new {@link ClassifiedLead} and sets the default values.
     */
    public ClassifiedLead() {
        this.setAdditionalData(new HashMap<>());
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link ClassifiedLead}
     */
    @jakarta.annotation.Nonnull
    public static ClassifiedLead createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new ClassifiedLead();
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
     * The deserialization information for the current model
     * @return a {@link Map<String, java.util.function.Consumer<ParseNode>>}
     */
    @jakarta.annotation.Nonnull
    public Map<String, java.util.function.Consumer<ParseNode>> getFieldDeserializers() {
        final HashMap<String, java.util.function.Consumer<ParseNode>> deserializerMap = new HashMap<String, java.util.function.Consumer<ParseNode>>(3);
        deserializerMap.put("itemId", (n) -> { this.setItemId(n.getStringValue()); });
        deserializerMap.put("itemTitle", (n) -> { this.setItemTitle(n.getStringValue()); });
        deserializerMap.put("responses", (n) -> { this.setResponses(n.getCollectionOfObjectValues(ClassifiedLeadResponses::createFromDiscriminatorValue)); });
        return deserializerMap;
    }
    /**
     * Gets the itemId property value. The unique identifier of the listing.
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getItemId() {
        return this.itemId;
    }
    /**
     * Gets the itemTitle property value. The title of the listing.&lt;br&gt;&lt;br&gt;&lt;b&gt;Max length:&lt;/b&gt; 80.
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getItemTitle() {
        return this.itemTitle;
    }
    /**
     * Gets the responses property value. An array of the classified lead responses.
     * @return a {@link java.util.List<ClassifiedLeadResponses>}
     */
    @jakarta.annotation.Nullable
    public java.util.List<ClassifiedLeadResponses> getResponses() {
        return this.responses;
    }
    /**
     * Serializes information the current object
     * @param writer Serialization writer to use to serialize this model
     */
    public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
        Objects.requireNonNull(writer);
        writer.writeStringValue("itemId", this.getItemId());
        writer.writeStringValue("itemTitle", this.getItemTitle());
        writer.writeCollectionOfObjectValues("responses", this.getResponses());
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
     * Sets the itemId property value. The unique identifier of the listing.
     * @param value Value to set for the itemId property.
     */
    public void setItemId(@jakarta.annotation.Nullable final String value) {
        this.itemId = value;
    }
    /**
     * Sets the itemTitle property value. The title of the listing.&lt;br&gt;&lt;br&gt;&lt;b&gt;Max length:&lt;/b&gt; 80.
     * @param value Value to set for the itemTitle property.
     */
    public void setItemTitle(@jakarta.annotation.Nullable final String value) {
        this.itemTitle = value;
    }
    /**
     * Sets the responses property value. An array of the classified lead responses.
     * @param value Value to set for the responses property.
     */
    public void setResponses(@jakarta.annotation.Nullable final java.util.List<ClassifiedLeadResponses> value) {
        this.responses = value;
    }
}
