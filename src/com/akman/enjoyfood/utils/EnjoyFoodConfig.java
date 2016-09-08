/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akman.enjoyfood.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Crunchify.com
 *
 */
public class EnjoyFoodConfig {

    public static String getLogin() {
        String result = "";
        InputStream inputStream = null;
        try {
            Properties prop = new Properties();

            inputStream = new FileInputStream("config.properties");

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file  not found in the classpath");
            }

            // get the property value and print it out
            String Login = prop.getProperty("Login");

            result = Login;

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            try {
                inputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(EnjoyFoodConfig.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    public static String getOrderTimer() {
        String result = "";
        InputStream inputStream = null;
        try {
            Properties prop = new Properties();
            String propFileName = "config.properties";

            inputStream = new FileInputStream("config.properties");

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            // get the property value and print it out
            String Timer = prop.getProperty("OrderTimer");

            result = Timer;

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            try {
                inputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(EnjoyFoodConfig.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    public static String getHistoryTimer() {
        String result = "";
        InputStream inputStream = null;
        try {
            Properties prop = new Properties();
            String propFileName = "config.properties";

            inputStream = new FileInputStream("config.properties");

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            // get the property value and print it out
            String Timer = prop.getProperty("HistoryTimer");

            result = Timer;

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            try {
                inputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(EnjoyFoodConfig.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    public static String getNewInstallation() {
        String result = "";
        InputStream inputStream = null;
        try {
            Properties prop = new Properties();

            inputStream = new FileInputStream("config.properties");

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file  not found in the classpath");
            }

            // get the property value and print it out
            String NewInstallation = prop.getProperty("NewInstallation");

            result = NewInstallation;

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            try {
                inputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(EnjoyFoodConfig.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    public static String getPrinter() {
        String result = "";
        InputStream inputStream = null;
        try {
            Properties prop = new Properties();
            String propFileName = "/config/config.properties";

            inputStream = new FileInputStream("config.properties");

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            // get the property value and print it out
            String Printer = prop.getProperty("Printer");

            result = Printer;

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            try {
                inputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(EnjoyFoodConfig.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    public static String getUsername() {
        
        String result = "";
        InputStream inputStream = null;
        try {
            Properties prop = new Properties();

            inputStream = new FileInputStream("config.properties");

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file  not found in the classpath");
            }

            // get the property value and print it out
            String Username = prop.getProperty("Username");

            result = Username;

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            try {
                inputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(EnjoyFoodConfig.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    public static String getPassword() {
        String result = "";
        InputStream inputStream = null;
        try {
            Properties prop = new Properties();

            inputStream = new FileInputStream("config.properties");

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file  not found in the classpath");
            }

            // get the property value and print it out
            String Password = prop.getProperty("Password");

            result = Password;

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            try {
                inputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(EnjoyFoodConfig.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }
}
