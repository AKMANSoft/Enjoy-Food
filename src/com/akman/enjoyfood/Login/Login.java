/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akman.enjoyfood.Login;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;

/**
 *
 * @author BTACTC
 */
public class Login {

    String username;
    String password;
    URL url;
    String str;
    JSONObject obj;
    Boolean Status = false;
    Data StoreData;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setURL(String url) {
        try {
            this.url = new URL(url);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void convertJsonToString() {
        
        try ( // read from the URL
                Scanner scan = new Scanner(url.openStream())) {
            str = new String();
            while (scan.hasNext()) {
                str += scan.nextLine();
            }
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getString(){
        return str;
    }
    
    
    public void setJSONObject(){
        obj = new JSONObject(str);
       StoreData = new Data(obj.getJSONObject("data"));
        
    }

    public Data getStoreData() {
        return StoreData;
    }    
    
    
    public JSONObject getJSONObject(){
        return obj;
    }

    public void setStatus(){
        String status = obj.getString("status");
        
        if(status.equals("success")){
            Status = true;
        }
    }
    public Boolean getStatus() {
        return Status;
    }
    
}
