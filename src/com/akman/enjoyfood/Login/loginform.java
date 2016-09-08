package com.akman.enjoyfood.Login;

import com.akman.enjoyfood.FrmOrder;
import com.akman.enjoyfood.TryIcon;
import com.akman.enjoyfood.utils.EnjoyFoodConfig;
import com.akman.enjoyfood.utils.SettingDefaultPrinter;
import config.Timers;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

/**
 * This Class is user for check the username and password. if the username and
 * password it correct it will automatic login.
 *
 * @author AKMAN Software Solution. Skype: aqeel.haider96
 */
public class loginform extends javax.swing.JFrame {

    /**
     * Constructor of the Login form class. It will first call the getImage
     * Background method in class to set it.
     *
     * Then set the username and password from the Configuration file.
     *
     */
    private Login login;
    String propFileName = "config.properties";
    PropertiesConfiguration prop;

    public loginform() {

        try {
            prop = new PropertiesConfiguration(propFileName);
        } catch (ConfigurationException ex) {
            Logger.getLogger(loginform.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (EnjoyFoodConfig.getLogin().equals("Auto")) {

            Login();
            this.dispose();
            return;
        }

        // Frame will set visiable if the login method is not automatic. 
        this.setVisible(true);

        // Setting the JFrame Icon. 
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon/Artboard.png")));

        // Setting the Background Image. 
        this.setContentPane(getImageBackground());

        initComponents();

        // getting the username and password from the config file. 
        txtUserName.setText(EnjoyFoodConfig.getUsername());
        txtPassword.setText(EnjoyFoodConfig.getPassword());

    }

    /**
     * Select Image from image folder of application. Scale the image to 750,
     * 550 and set the icon of J label
     *
     * @return J label with the image icon.
     */
    private JLabel getImageBackground() {

        BufferedImage img = null;

        try {
            img = ImageIO.read(getClass().getResource("/icon/Background.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Image newImage = img.getScaledInstance(730, 530, java.awt.Image.SCALE_SMOOTH);
        JLabel background = new JLabel(new ImageIcon(newImage));

        return background;

    }

    private void installConfig() {

        try {
            // set the properties value
            prop.setProperty("Login", "Auto");
            prop.setProperty("NewInstallation", "No");

            prop.save();
        } catch (ConfigurationException ex) {
            Logger.getLogger(Timers.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * This method verify the username and password from the JSON and Login
     * user.
     *
     */
    private void Login() {

        String username = EnjoyFoodConfig.getUsername();
        String password = EnjoyFoodConfig.getPassword();

        String url = "https://www.njoyful.com/api/login/bartender?X-API-KEY=null"
                + "&is_mobile=true&email=" + username + "&password=" + password;

        login = new Login(username, password);

        login.setURL(url);

        login.convertJsonToString();

        login.setJSONObject();

        login.setStatus();

        FrmOrder.getInstance().setData(login.getStoreData());
        this.dispose();
        FrmOrder.getInstance();
        FrmOrder.getInstance().setState(FrmOrder.NORMAL);
        FrmOrder.getInstance().setPrinter(SettingDefaultPrinter.DefaultPrinter());
        FrmOrder.getInstance().run();
        TryIcon.CreateTray();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtPassword = new javax.swing.JPasswordField();
        lblStatus = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        chkRemember = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 530));

        txtPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPasswordMouseClicked(evt);
            }
        });

        lblStatus.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblStatus.setForeground(new java.awt.Color(255, 102, 102));
        lblStatus.setText("  ");

        btnExit.setBackground(new java.awt.Color(255, 102, 0));
        btnExit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setText("EXIT");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnLogin.setBackground(new java.awt.Color(255, 102, 0));
        btnLogin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("LOGIN");
        btnLogin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Enjoyfood_1.png"))); // NOI18N

        txtUserName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtUserNameMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 102, 51));
        jLabel2.setText("PASSWORD:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 51));
        jLabel1.setText("NAME:");

        chkRemember.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chkRemember.setForeground(new java.awt.Color(255, 102, 51));
        chkRemember.setText("Remember me");
        chkRemember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkRememberActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(432, 432, 432)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtUserName)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chkRemember, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(28, 28, 28)
                                .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkRemember)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * This Action event check the username and password from the API. It will
     * check first that Internet is Present if not it will show error.
     *
     * If Remember me check box is selected it will save the username and
     * password in the registry.
     *
     * If the username and password is correct then it will open the main Login
     * screen.
     *
     * @param evt
     */

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed

        System.out.println("Button login pressed. ");
        lblStatus.setText("  ");

        String username = txtUserName.getText();
        String password = txtPassword.getText();

        String url = "https://www.njoyful.com/api/login/bartender?X-API-KEY=null"
                + "&is_mobile=true&email=" + username + "&password=" + password;

        login = new Login(username, password);

        login.setURL(url);

        login.convertJsonToString();

        login.setJSONObject();

        login.setStatus();

        
        if (!login.getStatus()) {
            lblStatus.setText("Username or Password is incorrect!");
            return;
        }
        

        if (chkRemember.isSelected()) {
            System.out.println("check remeber is selected");
            prop.setProperty("Username", txtUserName.getText());
            prop.setProperty("Password", txtPassword.getText());
            try {
                prop.save();
            } catch (ConfigurationException ex) {
                Logger.getLogger(loginform.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (EnjoyFoodConfig.getNewInstallation().equals("Yes")) {
            installConfig();
        }

        FrmOrder.getInstance().setVisible(true);
        FrmOrder.getInstance().setData(login.getStoreData());
        FrmOrder.getInstance().setState(FrmOrder.NORMAL);
        this.dispose();
        FrmOrder.getInstance().getPrinterDialog().setVisible(true);
        TryIcon.CreateTray();


    }//GEN-LAST:event_btnLoginActionPerformed

    /**
     * It will close the login form.
     *
     * @param evt
     */
    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    /**
     * This action event will set the username and password to null.
     *
     * @param evt
     */
    private void txtPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPasswordMouseClicked
        lblStatus.setText(null);
    }//GEN-LAST:event_txtPasswordMouseClicked

    /**
     * This action event will set the username and password to null.
     *
     * @param evt
     */

    private void txtUserNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUserNameMouseClicked
        lblStatus.setText(null);
    }//GEN-LAST:event_txtUserNameMouseClicked

    private void chkRememberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkRememberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkRememberActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loginform.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new loginform();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLogin;
    private javax.swing.JCheckBox chkRemember;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
