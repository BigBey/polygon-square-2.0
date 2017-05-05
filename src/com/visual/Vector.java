package com.visual;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Слава on 30.04.2017.
 */
public class Vector extends JPanel {
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private int xr;
    private int yr;
    private int xl;
    private int yl;
    private double c = Math.PI/6;
    private int r = 30;
    public Vector(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    @Override
    public void paint(Graphics g) {
        Graphics2D gr2d = (Graphics2D) g;
        BasicStroke с = new BasicStroke(2);
        gr2d.setStroke(с);
        gr2d.setPaint(Color.green);
        double beta = Math.atan2(y1 - y2, x2 - x1);
        int r1 = 10;
        int x3 = (int) Math.round(x2 - r1 * Math.cos(beta + c));
        int y3 = (int) Math.round(y2 + r1 * Math.sin(beta + c));
        int x4 = (int) Math.round(x2 - r1 * Math.cos(beta - c));
        int y4 = (int) Math.round(y2 + r1 * Math.sin(beta - c));
        g.drawLine(x1, y1, x2, y2);
        g.drawLine(x2, y2, x3, y3);
        g.drawLine(x2, y2, x4, y4);
    }
}
