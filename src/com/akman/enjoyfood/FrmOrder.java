package com.akman.enjoyfood;

import com.akman.enjoyfood.Login.Data;
import com.akman.enjoyfood.Login.loginform;
import com.akman.enjoyfood.newOrder.FrmOrders;
import com.akman.enjoyfood.OrderHistory.FrmOrdersHistory;
import com.akman.enjoyfood.utils.Constants;
import com.akman.enjoyfood.utils.EnjoyFoodConfig;
import config.Login;
import config.Timers;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import net.codejava.networking.HttpUtility;
import org.json.JSONObject;

/**
 * This class is searching Orders and Orders History from the API. It will
 * automatically refresh after 10 sec. It will send order coming from the API to
 * the selected printer.
 *
 * @author BTACTC
 */
public class FrmOrder extends javax.swing.JFrame {

    FrmOrders orderPanel;// Panel with orders. 
    FrmOrdersHistory OrderHistory; // panels with order history

    Printer printer;// selected printers by the user. 

    Timer OrderTimer; // Order Timer. 
    Timer PrinterTimer; // Printer Timer. 

    Timer OrderHistoryTimer; // Order history timer. 

    Report report; // report class to create report and send for printing. 

    SelectPrinters printerDialog;

    Data data;

    private static FrmOrder instance = null;

    /**
     * Order class constructor.
     *
     * @param data
     */
    private FrmOrder() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon/Artboard.png")));
        initComponents();
        setExtendedState(getExtendedState()
                | FrmOrder.MAXIMIZED_VERT
                | FrmOrder.MAXIMIZED_HORIZ);

    }

    public void setData(Data data) {
        this.data = data;
    }

    public static FrmOrder getInstance() {
        if (instance == null) {
            instance = new FrmOrder();
        }
        return instance;
    }

    /**
     * Getting the selected printer.
     *
     * @return printer.
     */
    public Printer getPrinter() {
        return printer;
    }

    /**
     * Setting the selected printer.
     *
     * @param printer setting the Printer.
     */
    public void setPrinter(Printer printer) {
        this.printer = printer;
    }

    /**
     * This is user by Login to open the Printer dialog to select the printer at
     * Startup.
     *
     * @return the SelectPrinterDialog.
     */
    public SelectPrinters getPrinterDialog() {
        printerDialog = new SelectPrinters(this, true);
        return printerDialog;
    }

    /**
     * It will fill the Scroll Panel with the order panel. Starting Order in new
     * thread.
     *
     * It will fill the OrderScrollPane with the Order history Pane. Starting
     * Search for new Order in new Thread in new Thread.
     */
    public void run() {

        fillOrderTable();

        new SearchOrders().start();

        fillOrderHistoryTable();

        new SearchOrderHistory().start();

    }

    /**
     * This SearchOrder thread Runs for every 1sec 10 time. When the Counter =
     * 10. It will fill the order Table.
     *
     */
    class SearchOrders extends Thread {

        int Counter = Integer.parseInt(EnjoyFoodConfig.getOrderTimer());

        @Override
        public void run() {

            OrderTimer = new Timer(1000, (ActionEvent e) -> {

                if (Counter < 0) {
                    Counter = Integer.parseInt(EnjoyFoodConfig.getOrderTimer());

                    // Caling the fill Order table Method. 
                    fillOrderTable();
                }

                setTitle("Order refresh in " + Counter-- + " sec");

            });

            OrderTimer.start();
        }

    }

    /**
     * Filling the order from JSON object to JTable.
     */
    public void fillOrderTable() {

        if (orderPanel != null) {

            OrderMainPanel.remove(orderPanel);

        }

        orderPanel = new FrmOrders(data);

        toolBar.setLayout(new FlowLayout(FlowLayout.RIGHT));

        OrderMainPanel.setViewportView(orderPanel);

        OrderMainPanel.repaint();
        OrderMainPanel.revalidate();

        if (!orderPanel.getOrderList().isEmpty()) {
            ScheduleStartPrinting(10);
        }
    }

    /**
     * Schedule the Printing job to run after 5sec.
     *
     */
    private void ScheduleStartPrinting(int seconds) {

        if (OrderTimer != null) {
            OrderTimer.stop();
        }

        PrinterTimer = new Timer(seconds * 1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                setTitle("Printing started. ");
                StartPrinting();
            }
        });

        PrinterTimer.setDelay(0);
        PrinterTimer.start();

    }

    private void StartPrinting() {

        for (int i = 0; i < orderPanel.getOrderList().size(); i++) {

            com.akman.enjoyfood.newOrder.FrmOrder orders = orderPanel.getOrderList().get(i);

            new Report(orders, printer).PrintReport();

            OrderCompleted(orders.getId());

        }

        OrderTimer.start();

        PrinterTimer.stop();

    }

    /**
     * Search Order History after 10 sec.
     *
     */
    class SearchOrderHistory extends Thread {

        int Counter = Integer.parseInt(EnjoyFoodConfig.getHistoryTimer());

        @Override
        public void run() {
            OrderHistoryTimer = new Timer(1000, (ActionEvent e) -> {
                if (Counter < 0) {
                    Counter = Integer.parseInt(EnjoyFoodConfig.getHistoryTimer());
                    fillOrderHistoryTable();
                }
            });

            OrderHistoryTimer.start();
        }

    }

    public void fillOrderHistoryTable() {

        if (OrderHistory != null) {

            OrderHistoryPanel.remove(OrderHistory);

        }

        OrderHistory = new FrmOrdersHistory(data);
        OrderHistoryPanel.setViewportView(OrderHistory);

    }

    /**
     * Complete the Order from Customer.
     *
     * @param orderID
     */
    private void OrderCompleted(String orderID) {

        Map<String, String> params = new HashMap<>();

        params.put("order_id", orderID);
        params.put("X-API-KEY", "ii8emru251838967zasIIUjL98841302");
        params.put("is_mobile", "true");

        try {
            HttpUtility.sendPostRequest(Constants.URL_POST_ORDERS, params);

            String response = HttpUtility.readSingleLineRespone();

            JSONObject status = new JSONObject(response);

            if (status.getString("status").equals("success")) {

                if (orderPanel != null) {

                }

            } else {
                OrderCompleted(orderID);
            }

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), null, JOptionPane.ERROR_MESSAGE);
        }

        HttpUtility.disconnect();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        toolBar = new javax.swing.JToolBar();
        btnRefresh = new javax.swing.JButton();
        lblStatus = new org.jdesktop.swingx.JXLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        OrderMainPanel = new javax.swing.JScrollPane();
        OrderHistoryPanel = new javax.swing.JScrollPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        menuExit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menutimer = new javax.swing.JMenuItem();
        menuLogin = new javax.swing.JMenuItem();

        toolBar.setFloatable(false);
        toolBar.setRollover(true);

        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logo.png"))); // NOI18N
        btnRefresh.setText("Refresh");
        btnRefresh.setFocusable(false);
        btnRefresh.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnRefresh.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnRefresh.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        toolBar.add(btnRefresh);

        lblStatus.setForeground(new java.awt.Color(255, 102, 0));
        lblStatus.setLabelFor(btnRefresh);
        lblStatus.setToolTipText("");
        lblStatus.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(lblStatus);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Orders");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTabbedPane1.addTab("Order", null, OrderMainPanel, "");
        jTabbedPane1.addTab("Order History", OrderHistoryPanel);

        jMenu1.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Select Printer");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Log Off");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        menuExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        menuExit.setText("Exit");
        menuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuExitActionPerformed(evt);
            }
        });
        jMenu1.add(menuExit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Settings");

        menutimer.setText("Timer");
        menutimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menutimerActionPerformed(evt);
            }
        });
        jMenu2.add(menutimer);

        menuLogin.setText("Auto Login");
        menuLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLoginActionPerformed(evt);
            }
        });
        jMenu2.add(menuLogin);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1054, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 799, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        fillOrderTable();
        OrderTimer.stop();
        run();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        System.out.println("Window closing event ocure: Timer is stopped. ");

        if (OrderTimer != null) {
            OrderTimer.stop();
        }

        if (PrinterTimer != null) {
            PrinterTimer.stop();
        }

        if (OrderHistoryTimer != null) {
            OrderHistoryTimer.stop();
        }

    }//GEN-LAST:event_formWindowClosing

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

        System.out.println("order timer " + OrderTimer);
        System.out.println("Printer timer " + PrinterTimer);
        System.out.println("OrderHistory timer " + OrderHistoryTimer);
        System.out.println("order Panel " + orderPanel);
        System.out.println("Order History " + OrderHistory);

        if (OrderTimer != null) {
            OrderTimer.stop();
        }

        if (PrinterTimer != null) {
            PrinterTimer.stop();
        }

        if (OrderHistoryTimer != null) {
            OrderHistoryTimer.stop();
        }
        if (orderPanel != null) {
            OrderMainPanel.remove(orderPanel);
        }

        if (OrderHistory != null) {
            OrderHistoryPanel.remove(OrderHistory);
        }

        this.getPrinterDialog();
        printerDialog.setVisible(true);

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

        loginform login = new loginform();

        if (OrderTimer != null) {
            OrderTimer.stop();
        }

        if (PrinterTimer != null) {
            PrinterTimer.stop();
        }

        if (OrderHistoryTimer != null) {
            OrderHistoryTimer.stop();
        }
        if (orderPanel != null) {
            OrderMainPanel.remove(orderPanel);
        }

        if (OrderHistory != null) {
            OrderHistoryPanel.remove(OrderHistory);
        }

        login.setVisible(true);

        dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void menutimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menutimerActionPerformed
        Timers timer = new Timers(this, true);
        timer.setVisible(true);
        
    }//GEN-LAST:event_menutimerActionPerformed

    private void menuLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLoginActionPerformed
        Login login = new Login(this, true);
        login.setVisible(true);
    }//GEN-LAST:event_menuLoginActionPerformed

    private void menuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuExitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane OrderHistoryPanel;
    private javax.swing.JScrollPane OrderMainPanel;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private org.jdesktop.swingx.JXLabel lblStatus;
    private javax.swing.JMenuItem menuExit;
    private javax.swing.JMenuItem menuLogin;
    private javax.swing.JMenuItem menutimer;
    private javax.swing.JToolBar toolBar;
    // End of variables declaration//GEN-END:variables
}
