import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
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
    @ParameterizedTest(name = "Average of list {0} = {1}")
    @MethodSource("sourceMethod5_result")
    public void checkMethod5_result(List<Float> l, float expected){
        Assertions.assertEquals(expected, Calculator.method5(l), 0.01);
    }
    public static Stream<Arguments> sourceMethod5_result(){
        return Stream.of(
                Arguments.arguments(Arrays.asList(23.1f, 34.2f, 45.3f), 34.2f),
                Arguments.arguments(Arrays.asList(-13.4f, -17.8f, -87.9f, -4.2f), -30.83f),
                Arguments.arguments(Arrays.asList(65.3f, -27.3f), 19f),
                Arguments.arguments(List.of(3.4f), 3.4f),
                Arguments.arguments(List.of(0.001f, 0.002f), 0.00f)
        );
    }

    // Test list argument is not empty
    @ParameterizedTest(name = "Check throw if list {0} is empty")
    @MethodSource("sourceMethod5_throw")
    public void checkMethod5_throw(List<Float> l){
        Assertions.assertThrows(ArithmeticException.class, () -> {
            Calculator.method5(l);
        });
    }
    public static Stream<Arguments> sourceMethod5_throw(){
        return Stream.of(
                Arguments.arguments(List.of())
        );
    }

    // Method 6
    // Test result is correct
    @ParameterizedTest(name = "Integer {0} to binary")
    @MethodSource("sourceMethod6_result")
    public void checkMethod6_result(int n){
        Assertions.assertEquals(n, Integer.parseUnsignedInt(Calculator.method6(n), 2));
    }
    public static Stream<Arguments> sourceMethod6_result(){
        return Stream.of(
                Arguments.arguments(5),
                Arguments.arguments(31),
                Arguments.arguments(-5),
                Arguments.arguments(300000000),
                Arguments.arguments(0)
        );
    }

}
