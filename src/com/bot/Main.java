package com.bot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Point> points = new ArrayList<Point>();
    private static ArrayList<PanelPoint> panelPoints = new ArrayList<PanelPoint>();
    public static void createGUI() {
        final JFrame frame = new JFrame("Testframe");
	    frame.setPreferredSize(new Dimension(900,900));
	    JPanel panel = new JPanel(new BorderLayout());
        final Panel butPanel = new Panel();
        butPanel.setLayout(null);
        butPanel.setPreferredSize(new Dimension(300,700));
        final Panel pointpane   = new Panel();
        pointpane.setLayout(null);
        final Panel panelpointpane = new Panel();
        panelpointpane.setLayout(null);
        //pointpane.setPreferredSize(new Dimension(350,700));

	    JLabel addPointwithCoords = new JLabel("Добавить колличество вершин"+"\n"+" многоугольника");
	    addPointwithCoords.setBounds(2,2,300,25);
	    butPanel.add(addPointwithCoords);
        JLabel N = new JLabel("N:");
        N.setBounds(2,25,15,25);
        butPanel.add(N);
        final JTextField n = new JTextField();
        n.setBounds(20,30, 25,25);
        butPanel.add(n);

        JButton button3 = new JButton( "ОК");
        butPanel.add(button3);
        button3.setBounds(2,100,70,30);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int N = (!n.getText().equals("")?Integer.parseInt(n.getText()):0);
                for (int i = 0;i<N;i++) {
                    PanelPoint pp = new PanelPoint(i+1);
                    pp.setBounds(0,300+i*40,300,400);
                    panelPoints.add(pp);
                    butPanel.add(pp);
                    butPanel.repaint();
                }
            }
        });
        JButton button2 = new JButton("очистить");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i=0;i<points.size();i++){
                    while(points.size() > 0) {
                        int index = points.size() - 1;
                        Point point = points.remove(index);
                        pointpane.remove(point);
                        pointpane.repaint();
                        pointpane.revalidate();
                    }
                }
                for (int i=0;i<panelPoints.size();i++){
                    while(panelPoints.size() > 0) {
                        int index = panelPoints.size() - 1;
                        PanelPoint ppoint = panelPoints.remove(index);
                        panelpointpane.remove(ppoint);
                        panelpointpane.repaint();
                        panelpointpane.revalidate();
                    }
                }
            }
        });
        button2.setBounds(2,150,160,30);
        butPanel.add(button2);
        panel.add(pointpane,BorderLayout.CENTER);
        panel.add(butPanel,BorderLayout.EAST);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        JButton button4 = new JButton("нарисовать многоугольник");
        button4.setBounds(2,200,250,30);
        butPanel.add(button4);
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }


    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                createGUI();
            }
        });
    }
}
