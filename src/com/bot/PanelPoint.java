package com.bot;

import javax.swing.*;


/**
 * Created by Слава on 16.04.2017.
 */
public class PanelPoint extends JPanel{
    int n;
    JLabel X;
    JLabel Y;
    JTextField x;
    JTextField y;
    PanelPoint(int n){
        this.n =n;
        X = new JLabel("X"+n+":");
        Y =new JLabel("Y"+n+":");
        x = new JTextField();
        y = new JTextField();
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

    public int Xget(){
        int x1=(!x.getText().equals("")?Integer.parseInt(x.getText()):0);
        return x1;
    }
    public int Yget(){
        int y1=(!y.getText().equals("")?Integer.parseInt(y.getText()):0);
        return y1;
    }
}
