package problem;

import com.bot.PanelPoint;

import java.util.ArrayList;

/**
 * Created by Слава on 26.02.2017.
 */
public class Polygon {
    Triangle tArr[];
    Point center =new Point(0,0);


    public Polygon(int n,ArrayList<PanelPoint> panelPoints){
        tArr = new Triangle[n];
        for(int i =0;i<n;i++){
            int x =panelPoints.get(i).Xget();
            int y =panelPoints.get(i).Yget();
            int x1 =panelPoints.get(i+1).Xget();
            int y1 =panelPoints.get(i+1).Yget();
            Point pi=new Point(x,y);
            Point pi1 = new Point(x1,y1);
            this.tArr[i]= new Triangle(pi, pi1);
        }
        int x0 =panelPoints.get(0).Xget();
        int y0 =panelPoints.get(0).Yget();
        Point p0=new Point(x0,y0);
        int xl =panelPoints.get(n-1).Xget();
        int yl =panelPoints.get(n-1).Yget();
        Point pl=new Point(xl,yl);
        this.tArr[n-1]= new Triangle(pl, p0);
    }

    public double getArea(Polygon p){
        double s = 0;
        for(int i = 0;i<p.tArr.length;i++){
            s+=p.tArr[i].getOrientArea();
        }
        return Math.abs(s);
    }

}
