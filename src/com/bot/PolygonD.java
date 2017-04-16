package com.bot;

import javax.swing.*;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import javax.swing.JFrame;


/**
 * Created by Слава on 17.04.2017.
 */
public class PolygonD extends JFrame {
    public PolygonD() {
        super("simpleApp");
        setSize(700, 700);
        setVisible(true);
    }
    @Override
    public void paint(Graphics g) {
        Graphics2D gr2d = (Graphics2D) g;
        gr2d.setBackground(Color.green);
        BasicStroke с = new BasicStroke(3);
        gr2d.setStroke(с);

        gr2d.setPaint(Color.blue);
        Polygon j = new Polygon();
        j.addPoint(270, 439);
        j.addPoint(185, 400);
        j.addPoint(100, 470);
        j.addPoint(200, 550);
        j.addPoint(240, 590);
        j.addPoint(270, 539);
        g.drawPolygon(j);

    }

    public static void main(String args[]) {
        PolygonD app = new PolygonD();
    }
}
