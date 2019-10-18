package ak.dz.first;

public class Distance {
    public static void main(String[] args) {
        Point p1 = new Point(5,-4);
        Point p2 = new Point(2,8);

        System.out.println("Distance is "+ distance(p1, p2)); //for method for counting (point 2 and 3 in DZ)
    }
    //method for counting (point 2 and 3 in DZ)
    public static double distance(Point p1, Point p2) {
        double d1 = p2.x-p1.x;
        double d2 = p2.y-p1.y;
        return Math.sqrt(d1*d1+d2*d2);
    }
}
