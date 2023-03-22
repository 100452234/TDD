import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;
import java.awt.*;

public class ShapeOperationsTest {
    // Method 15
    // Test result is correct
    @ParameterizedTest(name = "Check if area of rectangle {0}x{1} is {2}")
    @MethodSource("sourceMethod15_result")
    public void checkMethod15_result(double n1, double n2, double expected){
        Assertions.assertEquals(expected, ShapeOperations.method15(n1, n2), 0.01);
    }
    public static Stream<Arguments> sourceMethod15_result(){
        return Stream.of(
                Arguments.arguments(2, 3, 6),
                Arguments.arguments(54, 20, 1080),
                Arguments.arguments(25.3d, 38.6d, 976.58d),
                Arguments.arguments(1.00234d, 7.8943d, 7.91d),
                Arguments.arguments(4, 0, 0)
        );
    }

    // Test exception thrown when rectangle side is negative
    @ParameterizedTest(name = "Check throw if {0}<0 or {1}<0")
    @MethodSource("sourceMethod15_throw")
    public void checkMethod15_throw(double n1, double n2){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            ShapeOperations.method15(n1, n2);
        });
    }
    public static Stream<Arguments> sourceMethod15_throw(){
        return Stream.of(
                Arguments.arguments(-3, 2),
                Arguments.arguments(0, -6)
        );
    }

    // Method 16
    // Test result is correct
    @ParameterizedTest(name = "Check if perimeter of circle radius {0} is {1}")
    @MethodSource("sourceMethod16_result")
    public void checkMethod16_result(double n1, double expected){
        Assertions.assertEquals(expected, ShapeOperations.method16(n1));
    }
    public static Stream<Arguments> sourceMethod16_result(){
        return Stream.of(
                Arguments.arguments(2, 4*Math.PI),
                Arguments.arguments(54, 108*Math.PI),
                Arguments.arguments(25.3d, 50.6*Math.PI),
                Arguments.arguments(1.00894d, 2.01788*Math.PI),
                Arguments.arguments(0, 0)
        );
    }

    // Test exception thrown when radius is negative
    @ParameterizedTest(name = "Check throw if {0}<0")
    @MethodSource("sourceMethod16_throw")
    public void checkMethod16_throw(double n1){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            ShapeOperations.method16(n1);
        });
    }
    public static Stream<Arguments> sourceMethod16_throw(){
        return Stream.of(
                Arguments.arguments(-3)
        );
    }

    // Method 17
    // Test result is correct
    @ParameterizedTest(name = "Check if triangle {0},{1},{2} is {3}")
    @MethodSource("sourceMethod17_result")
    public void checkMethod17_result(double s1, double s2, double s3, String expected){
        Assertions.assertEquals(expected, ShapeOperations.method17(s1, s2, s3));
    }
    public static Stream<Arguments> sourceMethod17_result(){
        return Stream.of(
                Arguments.arguments(4, 4, 4, "equilateral"),
                Arguments.arguments(1, 1, 3, "isosceles"),
                Arguments.arguments(2, 4, 5, "scalene"),
                Arguments.arguments(2.4, 4.2, 2.4, "isosceles"),
                Arguments.arguments(5, 4.2, 4.2, "isosceles")

        );
    }

    // Test exception thrown when any side is negative or zero
    @ParameterizedTest(name = "Check throw if {0}<=0")
    @MethodSource("sourceMethod17_throw")
    public void checkMethod17_throw(double s1, double s2, double s3){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            ShapeOperations.method17(s1, s2, s3);
        });
    }
    public static Stream<Arguments> sourceMethod17_throw(){
        return Stream.of(
                Arguments.arguments(-3, 1, 3),
                Arguments.arguments(3, -1, 3),
                Arguments.arguments(3, 1, -3),
                Arguments.arguments(0, 1, 3),
                Arguments.arguments(3, 0, 3),
                Arguments.arguments(3, 1, 0)
        );
    }

    // Method 18
    // Test result is correct
    @ParameterizedTest(name = "Check if distance of points is {2}")
    @MethodSource("sourceMethod18_result")
    public void checkMethod18_result(Point x, Point y, double expected){
        Assertions.assertEquals(expected, ShapeOperations.method18(x, y), 0.01);
    }
    public static Stream<Arguments> sourceMethod18_result(){
        return Stream.of(
                Arguments.arguments(new Point(1,1), new Point(4, 4), 4.24),
                Arguments.arguments(new Point(8,7), new Point(6, 2), 5.39),
                Arguments.arguments(new Point(-9,-5), new Point(2, -4), 11.05),
                Arguments.arguments(new Point(0,0), new Point(2, 8), 8.25)
        );
    }
}
