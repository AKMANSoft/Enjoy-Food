package com.akman.enjoyfood.newOrder;

import com.akman.enjoyfood.Login.Data;
import com.akman.enjoyfood.utils.BordersFonts;
import com.akman.enjoyfood.utils.Constants;
import com.akman.enjoyfood.utils.JSON_TO_String;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class FrmOrders extends JPanel {

    private final JLabel Column1;
    private final JLabel Column2;
    private final JLabel Column3;
    private final JLabel Column4;
    private final JLabel Column5;

    GridBagConstraints gc;

    JSON_TO_String OrderData;

    JSONObject OrderObject;

    List<FrmOrder> OrderList = new ArrayList<>();
    
    Data data;

    public FrmOrders(Data data) {

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

        String URL  = "https://www.njoyful.com/api/bartender/orders/format/json?id="+data.getId()+"&X-API-KEY=t197SL1746977197vSGStOpM74660343&is_mobile=true&status=ORDER";
        
        OrderData = new JSON_TO_String(URL);

        OrderObject = OrderData.getJSONObject();

        setLayout(new GridBagLayout());

        setBackground(Color.WHITE);

        this.setPreferredSize(new Dimension(800, 780));

        InitlizeLayout();

        if (OrderObject.has("status")) {

            JLabel filler = new JLabel("No Order found");// Filler the extra space in grid bag layout.
            filler.setVerticalAlignment(SwingConstants.TOP);
            filler.setBorder(BordersFonts.CompoundBorder);

            gc = new GridBagConstraints(0, 1, 5, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 10, 20);
            this.add(filler, gc);
            return;
        }

        OrderList = Orders.getData(OrderObject);

        Fill_Orders_FROM_JSON_TO_LAYOUT();
        
        

    }

    private void Fill_Orders_FROM_JSON_TO_LAYOUT() {

        int j = 1;

        for (int i = 0; i < OrderList.size(); i++) {

            int GridHeight = OrderList.get(i).getItems().size(); // Height of Grid if its not Item to match the items height. 

            JLabel OrderID = new JLabel(OrderList.get(i).getId());// First Column OrderID filling with OrderID. 
            OrderID.setVerticalAlignment(SwingConstants.TOP);
            OrderID.setBorder(BordersFonts.CompoundBorder);
            gc = new GridBagConstraints(0, j, 1, GridHeight + 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 10, 20);
            this.add(OrderID, gc);

            JLabel TableNo = new JLabel(OrderList.get(i).getOdTableNo());// Fourth Column Table Number Filling with Table Number.
            TableNo.setBorder(BordersFonts.CompoundBorder);
            TableNo.setVerticalAlignment(SwingConstants.TOP);
            TableNo.setHorizontalAlignment(SwingConstants.CENTER);
            gc = new GridBagConstraints(3, j, 1, GridHeight + 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 10, 20);
            this.add(TableNo, gc);

            JLabel Server = new JLabel(OrderList.get(i).getWaiter());// Fifth Column Server. 
            Server.setBorder(BordersFonts.CompoundBorder);
            Server.setVerticalAlignment(SwingConstants.TOP);
            gc = new GridBagConstraints(4, j, 1, GridHeight + 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 10, 20);
            this.add(Server, gc);

            for (Item item : OrderList.get(i).getItems()) {

                try {
                    JTextPane items = new JTextPane();// setting the Item Table.
                    items.setText(item.getItemName());
                    items.setEditable(false);

                    StyledDocument doc = items.getStyledDocument();

                    StyleContext sc = StyleContext.getDefaultStyleContext();
                    AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, Color.RED);

                    if (!item.getSpecialReq().isEmpty()) {
                        doc.insertString(doc.getLength(), Constants.newline, null);
                        doc.insertString(doc.getLength(), item.getSpecialReq(), aset);
                    }

                    if (!item.getModifiers().isEmpty()) {
                        doc.insertString(doc.getLength(), Constants.newline, null);
                        doc.insertString(doc.getLength(), item.getModifiers().toString(), aset);
                    }

                    items.setBorder(BordersFonts.CompoundBorder);
                    gc = new GridBagConstraints(1, j, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 10, 20);
                    this.add(items, gc);

                    JLabel QtyLabel = new JLabel(item.getOrderQty());// setting the Qty Table.
                    QtyLabel.setHorizontalAlignment(SwingConstants.CENTER);
                    QtyLabel.setBorder(BordersFonts.CompoundBorder);
                    gc = new GridBagConstraints(2, j, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 10, 20);
                    this.add(QtyLabel, gc);

                    j++;
                } catch (BadLocationException ex) {
                    Logger.getLogger(FrmOrders.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

            JLabel OrderComments = new JLabel(OrderList.get(i).getOdComment());// setting the OrderComments.
            OrderComments.setBorder(BordersFonts.CompoundBorder);
            gc = new GridBagConstraints(1, j, 2, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 10, 20);
            this.add(OrderComments, gc);

            if (!OrderList.get(i).getTakeAwayTime().isEmpty()) {
                JLabel TakeAway = new JLabel(" " + OrderList.get(i).getTakeAwayTime());// setting the OrderComments.
                TakeAway.setVerticalAlignment(SwingConstants.TOP);
                TakeAway.setBorder(BordersFonts.CompoundBorder);
                gc = new GridBagConstraints(0, j + 1, 5, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 10, 20);
                this.add(TakeAway, gc);
            }

            j++;

        }

        JLabel filler = new JLabel();// Filler the extra space in grid bag layout.

        gc = new GridBagConstraints(0, ++j, 5, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 10, 20);
        this.add(filler, gc);

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

    public List<FrmOrder> getOrderList() {
        System.out.println("Getting order list....");
        return OrderList;
    }

    public void setOrderList(List<FrmOrder> OrderList) {
        this.OrderList = OrderList;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
////                FrmOrders order = new FrmOrders();
//
//                JScrollPane pane = new JScrollPane(order);
//
//                JFrame frame = new JFrame();
//                frame.add(pane);
//                frame.setVisible(true);

            }
        });

    }
}
