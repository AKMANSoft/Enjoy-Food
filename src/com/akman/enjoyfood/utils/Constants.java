package com.akman.enjoyfood.utils;

import javax.print.attribute.standard.MediaPrintableArea;
import javax.print.attribute.standard.MediaSize;
import javax.print.attribute.standard.MediaSizeName;

/**
 * Class Constants ~ all constants necessary for the system
 * 
 * @author Java Course Team 2016
 * @author University Of Haifa-Israel
 */
public final class Constants {

	/**
	 * The URL for Login
	 */
	public static final String URL_FOR_LOGIN = "https://www.njoyful.com/api/login/bartender?X-API-KEY=null&is_mobile=true&email=kitchen@york.com&password=1234";

	/**
	 * The URL to get Orders
	 */
	public static final String URL_GET_ORDERS = "https://www.njoyful.com/api/bartender/orders/format/json?id=132&X-API-KEY=t197SL1746977197vSGStOpM74660343&is_mobile=true&status=ORDER";

	/**
	 * The URL to get history of Orders
	 */
	public static final String URL_GET_HISTORY_ORDERS = "https://www.njoyful.com/api/store/getorderhistory/format/json?id=132&X-API-KEY=t197SL1746977197vSGStOpM74660343&is_mobile=true&store_id=90";
        
        /**
	 * The URL to POST Orders
	 */
	public static final String URL_POST_ORDERS = "https://njoyful.com/api/order/orderprint/format/json";
        
        
        /**
         *Add New line in the string.
         */
        public static final String newline = System.lineSeparator();
        
        
        public static final MediaSizeName mediaSizeName = MediaSize.findMedia(80,800,MediaPrintableArea.MM);

}// ~ END OF Class Constants