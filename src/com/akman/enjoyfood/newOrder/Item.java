//-----------------------------------com.akman.nJoyful.Item.java-----------------------------------
package com.akman.enjoyfood.newOrder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import org.json.JSONObject;

@Generated("org.jsonschema2pojo")
public class Item {

    private String modifierIds;
    private String itemPrinted;
    private String odId;
    private String specialReq;
    private String orderQty;
    private String itemName;
    private String orderItem;
    private String status;
    private List<Modifier> modifiers = new ArrayList<>();
    private Map<String, Object> additionalProperties = new HashMap<>();

    public Item(JSONObject item) {

        modifierIds = item.getString("modifier_ids");
        itemPrinted = item.getString("item_printed");
        odId = item.getString("od_id");
        specialReq = item.getString("special_req");
        orderQty = item.getString("order_qty");
        itemName = item.getString("item_name");
        orderItem = item.getString("order_item");
        status = item.getString("status");
        modifiers = new ArrayList<>();
        additionalProperties = new HashMap<>();
        
        for (int i = 0; i < item.getJSONArray("modifiers").length(); i++) {
            
            this.modifiers.add(new Modifier(item.getJSONArray("modifiers").getJSONObject(i)));
            
        }

    }

    /**
     *
     * @return The modifierIds
     */
    public String getModifierIds() {
        return modifierIds;
    }

    /**
     *
     * @param modifierIds The modifier_ids
     */
    public void setModifierIds(String modifierIds) {
        this.modifierIds = modifierIds;
    }

    /**
     *
     * @return The itemPrinted
     */
    public String getItemPrinted() {
        return itemPrinted;
    }

    /**
     *
     * @param itemPrinted The item_printed
     */
    public void setItemPrinted(String itemPrinted) {
        this.itemPrinted = itemPrinted;
    }

    /**
     *
     * @return The odId
     */
    public String getOdId() {
        return odId;
    }

    /**
     *
     * @param odId The od_id
     */
    public void setOdId(String odId) {
        this.odId = odId;
    }

    /**
     *
     * @return The specialReq
     */
    public String getSpecialReq() {
        return specialReq;
    }

    /**
     *
     * @param specialReq The special_req
     */
    public void setSpecialReq(String specialReq) {
        this.specialReq = specialReq;
    }

    /**
     *
     * @return The orderQty
     */
    public String getOrderQty() {
        return orderQty;
    }

    /**
     *
     * @param orderQty The order_qty
     */
    public void setOrderQty(String orderQty) {
        this.orderQty = orderQty;
    }

    /**
     *
     * @return The itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     *
     * @param itemName The item_name
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     *
     * @return The orderItem
     */
    public String getOrderItem() {
        return orderItem;
    }

    /**
     *
     * @param orderItem The order_item
     */
    public void setOrderItem(String orderItem) {
        this.orderItem = orderItem;
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

    /**
     *
     * @return The modifiers
     */
    public List<Modifier> getModifiers() {
        return modifiers;
    }

    /**
     *
     * @param modifiers The modifiers
     */
    public void setModifiers(List<Modifier> modifiers) {
        this.modifiers = modifiers;
    }


    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }



}
