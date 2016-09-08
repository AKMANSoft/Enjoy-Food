/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akman.enjoyfood.utils;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

/**
 *
 * @author BTACTC
 */
public class BordersFonts {

    public static final Border lineBorder = BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2);

    public static final Border SingleLine = BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 1);

    public static final Border emptyBorder = BorderFactory.createEmptyBorder(5, 10, 5, 5);

    public static final Border CompoundBorder = BorderFactory.createCompoundBorder(SingleLine, emptyBorder);

    private static final Font font = new Font("serif", Font.BOLD, 16);

    public static void FontSettings(JLabel label) {

        label.setFont(font);
        label.setForeground(Color.WHITE);

        label.setBackground(new Color(255, 130, 50));
        label.setOpaque(true);
    }

}
