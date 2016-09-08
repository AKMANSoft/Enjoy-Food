/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akman.enjoyfood.utils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 *
 * @author AKMAN
 */
public class Internet {

    public Internet() {

    }

    public static Boolean CheckInternet() {
        Boolean status = true;

        Socket sock = new Socket();
        InetSocketAddress addr = new InetSocketAddress("www.google.com", 80);
        try {
            sock.connect(addr, 3000);
            return true;
        } catch (IOException e) {
            return false;
        } finally {
            try {
                sock.close();
            } catch (IOException e) {
            }
        }

    }

    public static void main(String args[]) {

        Boolean status = Internet.CheckInternet();
        System.out.println(status);
    }

}
