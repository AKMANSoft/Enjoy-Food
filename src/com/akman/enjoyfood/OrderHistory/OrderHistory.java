package com.akman.enjoyfood.OrderHistory;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author AKL SOFT
 */
public class OrderHistory {

    private String id;
    private String od_date;
    private String od_table;
    private String waiter;
    private String od_comments;
    private String od_type;

    private List<Items> items = new ArrayList<>();

    public OrderHistory(JSONObject order) {

        this.od_date = (order.isNull("od_date")) ? "" : order.getString("od_date");
        this.od_comments = (order.isNull("od_comment")) ? "" : order.getString("od_comment");
        this.od_type = (order.isNull("od_type")) ? "" : order.getString("od_type");
        this.id = (order.isNull("id")) ? "" : order.getString("id");
        this.od_table = (order.isNull("od_table_no")) ? "" : order.getString("od_table_no");
        this.waiter =   (!order.has("waiter")) ? "": (order.isNull("waiter")) ? "" : order.getString("waiter");

        for (int i = 0; i < order.getJSONArray("items").length(); i++) {
            this.items.add(new Items(order.getJSONArray("items").getJSONObject(i)));

        }

    }

    public String getOd_date() {
        return od_date;
    }

    public String getOd_comments() {
        return od_comments;
    }

    public String getOd_type() {
        return od_type;
    }

    public String getId() {
        return id;
    }

    public String getOd_table() {
        return od_table;
    }

    public String getWaiter() {
        return waiter;
    }

    public List<Items> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", od_date=" + od_date + ", od_table=" + od_table + ", waiter=" + waiter + ", od_comments=" + od_comments + '}';
    }

}
