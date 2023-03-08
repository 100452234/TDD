import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CalculatorTest {
    // Method 1
    @ParameterizedTest(name = "Check if {0}+{1}={2}")
    @MethodSource("sourceMethod1")
    public void checkMethod1(double n1, double n2, double expected){
        Assertions.assertEquals(expected, Calculator.method1(n1, n2), 0.01);
    }
    public static Stream<Arguments> sourceMethod1(){
        return Stream.of(
                Arguments.arguments(-10, 31, 21),
                Arguments.arguments(-3, -7, -10),
                Arguments.arguments(1.2, -1.1, 0.1)
        );
    }


    // Method 2
    // Test arguments are positive
    @ParameterizedTest(name = "Check if {0} and {1} >= 0")
    @MethodSource("sourceMethod2_throw")
    public void checkMethod2_throw(double n1, double n2){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Calculator.method2(n1, n2);
        });
    }
    public static Stream<Arguments> sourceMethod2_throw(){
        return Stream.of(
                Arguments.arguments(-3, -7),
                Arguments.arguments(1.2d, -1.1d)
        );
    }

    // Test result is correct
    @ParameterizedTest(name = "Check if {0}+{1}={2}")
    @MethodSource("sourceMethod2_result")
    public void checkMethod2_result(double n1, double n2, double expected){
        Assertions.assertEquals(expected, Calculator.method2(n1, n2), 0.01);
    }
    public static Stream<Arguments> sourceMethod2_result(){
        return Stream.of(
                Arguments.arguments(3, 7, 10),
                Arguments.arguments(1.2, 1.1, 2.3)
        );
    }

    // Method 3
    // Test exception thrown when denominator is zero
    @ParameterizedTest(name = "Check throw if {1}=0")
    @MethodSource("sourceMethod3_throw")
    public void checkMethod3_throw(double n1, double n2){
        Assertions.assertThrows(ArithmeticException.class, () -> {
            Calculator.method3(n1, n2);
        });
    }
    public static Stream<Arguments> sourceMethod3_throw(){
        return Stream.of(
                Arguments.arguments(-3, 0),
                Arguments.arguments(1.2d, 0)
        );
    }

    // Test result is correct
    @ParameterizedTest(name = "Check if {0}/{1}={2}")
    @MethodSource("sourceMethod3_result")
    public void checkMethod3_result(double n1, double n2, double expected){
        Assertions.assertEquals(expected, Calculator.method3(n1, n2), 0.01);
    }
    public static Stream<Arguments> sourceMethod3_result(){
        return Stream.of(
                Arguments.arguments(4, 2, 2),
                Arguments.arguments(31, 11, 2.82),
                Arguments.arguments(10.2, 2, 5.1),
                Arguments.arguments(-46, 2, -23),
                Arguments.arguments(-80, -80, 1)
        );
    }

    // Method 4
    // Test argument is positive
    @ParameterizedTest(name = "Check throw if {0}<0")
    @MethodSource("sourceMethod4_throw")
    public void checkMethod4_throw(double n1){
        Assertions.assertThrows(ArithmeticException.class, () -> {
            Calculator.method4(n1);
        });
    }
    public static Stream<Arguments> sourceMethod4_throw(){
        return Stream.of(
                Arguments.arguments(-3),
                Arguments.arguments(-1.2)
        );
    }

    // Test result is correct
    @ParameterizedTest(name = "Check if sqrt({0})={1}")
    @MethodSource("sourceMethod4_result")
    public void checkMethod4_result(double n1, double expected){
        Assertions.assertEquals(expected, Calculator.method4(n1), 0.01);
    }
    public static Stream<Arguments> sourceMethod4_result(){
        return Stream.of(
                Arguments.arguments(37, 6.08),
                Arguments.arguments(83, 9.11),
                Arguments.arguments(625, 25),
                Arguments.arguments(0, 0)
        );
    }

    // Method 5
    // Test result is correct
    @ParameterizedTest(name = "Check if sqrt({0})={1}")
    @MethodSource("sourceMethod5")
    public void checkMethod5(double n1, double expected){
        Assertions.assertEquals(expected, Calculator.method5(n1), 0.01);
    }
    public static Stream<Arguments> sourceMethod5(){
        return Stream.of(
                Arguments.arguments(37, 6.08),
                Arguments.arguments(83, 9.11),
                Arguments.arguments(625, 25),
                Arguments.arguments(0, 0)
        );
    }

}
