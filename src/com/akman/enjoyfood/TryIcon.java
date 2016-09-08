/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akman.enjoyfood;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author AKMAN
 */
public class TryIcon {

    public static void CreateTray() {
        //Check the SystemTray support
        if (!SystemTray.isSupported()) {
            System.out.println("SystemTray is not supported");
            return;
        }

        final PopupMenu popup = new PopupMenu();
        final TrayIcon trayIcon
                = new TrayIcon(createImage("/icon/Artboard.png", "tray icon"));
        trayIcon.setImageAutoSize(true);
        final SystemTray tray = SystemTray.getSystemTray();

        // Create a popup menu components
        MenuItem aboutItem = new MenuItem("Orders");

        MenuItem exitItem = new MenuItem("Exit");

        //Add components to popup menu
        popup.add(aboutItem);
        popup.addSeparator();

        popup.add(exitItem);

        trayIcon.setPopupMenu(popup);

        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            System.out.println("TrayIcon could not be added.");
            return;
        }

        trayIcon.addActionListener((ActionEvent e) -> {
            FrmOrder.getInstance().setVisible(true);
            FrmOrder.getInstance().setState(FrmOrder.getInstance().NORMAL);
        });

        aboutItem.addActionListener((ActionEvent e) -> {

            FrmOrder.getInstance().setVisible(true);
            FrmOrder.getInstance().setState(FrmOrder.getInstance().NORMAL);
        });

        ActionListener listener = (ActionEvent e) -> {

            MenuItem item = (MenuItem) e.getSource();
            //TrayIcon.MessageType type = null;
            System.out.println(item.getLabel());
            if (null != item.getLabel()) {
                switch (item.getLabel()) {
                    case "Error":
                        //type = TrayIcon.MessageType.ERROR;
                        trayIcon.displayMessage("Sun TrayIcon Demo",
                                "This is an error message", TrayIcon.MessageType.ERROR);
                        break;
                    case "Warning":
                        //type = TrayIcon.MessageType.WARNING;
                        trayIcon.displayMessage("Sun TrayIcon Demo",
                                "This is a warning message", TrayIcon.MessageType.WARNING);
                        break;
                    case "Info":
                        //type = TrayIcon.MessageType.INFO;
                        trayIcon.displayMessage("Sun TrayIcon Demo",
                                "This is an info message", TrayIcon.MessageType.INFO);
                        break;
                    case "None":
                        //type = TrayIcon.MessageType.NONE;
                        trayIcon.displayMessage("Sun TrayIcon Demo",
                                "This is an ordinary message", TrayIcon.MessageType.NONE);
                        break;
                    default:
                        break;
                }
            }
        };

        exitItem.addActionListener((ActionEvent e) -> {
            tray.remove(trayIcon);
            System.exit(0);
        });
    }

    //Obtain the image URL
    protected static Image createImage(String path, String description) {
        URL imageURL = TrayIcon.class.getResource(path);

        if (imageURL == null) {
            System.err.println("Resource not found: " + path);
            return null;
        } else {
            return (new ImageIcon(imageURL, description)).getImage();
        }
    }

}
