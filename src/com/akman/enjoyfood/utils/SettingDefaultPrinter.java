package com.akman.enjoyfood.utils;


import com.akman.enjoyfood.Printer;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author BTACTC
 */
public class SettingDefaultPrinter {
    
    /**
     * 
     * This method is used to get the printer save in configuration file by user. 
     * 
     * @return 
     */

    public static Printer DefaultPrinter() {
        
        Printer printers = null;
        
        PrinterJob pj = PrinterJob.getPrinterJob();
        
        PrintService[] printServices = PrintServiceLookup.lookupPrintServices(null, null);
        
        System.out.println("Number of printers configured: " + printServices.length);
        
        for (PrintService printer : printServices) {
            
            System.out.println("Printer: " + printer.getName());
            
            if (printer.getName().equals(EnjoyFoodConfig.getPrinter())) {
                
                try {
                    
                    pj.setPrintService(printer);
                    printers =  new Printer(printer.getName(), Boolean.TRUE);
                    
                    
                } catch (PrinterException ex) {
                    
                    ex.printStackTrace();
                    
                }
            }
        }
        
        return printers;

    }
    
    public static void main(String[] args) {
        SettingDefaultPrinter.DefaultPrinter();
    }

}
