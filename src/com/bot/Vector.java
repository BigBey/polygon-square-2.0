package com.bot;

import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphJustificationInfo;
import java.awt.font.GlyphMetrics;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * Created by Слава on 30.04.2017.
 */
public class Vector extends JPanel {
    private int x;
    private int y;
    public Vector(int x, int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public void paint(Graphics g) {
        Graphics2D gr2d = (Graphics2D) g;
        BasicStroke с = new BasicStroke(2);
        gr2d.setStroke(с);
        gr2d.setPaint(Color.green);
        g.drawLine(0,0,x , y);
        g.drawLine(x, y, x-10,y+2);
        g.drawLine(x, y, x-10,y-2);
    }
}
