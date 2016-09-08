package com.akman.enjoyfood.utils;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JComponent;
import javax.swing.UIManager;
import org.jdesktop.swingx.JXBusyLabel;

@SuppressWarnings("serial")
public class GlassPane extends JComponent implements KeyListener {

    private static Cursor WAIT_CURSOR = Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR);

    private JXBusyLabel wheel;

    public GlassPane()  {
        super.setOpaque( false );
        super.setLayout( new GridBagLayout() );
        System.out.println("Backgorund colour is "+initBackground());
        super.setBackground(initBackground());
        initWheel();
        addEventCatchers();
    }

    private void addEventCatchers() {
        addMouseListener( new MouseAdapter() {} );
        addMouseMotionListener( new MouseMotionAdapter() {} );
        addKeyListener(this);
        setFocusTraversalKeysEnabled(false);        
    }

    private Color initBackground() {
        Color base = UIManager.getColor("inactiveCaption");
        System.out.println(base);
        Color background = new Color(base.getRed(), base.getGreen(), base.getBlue(), 128);
        return background;
    }

    private void initWheel() {
        wheel = new JXBusyLabel(new Dimension(300, 300));
        add(wheel, new GridBagConstraints());
    }

    /*
     *  The component is transparent but we want to paint the background
     *  to give it the disabled look.
     */
    @Override
    protected void paintComponent(Graphics g)   {
        g.setColor( getBackground() );
        g.fillRect(0, 0, getSize().width, getSize().height);
    }

    /*
     *  Make the glass pane visible, start the wheel and change the cursor to the wait cursor
     */
    public void activate(boolean toggle) {
        wheel.setVisible(toggle);
        wheel.setBusy(toggle);
        super.setVisible( toggle );
        setCursor(getCursor());
        if(super.isVisible()){
            requestFocusInWindow();
        }
    }

    @Override
    public Cursor getCursor(){
        Cursor cursor = this.isVisible() ? GlassPane.WAIT_CURSOR : null; 
        return cursor;
    }

    /*
    *  Implement the KeyListener to consume events
    */
    @Override
    public void keyPressed(java.awt.event.KeyEvent e)  {
        e.consume();
    }
    @Override
    public void keyReleased(java.awt.event.KeyEvent e) {
        e.consume();
    }

    @Override
    public void keyTyped(java.awt.event.KeyEvent e) {}



}
