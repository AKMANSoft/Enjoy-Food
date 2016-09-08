/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akman.enjoyfood;

import com.akman.enjoyfood.newOrder.FrmOrder;
import java.awt.image.BufferedImage;
import java.awt.print.PrinterJob;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.AttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.HashPrintServiceAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.PrinterName;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporterParameter;

/**
 *
 * @author BTACTC
 */
public class Report {
    
    
    FrmOrder order;
    Printer printer;

    public Report(FrmOrder order, Printer printer) {
        this.order = order;
        this.printer = printer;
    }
    
    
    
     /**
     *
     * @param order
     * @return This method return the parameter of receipt report.
     */
    private Map setParameters(FrmOrder order) {

        Map map = new HashMap();

        try {

            BufferedImage image = ImageIO.read(getClass().getResource("/icon/Enjoyfood.png"));

            JRBeanCollectionDataSource ItemList = new JRBeanCollectionDataSource(order.getItems());

            map.put("OrderID", order.getId());
            map.put("OrderDate", order.getOdDate());
            map.put("TableNo", order.getOdTableNo());
            map.put("ServerName", order.getWaiter());
            map.put("Comments", order.getOdComment());
            map.put("logo", image);

            map.put("ItemList", ItemList);

        } catch (IOException ex) {
            Logger.getLogger(FrmOrder.class.getName()).log(Level.SEVERE, null, ex);
        }

        return map;
    }
    
    
    /**
     * This method Print the Report to the selected Printer.
     *
     */
    public void PrintReport() {
        try {

            String report = JasperCompileManager.compileReportToFile("Receipt.jrxml");

            JasperPrint jasperPrint = JasperFillManager.fillReport(report, setParameters(order), new JREmptyDataSource());

            int selectedService = 0;

            AttributeSet attributeSet = new HashPrintServiceAttributeSet(new PrinterName(printer.getName(), null));

            PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, attributeSet);

            JRPrintServiceExporter exporter;
            PrintRequestAttributeSet printRequestAttributeSet = new HashPrintRequestAttributeSet();

            // these are deprecated
            exporter = new JRPrintServiceExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, printService[selectedService]);
            exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE_ATTRIBUTE_SET, printService[selectedService].getAttributes());
            exporter.setParameter(JRPrintServiceExporterParameter.PRINT_REQUEST_ATTRIBUTE_SET, printRequestAttributeSet);
            exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PAGE_DIALOG, Boolean.FALSE);
            exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.FALSE);

            exporter.exportReport();

        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
        }

    }
    
}
