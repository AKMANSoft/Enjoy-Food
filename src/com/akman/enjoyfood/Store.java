package com.akman.enjoyfood;

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
public class Store {

    private int id;
    private int company_id;
    private int parent_id;
    private String store_name;
    private int store_type;
    private String address;
    private String region;
    private String contact_no;
    private String city;
    private String country;
    private String currency;
    private String latitude;
    private String longitude;
    private String image_ids;
    private String main_img;
    private String logo;
    private String store_time;
    private String description;
    private String created_date;
    private String billing_from;
    private String bill_type;
    private String reservation;

    public Store(JSONObject obj) {

        id = obj.getInt("id");
        company_id = obj.getInt("company_id");
        parent_id = obj.getInt("parent_id");
        store_name = obj.getString("store_name");
        store_type = obj.getInt("store_type");
        address = obj.getString("address");
        region = obj.getString("region");
        contact_no = obj.getString("contact_no");
        city = obj.getString("city");
        country = obj.getString("country");
        currency = obj.getString("currency");
        latitude = obj.getString("latitude");
        longitude = obj.getString("longitude");
        image_ids = obj.getString("image_ids");
        main_img = obj.getString("main_img");
        logo = obj.getString("logo");
        store_time = obj.getString("store_time");
        description = obj.getString("description");
        created_date = obj.getString("created_date");
        billing_from = obj.getString("billing_from");
        bill_type = obj.getString("bill_type");
        reservation = obj.getString("reservation");
    }

    @Override
    public String toString() {
        return "Store{" + "store_name=" + store_name + ", store_type=" + store_type + ", address=" + address + ", region=" + region + ", contact_no=" + contact_no + ", city=" + city + ", country=" + country + ", currency=" + currency + ", description=" + description + '}';
    }

}
