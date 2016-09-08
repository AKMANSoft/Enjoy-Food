package com.akman.enjoyfood.newOrder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import org.json.JSONObject;

@Generated("org.jsonschema2pojo")
public class FrmOrder {

    private String time;
    private String odDate;
    private String odComment;
    private String odType;
    private String orderPrinted;
    private String id;
    private String odUser;
    private String odTableNo;
    private String waiter;
    private String bartenderId;
    private String bartender;
    private List<Item> items = new ArrayList<>();
    private String takeAwayTime;
    private String reservationTimeLeft;
    private final Map<String, Object> additionalProperties = new HashMap<>();

    public FrmOrder(JSONObject order) {

        odDate = (order.isNull("od_date")) ? "" : order.getString("od_date");
        odComment = (order.isNull("od_comment")) ? "" : order.getString("od_comment");
        odType = (order.isNull("od_type")) ? "" : order.getString("od_type");
        orderPrinted = (order.isNull("order_printed")) ? "" : order.getString("order_printed");
        id = (order.isNull("id")) ? "" : order.getString("id");
        odUser = (order.isNull("od_user")) ? "" : order.getString("od_user");
        odTableNo = (order.isNull("od_table_no")) ? "" : order.getString("od_table_no");
        waiter = (order.isNull("waiter")) ? "" : order.getString("waiter");
        bartenderId = (order.isNull("bartender_id")) ? "" : order.getString("bartender_id");
        bartender = (order.isNull("bartender")) ? "" : order.getString("bartender");
        items = new ArrayList<>();
        takeAwayTime =(order.isNull("take_away_time")) ? "" : order.getString("take_away_time");
        reservationTimeLeft =(order.isNull("reservation_time_left")) ? "" : order.getString("reservation_time_left");

        for (int i = 0; i < order.getJSONArray("items").length(); i++) {
            this.items.add(new Item(order.getJSONArray("items").getJSONObject(i)));

        }

    }

    /**
     *
     * @return The time
     */
    public String getTime() {
        return time;
    }

    /**
     *
     * @param time The time
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     *
     * @return The odDate
     */
    public String getOdDate() {
        return odDate;
    }

    /**
     *
     * @param odDate The od_date
     */
    public void setOdDate(String odDate) {
        this.odDate = odDate;
    }

    /**
     *
     * @return The odComment
     */
    public String getOdComment() {
        return odComment;
    }

    /**
     *
     * @param odComment The od_comment
     */
    public void setOdComment(String odComment) {
        this.odComment = odComment;
    }

    /**
     *
     * @return The odType
     */
    public String getOdType() {
        return odType;
    }

    /**
     *
     * @param odType The od_type
     */
    public void setOdType(String odType) {
        this.odType = odType;
    }

    /**
     *
     * @return The orderPrinted
     */
    public String getOrderPrinted() {
        return orderPrinted;
    }

    /**
     *
     * @param orderPrinted The order_printed
     */
    public void setOrderPrinted(String orderPrinted) {
        this.orderPrinted = orderPrinted;
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
     * @return The odUser
     */
    public String getOdUser() {
        return odUser;
    }

    /**
     *
     * @param odUser The od_user
     */
    public void setOdUser(String odUser) {
        this.odUser = odUser;
    }

    /**
     *
     * @return The odTableNo
     */
    public String getOdTableNo() {
        return odTableNo;
    }

    /**
     *
     * @param odTableNo The od_table_no
     */
    public void setOdTableNo(String odTableNo) {
        this.odTableNo = odTableNo;
    }

    /**
     *
     * @return The waiter
     */
    public String getWaiter() {
        return waiter;
    }

    /**
     *
     * @param waiter The waiter
     */
    public void setWaiter(String waiter) {
        this.waiter = waiter;
    }

    /**
     *
     * @return The bartenderId
     */
    public String getBartenderId() {
        return bartenderId;
    }

    /**
     *
     * @param bartenderId The bartender_id
     */
    public void setBartenderId(String bartenderId) {
        this.bartenderId = bartenderId;
    }

    /**
     *
     * @return The bartender
     */
    public String getBartender() {
        return bartender;
    }

    /**
     *
     * @param bartender The bartender
     */
    public void setBartender(String bartender) {
        this.bartender = bartender;
    }

    /**
     *
     * @return The items
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     *
     * @param items The items
     */
    public void setItems(List<Item> items) {
        this.items = items;
    }

    /**
     *
     * @return The takeAwayTime
     */
    public String getTakeAwayTime() {
        return takeAwayTime;
    }

    /**
     *
     * @param takeAwayTime The take_away_time
     */
    public void setTakeAwayTime(String takeAwayTime) {
        this.takeAwayTime = takeAwayTime;
    }

    /**
     *
     * @return The reservationTimeLeft
     */
    public String getReservationTimeLeft() {
        return reservationTimeLeft;
    }

    /**
     *
     * @param reservationTimeLeft The reservation_time_left
     */
    public void setReservationTimeLeft(String reservationTimeLeft) {
        this.reservationTimeLeft = reservationTimeLeft;
    }

    @Override
    public String toString() {
        return id;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }


}
