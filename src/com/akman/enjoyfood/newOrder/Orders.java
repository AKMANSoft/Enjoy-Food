//-----------------------------------com.akman.nJoyful.NewOrder.java-----------------------------------
package com.akman.enjoyfood.newOrder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import org.json.JSONObject;

@Generated("org.jsonschema2pojo")
public class Orders {

    
    private final Map<String, Object> additionalProperties = new HashMap<>();

    public Orders() {

    }

    /**
     *
     * @param obj
     * @return The data
     */
    public static List<FrmOrder> getData(JSONObject obj) {

        List<FrmOrder> data = new ArrayList<>();
        
        for (int i = 0; i < obj.getJSONArray("data").length(); i++) {

            FrmOrder order = new FrmOrder(obj.getJSONArray("data").getJSONObject(i));

            data.add(order);
        }

        return data;
    }


    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }


}
