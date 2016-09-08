
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
     */

    public static void DefaultPrinter() {
        
        PrinterJob pj = PrinterJob.getPrinterJob();
        
        PrintService[] printServices = PrintServiceLookup.lookupPrintServices(null, null);
        
        System.out.println("Number of printers configured: " + printServices.length);
        
        for (PrintService printer : printServices) {
            
            System.out.println("Printer: " + printer.getName());
            
            if (printer.getName().equals("***MYPRINTER***")) {
                
                try {
                    
                    pj.setPrintService(printer);
                    
                } catch (PrinterException ex) {
                    
                    ex.printStackTrace();
                    
                }
            }
        }

    }
    
    public static void main(String[] args) {
        SettingDefaultPrinter.DefaultPrinter();
    }

}
