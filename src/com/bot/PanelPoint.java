package com.bot;

import javax.swing.*;

/**
 * Created by Слава on 16.04.2017.
 */
public class PanelPoint extends JPanel{
    PanelPoint(int n){
        final JLabel X = new JLabel("X"+n+":");
        final JLabel Y =new JLabel("Y"+n+":");
        X.setBounds(0,0, 20,30);
        Y.setBounds(60,0,20,30);
        add(X);
        add(Y);
        final JTextField x = new JTextField();
        final JTextField y = new JTextField();
        x.setBounds(20,0,20,30);
        y.setBounds(80,0,20,30);
        setLayout(null);
        add(x);
        add(y);
        System.out.println("called "+n);
        repaint();
        revalidate();
    }
}
