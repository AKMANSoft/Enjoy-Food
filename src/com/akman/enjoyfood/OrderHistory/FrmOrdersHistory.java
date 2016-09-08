package com.akman.enjoyfood.OrderHistory;

import com.akman.enjoyfood.Login.Data;
import com.akman.enjoyfood.utils.BordersFonts;
import com.akman.enjoyfood.utils.Constants;
import com.akman.enjoyfood.utils.JSON_TO_String;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
import org.json.JSONObject;

/**
 * This class take the data from the JSON and show it in grid bag layout.
 *
 *
 * @author BTACTC
 */
public final class FrmOrdersHistory extends JPanel {

    private final JLabel Column1;
    private final JLabel Column2;
    private final JLabel Column3;
    private final JLabel Column4;
    private final JLabel Column5;

    GridBagConstraints gc;

    JSON_TO_String OrderData;

    JSONObject OrderHistoryObject;

    List<OrderHistory> OrderHistoryList = new ArrayList<>();
    
    Data data;

    public FrmOrdersHistory(Data data) {
        
        this.data = data;
        
        Column1 = new JLabel("Orders");
        Column2 = new JLabel("Order Items");
        Column3 = new JLabel("QTY");
        Column4 = new JLabel("Table No");
        Column5 = new JLabel("Server");

        BordersFonts.FontSettings(Column1);
        BordersFonts.FontSettings(Column2);
        BordersFonts.FontSettings(Column3);
        BordersFonts.FontSettings(Column4);
        BordersFonts.FontSettings(Column5);

        String URL = "https://www.njoyful.com/api/store/getorderhistory/format/json?id="+data.getId()+""
                + "&X-API-KEY=t197SL1746977197vSGStOpM74660343&is_mobile=true&store_id="+data.getOrderId();
        OrderData = new JSON_TO_String(URL);

        OrderHistoryObject = OrderData.getJSONObject();

        if (OrderHistoryObject.has("status")) {
            if (!OrderHistoryObject.getString("status").equals("success")) {
                return;
            }
        }

        OrderHistoryList = DataBeanList.getDataBeanList(OrderHistoryObject);

        InitlizeLayout();

        Fill_Orders_FROM_JSON_TO_LAYOUT();

    }

    @Override
    public void setPreferredSize(Dimension preferredSize) {
        super.setPreferredSize(new Dimension(800, 780)); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setBackground(Color bg) {
        super.setBackground(Color.WHITE); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setLayout(LayoutManager mgr) {
        super.setLayout(new GridBagLayout()); //To change body of generated methods, choose Tools | Templates.
    }

    private void Fill_Orders_FROM_JSON_TO_LAYOUT() {

        int j = 1;

        for (int i = 0; i < OrderHistoryList.size(); i++) {

            int GridHeight = OrderHistoryList.get(i).getItems().size(); // Height of Grid if its not Item to match the items height. 

            JLabel OrderID = new JLabel(OrderHistoryList.get(i).getId());// First Column OrderID filling with OrderID. 
            OrderID.setVerticalAlignment(SwingConstants.TOP);
            OrderID.setBorder(BordersFonts.CompoundBorder);
            gc = new GridBagConstraints(0, j, 1, GridHeight + 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 10, 20);
            this.add(OrderID, gc);

            JLabel TableNo = new JLabel(OrderHistoryList.get(i).getOd_table());// Fourth Column Table Number Filling with Table Number.
            TableNo.setBorder(BordersFonts.CompoundBorder);
            TableNo.setVerticalAlignment(SwingConstants.TOP);
            TableNo.setHorizontalAlignment(SwingConstants.CENTER);
            gc = new GridBagConstraints(3, j, 1, GridHeight + 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 10, 20);
            this.add(TableNo, gc);

            JLabel Server = new JLabel(OrderHistoryList.get(i).getWaiter());// Fifth Column Server. 
            Server.setBorder(BordersFonts.CompoundBorder);
            Server.setVerticalAlignment(SwingConstants.TOP);
            gc = new GridBagConstraints(4, j, 1, GridHeight + 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 10, 20);
            this.add(Server, gc);

            for (Items item : OrderHistoryList.get(i).getItems()) {

                try {
                    JTextPane items = new JTextPane();// setting the Item Table.
                    items.setText(item.getItem_name());
                    items.setEditable(false);

                    StyledDocument doc = items.getStyledDocument();

                    StyleContext sc = StyleContext.getDefaultStyleContext();
                    AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, Color.RED);

                    if (!item.getSpecial_req().isEmpty()) {
                        doc.insertString(doc.getLength(), Constants.newline, null);
                        doc.insertString(doc.getLength(), item.getSpecial_req(), aset);
                    }

                    if (!item.getModifier_name().isEmpty()) {
                        doc.insertString(doc.getLength(), Constants.newline, null);
                        doc.insertString(doc.getLength(), item.getModifier_name().toString(), aset);
                    }

                    items.setBorder(BordersFonts.CompoundBorder);
                    gc = new GridBagConstraints(1, j, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 10, 20);
                    this.add(items, gc);

                    JLabel QtyLabel = new JLabel(item.getOrder_qty());// setting the Qty Table.
                    QtyLabel.setHorizontalAlignment(SwingConstants.CENTER);
                    QtyLabel.setBorder(BordersFonts.CompoundBorder);
                    gc = new GridBagConstraints(2, j, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 10, 20);
                    this.add(QtyLabel, gc);

                    j++;
                } catch (BadLocationException ex) {
                    Logger.getLogger(FrmOrdersHistory.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

            JLabel OrderComments = new JLabel(OrderHistoryList.get(i).getOd_comments());// setting the OrderComments.
            OrderComments.setBorder(BordersFonts.CompoundBorder);
            gc = new GridBagConstraints(1, j, 2, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 10, 20);
            this.add(OrderComments, gc);

            j++;

//            JLabel TakeAway = new JLabel("Take away on " + OrderHistoryList.get(i).get + " from Christos Fragoulakis. ");// setting the OrderComments.
//            TakeAway.setVerticalAlignment(SwingConstants.TOP);
//            TakeAway.setBorder(CompoundBorder);
//            gc = new GridBagConstraints(0, ++j, 5, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 10, 20);
//            this.add(TakeAway, gc);
        }

        JLabel filler = new JLabel();// Filler the extra space in grid bag layout.

        gc = new GridBagConstraints(0, ++j, 5, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 10, 20);
        this.add(filler, gc);

        j++;

    }

    /**
     * Setting the table header in Grid Bag Constraints.
     *
     * Five Column Order, OrderItem, QTY, TableNo, Server.
     *
     *
     */
    private void InitlizeLayout() {

        // Setting the first column name Orders. 
        Column1.setBorder(BordersFonts.CompoundBorder);
        gc = new java.awt.GridBagConstraints();
        gc.gridx = 0;
        gc.gridy = 0;
        gc.fill = java.awt.GridBagConstraints.BOTH;
        gc.ipadx = 100;
        gc.ipady = 20;
        this.add(Column1, gc);

        // Setting the second column name Order Items
        Column2.setBorder(BordersFonts.CompoundBorder);
        gc = new java.awt.GridBagConstraints();
        gc.gridx = 1;
        gc.gridy = 0;
        gc.fill = java.awt.GridBagConstraints.BOTH;
        gc.ipady = 20;
        gc.weightx = 1.0;
        this.add(Column2, gc);

        // Setting the third column name QTY. 
        Column3.setHorizontalAlignment(SwingConstants.CENTER);
        Column3.setBorder(BordersFonts.CompoundBorder);
        gc = new java.awt.GridBagConstraints();
        gc.gridx = 2;
        gc.gridy = 0;
        gc.fill = java.awt.GridBagConstraints.BOTH;
        gc.ipadx = 50;
        gc.ipady = 20;
        this.add(Column3, gc);

        // Seeting the Fourth Column name Table Number. 
        Column4.setHorizontalAlignment(SwingConstants.CENTER);
        Column4.setBorder(BordersFonts.CompoundBorder);
        gc = new java.awt.GridBagConstraints();
        gc.gridx = 3;
        gc.gridy = 0;
        gc.fill = java.awt.GridBagConstraints.BOTH;
        gc.ipadx = 50;
        gc.ipady = 20;
        this.add(Column4, gc);

        // Setting the 5th Column Name Server. 
        Column5.setHorizontalAlignment(SwingConstants.CENTER);
        Column5.setBorder(BordersFonts.CompoundBorder);
        gc = new java.awt.GridBagConstraints();
        gc.gridx = 4;
        gc.gridy = 0;
        gc.fill = java.awt.GridBagConstraints.BOTH;
        gc.ipadx = 50;
        gc.ipady = 20;
        this.add(Column5, gc);

    }

    public List<OrderHistory> getOrderList() {
        return OrderHistoryList;
    }

    public void setOrderList(List<OrderHistory> OrderList) {
        this.OrderHistoryList = OrderList;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
//                FrmOrdersHistory order = new FrmOrdersHistory();
//
//                JFrame frame = new JFrame();
//                frame.add(order);
//                frame.setVisible(true);

            }
        });

    }
}
