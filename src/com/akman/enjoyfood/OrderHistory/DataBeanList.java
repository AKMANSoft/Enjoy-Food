/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akman.enjoyfood.OrderHistory;

import java.util.ArrayList;
import org.json.JSONObject;

public class DataBeanList {

    public static ArrayList<OrderHistory> getDataBeanList(JSONObject OrderHistoryObject) {

        ArrayList<OrderHistory> ordersList = new ArrayList<>();
        
        if (OrderHistoryObject.has("data")) {
            for (int i = 0; i < OrderHistoryObject.getJSONArray("data").length(); i++) {

                OrderHistory order = new OrderHistory(OrderHistoryObject.getJSONArray("data").getJSONObject(i));
                ordersList.add(order);

            }
        }

        return ordersList;
    }
}
