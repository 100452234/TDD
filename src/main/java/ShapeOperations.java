import java.awt.*;

public class ShapeOperations {
    // Method 15: create a method that computes the area of a rectangle and returns the result
    public static double method15(double a, double b){
        if(a<0 || b<0) {
            throw new IllegalArgumentException("Length is negative");
        }
        return a*b;
    }

    // Method 16: create a method that computes the perimeter of a circle and returns the result
    public static double method16(double r){
        if(r<0) {
            throw new IllegalArgumentException("Radius is negative");
        }
        return r*2*Math.PI;
    }

    // Method 17: create a method that classifies the type of triangle based on its sides and returns the result
    public static String method17(double s1, double s2, double s3){
        if(s1<0 || s2<0 || s3<0){
            throw new IllegalArgumentException("Side length is negative");
        }
        if(s1==0 || s2==0 || s3==0){
            throw new IllegalArgumentException("Side length is zero, so not a triangle");
        }

        if(s1 == s2 && s1==s3){
            return "equilateral";
        }else if(s1 == s2 || s2==s3 || s1==s3){
            return "isosceles";
        }else{
            return "scalene";
        }
    }

    // Method 18: create a method that returns the distance between two points
    public static double method18(Point x, Point y){
        return Math.sqrt(Math.pow(y.getX() - x.getX(), 2) + Math.pow(y.getY() - x.getY(), 2));
    }
}
