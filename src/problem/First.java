package problem;

import java.util.Scanner;



/**
 * Created by bejsi.18 on 15.02.2017.
 */
public class First {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Hello, world!");
        int n =sc.nextInt();
        Point pArr [] = new Point[n];
        for(int i = 0; i<pArr.length;i++){
            double x = sc.nextDouble();
            double y =sc.nextDouble();
            pArr[i]= new Point(x,y);
        }

        Polygon p = new Polygon(pArr);
       System.out.println(p.getArea(p));
    }

}
