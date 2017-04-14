package problem;

/**
 * Created by Слава on 26.02.2017.
 */
public class Polygon {
    Triangle tArr[];
    Point center =new Point(0,0);


    Polygon(Point Arr []){
        tArr = new Triangle[Arr.length];
        for(int i =0;i<Arr.length-1;i++){
            this.tArr[i]= new Triangle(Arr[i], Arr[i+1]);
        }
        this.tArr[Arr.length-1]= new Triangle(Arr[Arr.length-1], Arr[0]);
    }

    public double getArea(Polygon p){
        double s = 0;
        for(int i = 0;i<p.tArr.length;i++){
            s+=p.tArr[i].getOrientArea();
        }
        return Math.abs(s);
    }

}
