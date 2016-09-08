/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akman.enjoyfood.utils;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellRenderer;

public class TextAreaRenderer extends JTextPane
        implements TableCellRenderer {

    public TextAreaRenderer() {
//        setLineWrap(true);
//        setWrapStyleWord(true);

        
        Border border = new EmptyBorder(2, 2, 2, 2);
        Border borderI = new EmptyBorder(2, 2, 2, 2);
        
        Border Comp = new CompoundBorder(border, borderI);
        setBorder(Comp);
        

    }

    @Override
    public Component getTableCellRendererComponent(JTable jTable,
            Object obj, boolean isSelected, boolean hasFocus, int row,
            int column) {
        setText((String) obj);
        return this;
    }
}
