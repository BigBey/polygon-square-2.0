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
    public static ArrayList<PanelPoint> panelPoints = new ArrayList<PanelPoint>();
    public static void createGUI() {
        final JFrame frame = new JFrame("Testframe");
	    frame.setPreferredSize(new Dimension(700,700));
	    JPanel panel = new JPanel(new BorderLayout());
        final Panel butPanel = new Panel();
        butPanel.setLayout(null);
        butPanel.setPreferredSize(new Dimension(300,700));
        final Panel panelpointpane = new Panel();
        panelpointpane.setLayout(null);
        panelpointpane.setPreferredSize(new Dimension(350,700));

	    JLabel addPointwithCoords = new JLabel("Добавить колличество вершин"+"\n"+" многоугольника");
	    addPointwithCoords.setBounds(2,2,300,25);
	    butPanel.add(addPointwithCoords);
        final JLabel N = new JLabel("N:");
        N.setBounds(2,25,15,25);
        butPanel.add(N);
        final JTextField n = new JTextField();
        n.setBounds(20,30, 25,25);
        butPanel.add(n);

        final JButton button3 = new JButton( "ОК");
        butPanel.add(button3);
        button3.setBounds(2,100,70,30);

        final JPanel p = new JPanel();
        p.setBounds(0,300,300,400);
        butPanel.add(p);


        button3.addActionListener(new ActionListener() {
            @Override
            public  void actionPerformed(ActionEvent e) {
                int K = (!n.getText().equals("")?Integer.parseInt(n.getText()):0);
                if (K==0){
                    p.removeAll();
                    p.repaint();
                    p.revalidate();
                    return;
                }
                for (int i = 0;i<K;i++) {
                    PanelPoint pp = new PanelPoint(i+1);
                    pp.setBounds(0,i*50,300,50);
                    panelPoints.add(pp);
                    p.add(pp);
                    p.repaint();
                }
            }
        });
        JButton button2 = new JButton("очистить");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
        panel.add(panelpointpane,BorderLayout.CENTER);
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
                int s = (!n.getText().equals("")?Integer.parseInt(n.getText()):0);
             PolygonD pol = new PolygonD(s,Main.panelPoints);
             panelpointpane.add(pol);
             panelpointpane.repaint();
             pol.setBounds(0,0,350,700);
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
