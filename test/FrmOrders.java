
import com.akman.enjoyfood.newOrder.Item;
import com.akman.enjoyfood.newOrder.FrmOrder;
import com.akman.enjoyfood.newOrder.Orders;
import com.akman.enjoyfood.utils.Constants;
import com.akman.enjoyfood.utils.JSON_TO_String;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;
import org.json.JSONObject;

/**
 * This class take the data from the JSON and show it in grid bag layout.
 *
 *
 * @author BTACTC
 */
public class FrmOrders extends JFrame {

    private final JLabel Column1;
    private final JLabel Column2;
    private final JLabel Column3;
    private final JLabel Column4;
    private final JLabel Column5;
    private final JLabel lblStatus;

    GridBagConstraints gc;

    Border lineBorder;

    JSON_TO_String OrderData;

    JSONObject OrderObject;

    List<FrmOrder> OrderList = new ArrayList<>();

    public FrmOrders() {

        Column1 = new JLabel("Orders");
        Column2 = new JLabel("Order Items");
        Column3 = new JLabel("QTY");
        Column4 = new JLabel("Table No");
        Column5 = new JLabel("Server");
        lblStatus = new JLabel();

        lineBorder = BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2);

//        OrderData = new Convert_Json_Data_Into_String(Constants.URL_GET_ORDERS);

//        OrderObject = OrderData.getJSONObject();



//        if (OrderObject.has("status")) {
//            System.out.println("no Order found");
//            lblStatus.setText("No order found yet.");
//            return;
//        }
        
//                OrderList = Orders.getData(OrderObject);

        getContentPane().setLayout(new GridBagLayout());

        this.setSize(800, 300);

        InitlizeLayout();
        
//        Fill_Orders_FROM_JSON_TO_LAYOUT();

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
        Column1.setBorder(lineBorder);
        gc = new java.awt.GridBagConstraints();
        gc.gridx = 1;
        gc.gridy = 0;
        gc.fill = java.awt.GridBagConstraints.BOTH;
        gc.ipady = 20;
        gc.weightx = 1.0;
        this.add(Column1, gc);

        // Setting the second column name Order Items
        Column2.setBorder(lineBorder);
        gc = new java.awt.GridBagConstraints();
        gc.gridx = 0;
        gc.gridy = 0;
        gc.fill = java.awt.GridBagConstraints.BOTH;
        gc.ipadx = 100;
        gc.ipady = 20;
        this.add(Column2, gc);

        // Setting the third column name QTY. 
        Column3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Column3.setBorder(lineBorder);
        gc = new java.awt.GridBagConstraints();
        gc.gridx = 3;
        gc.gridy = 0;
        gc.fill = java.awt.GridBagConstraints.BOTH;
        gc.ipadx = 50;
        gc.ipady = 20;
        this.add(Column3, gc);

        // Seeting the Fourth Column name Table Number. 
        Column4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Column4.setBorder(lineBorder);
        gc = new java.awt.GridBagConstraints();
        gc.gridx = 2;
        gc.gridy = 0;
        gc.fill = java.awt.GridBagConstraints.BOTH;
        gc.ipadx = 50;
        gc.ipady = 20;
        this.add(Column4, gc);

        // Setting the 5th Column Name Server. 
        Column5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Column5.setBorder(lineBorder);
        gc = new java.awt.GridBagConstraints();
        gc.gridx = 4;
        gc.gridy = 0;
        gc.fill = java.awt.GridBagConstraints.BOTH;
        gc.ipadx = 50;
        gc.ipady = 20;
        this.add(Column5, gc);

    }

    private void Fill_Orders_FROM_JSON_TO_LAYOUT() {

        int j = 1;

        for (int i = 1; i <= OrderList.size(); i++) {

            int GridHeight = OrderList.get(i).getItems().size(); // Height of Grid if its not Item to match the items height. 

            JLabel OrderID = new JLabel(OrderList.get(i).getId());// First Column OrderID filling with OrderID. 
            OrderID.setBorder(lineBorder);
            gc = new GridBagConstraints(3, j, 1, GridHeight, 0, 0, 0, GridBagConstraints.BOTH, null, 10, 20);
            this.add(OrderID, gc);

            JLabel TableNo = new JLabel(OrderList.get(i).getOdTableNo());// Fourth Column Table Number Filling with Table Number.
            TableNo.setBorder(lineBorder);
            gc = new GridBagConstraints(0, j, 1, GridHeight, 0, 0, 0, GridBagConstraints.BOTH, null, 10, 20);
            this.add(TableNo, gc);
            
            JLabel Server = new JLabel(OrderList.get(i).getOdTableNo());// Fifth Column Server. 
            Server.setBorder(lineBorder);
            gc = new GridBagConstraints(0, j, 1, GridHeight, 0, 0, 0, GridBagConstraints.BOTH, null, 10, 20);
            this.add(Server, gc);

            for (Item item : OrderList.get(i).getItems()) {

                JLabel itemLabel = new JLabel(item.getItemName());
                itemLabel.setBorder(lineBorder);
                gc = new GridBagConstraints(1, j, 1, 1, 0, 0, 0, GridBagConstraints.BOTH, null, 10, 20);
                this.add(itemLabel, gc);

                j++;

            }

        }

    }

    public static void main(String[] args) {
        FrmOrders order = new FrmOrders();
        order.setVisible(true);
    }
}
