package problem;

public class Triangle {
    public Point a;
    public Point b;

    public Triangle(Point a, Point b) {
        this.a = a;
        this.b = b;
    }

    public double getOrientArea(){
        return 0.5*(this.a.x*this.b.y-this.b.x*this.a.y);
    }
}
