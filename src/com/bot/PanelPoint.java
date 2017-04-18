package com.bot;

import javax.swing.*;

/**
 * Created by Слава on 16.04.2017.
 */
public class PanelPoint extends JPanel{
    int n;
    JLabel X = new JLabel("X"+n+":");
    JLabel Y =new JLabel("Y"+n+":");
    JTextField x = new JTextField();
    JTextField y = new JTextField();
    PanelPoint(int n){
        X.setBounds(0,0, 20,30);
        Y.setBounds(60,0,20,30);
        add(X);
        add(Y);
        x.setBounds(20,0,20,30);
        y.setBounds(80,0,20,30);
        setLayout(null);
        add(x);
        add(y);
        System.out.println("called "+n);
        repaint();
        revalidate();
    }

    public int getX(JTextField x){
        int x1=(!x.getText().equals("")?Integer.parseInt(x.getText()):0);
        return x1;
    }
    public int getY(JTextField x){
        int y1=(!y.getText().equals("")?Integer.parseInt(y.getText()):0);
        return y1;
    }
}
