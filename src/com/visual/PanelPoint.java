package com.visual;

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
    JTextArea j;
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
        repaint();
        revalidate();
    }
    PanelPoint(int n, int x1, int y1){
        this.n =n;
        X = new JLabel("X"+n+":");
        Y =new JLabel("Y"+n+":");
        x = new JTextField(""+x1);
        y = new JTextField(""+y1);
        j = new JTextArea("("+x+","+y+")");
        j.setBounds(this.Xget(),this.Yget(),80,20);
        add(j);
        X.setBounds(0,0, 20,30);
        Y.setBounds(60,0,20,30);
        add(X);
        add(Y);
        x.setBounds(20,0,40,30);
        y.setBounds(80,0,40,30);
        setLayout(null);
        add(x);
        add(y);
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
