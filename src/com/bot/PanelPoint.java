package com.bot;

import javax.swing.*;

/**
 * Created by Слава on 16.04.2017.
 */
public class PanelPoint extends JPanel{
    public int b;
    public JLabel X;
    public JLabel Y;
    public JTextField x;
    public JTextField y;
    PanelPoint(int n){
        JLabel X = new JLabel("X"+n);
        JLabel Y =new JLabel("Y"+n);
        X.setBounds(50,b, 20,30);
        Y.setBounds(60,b,20,30);
        final JTextField x = new JTextField();
        final JTextField y = new JTextField();
        x.setBounds(55,b,20,30);
        y.setBounds(55,b,20,30);
    }
}
