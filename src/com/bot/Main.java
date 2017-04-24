package com.bot;

import problem.*;
import problem.Polygon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static ArrayList<Point> points = new ArrayList<Point>();
    public static ArrayList<PanelPoint> panelPoints = new ArrayList<PanelPoint>();
    public static PolygonD pol;
    public static Random random = new Random();
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

        final JLabel N = new JLabel("N:");
        N.setBounds(2,90,15,25);
        butPanel.add(N);
        final JTextField n = new JTextField();
        n.setBounds(20,90, 25,25);
        butPanel.add(n);
        final JLabel A = new JLabel("Ответ:");
        A.setBounds(2, 270, 50, 25);
        butPanel.add(A);
        


        final JButton button3 = new JButton( "Добавить колличество вершин");
        butPanel.add(button3);
        button3.setBounds(2,2,250,30);

        final JPanel p = new JPanel();
        p.setBounds(0,400,300,400);
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
                panelpointpane.remove(pol);
                JTextField a = new JTextField("");
                a.setBounds(40,270, 100,30);
                butPanel.add(a);

            }
        });
        button2.setBounds(2,220,160,30);
        butPanel.add(button2);
        panel.add(panelpointpane,BorderLayout.CENTER);
        panel.add(butPanel,BorderLayout.EAST);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        JButton button4 = new JButton("нарисовать многоугольник");
        button4.setBounds(2,130,250,30);
        butPanel.add(button4);
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int s = (!n.getText().equals("")?Integer.parseInt(n.getText()):0);
             pol = new PolygonD(s,Main.panelPoints);
             pol.setBounds(0,0,350,700);
             panelpointpane.add(pol);
             panelpointpane.repaint();

            }
        });
        JButton button5 = new JButton("посчитать площадь");
        button5.setBounds(2,180,250,30);
        butPanel.add(button5);
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int l = (!n.getText().equals("")?Integer.parseInt(n.getText()):0);
                problem.Polygon polygon = new problem.Polygon(l,Main.panelPoints);
                double s = polygon.getArea(polygon);
                JTextField a = new JTextField("s="+s);
                a.setBounds(40,270, 100,30);
                butPanel.add(a);
            }
        });
        JButton button6 = new JButton("задать случайные вершины");
        button6.setBounds(2,50,250,30);
        butPanel.add(button6);
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int k = (!n.getText().equals("")?Integer.parseInt(n.getText()):0);
                int x0 = random.nextInt(250);
                int y0 = random.nextInt(250);
                double cor = 0.0;
                double dcor = 360/k;
                for(int i =0;i<k;i++) {
                    System.out.println(cor);
                        int r = random.nextInt(100);
                    int x = x0 + (int)(r * Math.cos(cor/180*Math.PI));
                    int y =y0+(int)(r*Math.sin(cor/180*Math.PI));
                    PanelPoint pp = new PanelPoint(i+1,x,y);
                    pp.setBounds(0,i*50,300,50);
                    panelPoints.add(pp);
                    p.add(pp);
                    p.repaint();
                    cor+=dcor;
                }
            }
        });
        JButton button7 = new JButton("чтение из файла");
        button7.setBounds(2,320,160,30);
        butPanel.add(button7);
        JButton button8 = new JButton("вывод в файл");
        button8.setBounds(2,360,160,30);
        butPanel.add(button8);
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
