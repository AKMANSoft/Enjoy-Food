package com.akman.enjoyfood.newOrder;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import org.json.JSONObject;

@Generated("org.jsonschema2pojo")
public class Modifier {

    private String id;
    private String storeId;
    private String modifierName;
    private String price;
    private String qtySel;
    private String status;
    private Map<String, Object> additionalProperties = new HashMap<>();

    public Modifier(JSONObject modifiers) {

        this.id = modifiers.getString("id");
        this.storeId = modifiers.getString("store_id");
        this.modifierName = modifiers.getString("modifier_name");
        this.price = modifiers.getString("price");
        this.qtySel = modifiers.getString("qty_sel");
        this.status = modifiers.getString("status");
    }

    /**
     *
     * @return The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return The storeId
     */
    public String getStoreId() {
        return storeId;
    }

    /**
     *
     * @param storeId The store_id
     */
    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    /**
     *
     * @return The modifierName
     */
    public String getModifierName() {
        return modifierName;
    }

    /**
     *
     * @param modifierName The modifier_name
     */
    public void setModifierName(String modifierName) {
        this.modifierName = modifierName;
    }

    /**
     *
     * @return The price
     */
    public String getPrice() {
        return price;
    }

    /**
     *
     * @param price The price
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     *
     * @return The qtySel
     */
    public String getQtySel() {
        return qtySel;
    }

    /**
     *
     * @param qtySel The qty_sel
     */
    public void setQtySel(String qtySel) {
        this.qtySel = qtySel;
    }

    /**
     *
     * @return The status
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param status The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return modifierName;
    }
    
    

}
