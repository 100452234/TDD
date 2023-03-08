import java.text.DecimalFormat;

public class Calculator {
    // Method 1: create a method that adds 2 numbers and returns the result
    public static double method1(double a, double b){
        return a+b;
    }

    // Method 2: a method that adds 2 positive numbers and returns the result
    public static double method2(double a, double b){
        if(a < 0 || b < 0){
            throw new IllegalArgumentException("Negative number");
        }
        return method1(a, b);
    }

    // Method 3: a method that divides 2 numbers and returns the result
    public static double method3(double a, double b){
        if (b == 0){
            throw new ArithmeticException("Division by zero");
        }
        return a/b;
    }

    // Method 4: develop a method that returns the square root of a number
    public static double method4(double a){
        if (a < 0){
            throw new ArithmeticException("Square root of negative number");
        }
        return Math.sqrt(a);
    }

    // Method 5: develop a method that returns the square root of a number
    public static double method5(double a){
        if (a < 0){
            throw new ArithmeticException("Square root of negative number");
        }
        return Math.sqrt(a);
    }

}
