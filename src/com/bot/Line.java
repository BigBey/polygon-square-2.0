package com.bot;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Слава on 23.04.2017.
 */
public class Line extends JPanel{
    private Point a;
    private Point b;
    public Line(Point a, Point b){
        this.a = a;
        this.b = b;
    }
    @Override
    public void paint(Graphics g) {
        Graphics2D gr2d = (Graphics2D) g;
        BasicStroke с = new BasicStroke(3);
        gr2d.setStroke(с);
        gr2d.setPaint(Color.MAGENTA);
        g.drawLine(a.getX(),a.getY(),b.getX(),b.getY());


    }
}
