package com.visual;


import javax.swing.*;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.ArrayList;


/**
 * Created by Слава on 17.04.2017.
 */
public class PolygonD extends JPanel {
    private int n;
    private ArrayList<PanelPoint> panelPoints = new ArrayList<>();

    public  PolygonD(int n, ArrayList<PanelPoint> panelPoints) {
        this.n = n;
        for (PanelPoint p: panelPoints){
            this.panelPoints.add(p);
        }
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D gr2d = (Graphics2D) g;
        BasicStroke с = new BasicStroke(3);
        gr2d.setStroke(с);
        gr2d.setPaint(Color.MAGENTA);
        Polygon j = new Polygon();
        for(int i =0; i<n;i++){
            j.addPoint(Main.panelPoints.get(i).Xget(),Main.panelPoints.get(i).Yget());
        }
        g.drawPolygon(j);

    }


}
