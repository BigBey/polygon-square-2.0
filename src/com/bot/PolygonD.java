package com.bot;

import problem.First;

import javax.swing.*;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.ArrayList;
import javax.swing.JFrame;

import static javax.swing.text.html.HTML.Attribute.N;


/**
 * Created by Слава on 17.04.2017.
 */
public class PolygonD extends JPanel {
    private int n;
    private ArrayList<Point> points = new ArrayList<>();

    public PolygonD(int n, ArrayList<Point> points) {
        this.n = n;
        for (Point p: points){
            this.points.add(p);
        }
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D gr2d = (Graphics2D) g;
        gr2d.setBackground(Color.green);
        BasicStroke с = new BasicStroke(3);
        gr2d.setStroke(с);

        gr2d.setPaint(Color.blue);
        Polygon j = new Polygon();
        for(int i =0; i<n;i++){
            j.addPoint(Main.panelPoints.get(i).getX(),Main.panelPoints.get(i).getY());
        }
        g.drawPolygon(j);

    }

    public static void main(String args[]) {
        //PolygonD app = new PolygonD();
    }
}
