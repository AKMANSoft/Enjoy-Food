package com.akman.enjoyfood.OrderHistory;

import com.akman.enjoyfood.newOrder.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class Items {

    private String modifier_ids;
    private String item_printed;
    private String order_id;
    private String special_req;
    private String order_qty;
    private String item_name;
    private String order_item;
    private String status;
    private String modifier_name ;

    public Items(JSONObject items) {

        modifier_ids = (items.isNull("modifier_ids")) ? "" : items.getString("modifier_ids");
        item_printed = (items.isNull("item_printed")) ? "" : items.getString("item_printed");
        order_id = (items.isNull("order_id")) ? "" : items.getString("order_id");
        special_req = (items.isNull("special_req")) ? "" : items.getString("special_req");
        order_qty = (items.isNull("order_qty")) ? "" : items.getString("order_qty");
        item_name = (items.isNull("item_name")) ? "" : items.getString("item_name");
        order_item = (items.isNull("order_item")) ? "" : items.getString("order_item");
        status = (items.isNull("status")) ? "" : items.getString("status");
        modifier_name = (items.isNull("modifier_name")) ? "" : items.getString("modifier_name");



    }

    public String getModifier_ids() {
        return modifier_ids;
    }

    public String getItem_printed() {
        return item_printed;
    }

    public String getorder_id() {
        return order_id;
    }


    public String getOrder_qty() {
        return order_qty;
    }

    public String getItem_name() {
        return item_name;
    }

    public String getOrder_item() {
        return order_item;
    }

    public String getStatus() {
        return status;
    }

    public String getSpecial_req() {
        return special_req;
    }

    public void setSpecial_req(String special_req) {
        this.special_req = special_req;
    }

    public String getOrder_id() {
        return order_id;
    }

    public String getModifier_name() {
        return modifier_name;
    }





    @Override
    public String toString() {
        return "Items{" + "order_qty=" + order_qty + ", item_name=" + item_name + '}';
    }

}
