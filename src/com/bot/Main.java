package com.bot;

import problem.*;
import problem.Polygon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static ArrayList<Point> points = new ArrayList<Point>();
    public static ArrayList<PanelPoint> panelPoints = new ArrayList<PanelPoint>();
    public static ArrayList<Vector> vectors = new ArrayList<>();
    public static PolygonD pol;
    public static Random random = new Random();
    Scanner fin = null;
    PrintStream fout = null;


    public static void addPanelPoints(int k, JPanel p){
        if (k==0){
            p.removeAll();
            p.repaint();
            p.revalidate();
            return;
        }
        for (int i = 0;i<k;i++) {
            PanelPoint pp = new PanelPoint(i+1);
            pp.setBounds(0,i*50,300,50);
            panelPoints.add(pp);
            p.add(pp);
            p.repaint();
        }
    }
    public static void addPanelPoints(int k, JPanel p, Scanner fin){
        if (k==0){
            p.removeAll();
            p.repaint();
            p.revalidate();
            return;
        }
        for (int i = 0;i<k;i++) {
            PanelPoint pp = new PanelPoint(i+1, fin.nextInt(), fin.nextInt());
            pp.setBounds(0,i*50,300,50);
            panelPoints.add(pp);
            p.add(pp);
            p.repaint();
        }
    }
    public static void addPanelPoints(int k, JPanel p, int x0, int y0){
        double cor = 0.0;
        double dcor = 360/k;
        if (k==0){
            p.removeAll();
            p.repaint();
            p.revalidate();
            return;
        }
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

        final JLabel A = new JLabel("Ответ(площадь мн-ка):");
        A.setBounds(2, 320, 150, 25);
        butPanel.add(A);

        final JTextField a = new JTextField("");
        a.setBounds(130,320, 100,30);
        butPanel.add(a);

        final JPanel p = new JPanel();
        p.setBounds(0,400,300,400);
        butPanel.add(p);

        JButton button2 = new JButton("очистить");
        button2.setBounds(2,360,160,30);
        butPanel.add(button2);


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
                    while(vectors.size() > 0) {
                        int index = vectors.size() - 1;
                        Vector vector = vectors.remove(index);
                        panelpointpane.remove(vector);
                        panelpointpane.repaint();
                        panelpointpane.revalidate();
                    }
                }
                panelpointpane.remove(pol);
                a.setText("");
                n.setText("");

            }
        });

        panel.add(panelpointpane,BorderLayout.CENTER);
        panel.add(butPanel,BorderLayout.EAST);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        final JButton button3 = new JButton( "Добавить колличество вершин");
        butPanel.add(button3);
        button3.setBounds(2,2,250,30);

        button3.addActionListener(new ActionListener() {
            @Override
            public  void actionPerformed(ActionEvent e) {
                int K = (!n.getText().equals("")?Integer.parseInt(n.getText()):0);
                addPanelPoints(K, p);
            }
        });

        JButton button4 = new JButton("нарисовать многоугольник");
        button4.setBounds(2,220,250,30);
        butPanel.add(button4);

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int s = (!n.getText().equals("")?Integer.parseInt(n.getText()):0);
             pol = new PolygonD(s,Main.panelPoints);
             pol.setBounds(0,0,350,700);
             panelpointpane.add(pol);
             panelpointpane.repaint();
             for(int i = 0;i<s; i++){
                 Vector v = new Vector(Main.panelPoints.get(i).Xget(), Main.panelPoints.get(i).Yget());
                 v.setBounds(0,0,350,700);
                 vectors.add(v);
                 panelpointpane.add(v);
                 panelpointpane.repaint();
             }

            }
        });

        JButton button5 = new JButton("посчитать площадь");
        button5.setBounds(2,270,250,30);
        butPanel.add(button5);

        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int l = (!n.getText().equals("")?Integer.parseInt(n.getText()):0);
                problem.Polygon polygon = new problem.Polygon(l,Main.panelPoints);
                double s = polygon.getArea(polygon);
                a.setText(""+s);
            }
        });

        JButton button6 = new JButton("задать случайные вершины");
        button6.setBounds(2,50,250,30);
        butPanel.add(button6);

        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int k = (!n.getText().equals("")?Integer.parseInt(n.getText()):0);
                int x0 = random.nextInt(300);
                int y0 = random.nextInt(300);
                addPanelPoints(k, p ,x0,y0);
            }
        });

        JButton button7 = new JButton("чтение из файла");
        button7.setBounds(2,130,160,30);
        butPanel.add(button7);

        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Scanner fin = null;
                PrintStream fout = null;
                try {
                    fin = new Scanner(new File("in.txt"));
                    fout = new PrintStream(new File("out.txt"));
                    int k = fin.nextInt();
                    n.setText(""+k);
                    panelPoints.clear();
                    addPanelPoints(k, p, fin);
                }catch(FileNotFoundException e1){
                    System.out.println("не найден файл " + e);
                }finally {
                    if (fin != null) {
                        fin.close(); //!
                    }
                    if (fout != null) {
                        fout.close(); //!
                    }
                }
            }
        });

        JButton button8 = new JButton("вывод в файл");
        button8.setBounds(2,180,160,30);
        butPanel.add(button8);

        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Scanner fin = null;
                PrintStream fout = null;
                try {
                    fin = new Scanner(new File("in.txt"));
                    fout = new PrintStream(new File("out.txt"));
                    System.out.println(panelPoints.size());
                    fout.println(panelPoints.size());
                    for (PanelPoint p : panelPoints) {
                        System.out.println(p.Xget() + " " + p.Yget());
                        fout.println(p.Xget() + " " + p.Yget());
                    }
                    double s = (!a.getText().equals("")?Double.parseDouble(a.getText()):0);
                    fout.println(""+s);
                } catch (FileNotFoundException e1) {
                    System.out.println("не найден файл " + e);
                }finally {
                    if (fin != null) {
                        fin.close(); //!
                    }
                    if (fout != null) {
                        fout.close(); //!
                    }
                }
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
