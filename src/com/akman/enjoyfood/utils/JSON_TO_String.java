/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akman.enjoyfood.utils;

import com.akman.enjoyfood.Login.Login;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;

/**
 *
 * @author AKMAN
 */
public class JSON_TO_String {

    URL URL;
    String str;
    JSONObject obj;

    
    /**
     * Setting the URL from Where JSON data is comming. 
     * 
     * @param URL 
     */
    public JSON_TO_String(String URL) {
        
        try {

            this.URL = new URL(URL);

            ConvertJSONToString();

        } catch (MalformedURLException ex) {

            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ConvertJSONToString() {

        try ( // read from the URL
                Scanner scan = new Scanner(URL.openStream())) {
            str = new String();
            while (scan.hasNext()) {
                str += scan.nextLine();
            }

            setJSONObject(str);

        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getString() {
        return str;
    }

    public void setJSONObject(String str) {
        obj = new JSONObject(str);
    }

    public JSONObject getJSONObject() {
        return obj;
    }


}
