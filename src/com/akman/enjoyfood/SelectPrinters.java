/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akman.enjoyfood;

import javax.print.DocFlavor;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.PrintServiceAttributeSet;
import javax.print.attribute.standard.PrinterState;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

/**
 *
 * @author AKMAN
 */
public class SelectPrinters extends javax.swing.JDialog {

    /**
     * Creates new form SelectPrinters
     */
    DefaultTableModel model;
    Printer printer;

    FrmOrder order;

    public SelectPrinters(FrmOrder order, boolean modal) {

        super(order, modal);

        initComponents();

        model = (DefaultTableModel) tblPrinters.getModel();

        getPrinters();

        this.order = order;

    }

    /**
     * This method get all the printer installed in the system. Add then into
     * JTable.
     */
    public void getPrinters() {

        model.setRowCount(0);

        DocFlavor doc_flavor = DocFlavor.SERVICE_FORMATTED.PRINTABLE;
        PrintRequestAttributeSet attr_set
                = new HashPrintRequestAttributeSet();

        PrintService[] service = PrintServiceLookup.
                lookupPrintServices(doc_flavor,
                        attr_set);
        for (PrintService printService : service) {

            PrintServiceAttributeSet printServiceAttributes = printService.getAttributes();
            PrinterState printerState
                    = (PrinterState) printServiceAttributes.get(PrinterState.class);

            if (printService != null) {
                Object row[] = {new Printer(printService.getName(), true), "Online"};
                model.addRow(row);
            } else {
                Object row[] = {new Printer(printService.getName(), true), "Offline"};
                model.addRow(row);
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        lblDescoveringPrinters = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPrinters = new org.jdesktop.swingx.JXTable();
        btnRefresh = new javax.swing.JButton();
        btnContinue = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Discovering Printers..");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblDescoveringPrinters.setForeground(new java.awt.Color(255, 102, 0));
        lblDescoveringPrinters.setText("Discovering Printers....");

        tblPrinters.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Printers", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPrinters.setRowHeight(25);
        tblPrinters.setSelectionBackground(new java.awt.Color(255, 102, 0));
        tblPrinters.setVisibleRowCount(25);
        tblPrinters.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPrintersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPrinters);
        if (tblPrinters.getColumnModel().getColumnCount() > 0) {
            tblPrinters.getColumnModel().getColumn(1).setMinWidth(0);
            tblPrinters.getColumnModel().getColumn(1).setPreferredWidth(0);
            tblPrinters.getColumnModel().getColumn(1).setMaxWidth(0);
        }

        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logo.png"))); // NOI18N
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnContinue.setText("Continue");
        btnContinue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinueActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblDescoveringPrinters, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnContinue)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 631, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblDescoveringPrinters, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnContinue)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnContinue, btnRefresh});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        getPrinters();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void tblPrintersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPrintersMouseClicked
        if (evt.getClickCount() == 2) {

        }
    }//GEN-LAST:event_tblPrintersMouseClicked

    private void btnContinueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinueActionPerformed
        if (tblPrinters.getSelectedRow() != -1) {
            int row = tblPrinters.getSelectedRow();
            if (tblPrinters.getValueAt(row, 1) == "Offline") {
                JOptionPane.showMessageDialog(null, "Printer is Offline", "Offine error", JOptionPane.ERROR_MESSAGE);
            } else {

            }

            Printer printer = (Printer) tblPrinters.getValueAt(row, 0);

            try {
                String propFileName = "config.properties";
                PropertiesConfiguration prop = new PropertiesConfiguration(propFileName);
                prop.setProperty("Printer", printer.getName());
                prop.save();
                
            } catch (ConfigurationException ex) {

            }

            this.dispose();

            if (order == null) {

            } else {
                order.setPrinter(printer);
                order.run();
            }

        }
    }//GEN-LAST:event_btnContinueActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnContinue;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblDescoveringPrinters;
    private org.jdesktop.swingx.JXTable tblPrinters;
    // End of variables declaration//GEN-END:variables
}
