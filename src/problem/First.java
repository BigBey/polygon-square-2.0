package problem;

import java.util.Scanner;



/**
 * Created by bejsi.18 on 15.02.2017.
 */
public class First {
    static Scanner sc =new Scanner(System.in);
    static int n =sc.nextInt();
    public static Point pArr [] = new Point[n];
    public  void main(String[] args) {
        System.out.println("Hello, world!");
        for(int i = 0; i<pArr.length;i++){
            double x = sc.nextDouble();
            double y =sc.nextDouble();
            pArr[i]= new Point(x,y);
        }

        Polygon p = new Polygon(pArr);
       System.out.println(p.getArea(p));
    }

}
