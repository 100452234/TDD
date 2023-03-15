import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class StringManipulatorTest {

    // Method 7
    // Test result is correct
    @ParameterizedTest(name = "Check if reverse of {0} is {1}")
    @MethodSource("sourceMethod7_result")
    public void checkMethod7_result(String s, String expected){
        Assertions.assertEquals(expected, StringManipulator.method7(s));
    }
    public static Stream<Arguments> sourceMethod7_result(){
        return Stream.of(
                Arguments.arguments("hello", "olleh"),
                Arguments.arguments("SofTwaRe", "eRawTfoS"),
                Arguments.arguments("", "")
        );
    }

    // Method 8
    // Test result is correct
    @ParameterizedTest(name = "Check number of vowels of {0} is {1}")
    @MethodSource("sourceMethod8_result")
    public void checkMethod8_result(String s, int expected){
        Assertions.assertEquals(expected, StringManipulator.method8(s));
    }
    public static Stream<Arguments> sourceMethod8_result(){
        return Stream.of(
                Arguments.arguments("hello", 2),
                Arguments.arguments("SofTwARe", 3),
                Arguments.arguments("", 0),
                Arguments.arguments("AaAaAa", 6),
                Arguments.arguments("CRY EVERYDAY", 3),
                Arguments.arguments("dcfvgb gbhnjby", 0)
        );
    }

    // Method 9
    // Test result is correct
    @ParameterizedTest(name = "Check number of words of {0} is {1}")
    @MethodSource("sourceMethod9_result")
    public void checkMethod9_result(String s, int expected){
        Assertions.assertEquals(expected, StringManipulator.method9(s));
    }
    public static Stream<Arguments> sourceMethod9_result(){
        return Stream.of(
                Arguments.arguments("hello my name is Pepe", 5),
                Arguments.arguments("I study SofTwARe", 3),
                Arguments.arguments("", 0),
                Arguments.arguments("     ", 0),
                Arguments.arguments("AaAaAa", 1),
                Arguments.arguments("I WILL EAT CHOCOLATE EVERY DAY IN THE MORNING BEFORE CLASS", 11),
                Arguments.arguments("usydficb     asidbixu aishudziu aosihdnds asb siabc .", 7)
        );
    }

    // Method 10
    // Test result is correct
    @ParameterizedTest(name = "Check {0} without spaces is {1}")
    @MethodSource("sourceMethod10_result")
    public void checkMethod10_result(String s, String expected){
        Assertions.assertEquals(expected, StringManipulator.method10(s));
    }
    public static Stream<Arguments> sourceMethod10_result(){
        return Stream.of(
                Arguments.arguments("hello my name is Pepe", "hellomynameisPepe"),
                Arguments.arguments("I study SofTwARe", "IstudySofTwARe"),
                Arguments.arguments("", ""),
                Arguments.arguments("    ", ""),
                Arguments.arguments("AaAaAa", "AaAaAa")
        );
    }

    // Method 11
    // Test result is correct
    @ParameterizedTest(name = "Check word {0} is or not palindrome")
    @MethodSource("sourceMethod11_result")
    public void checkMethod11_result(String s, boolean expected){
        Assertions.assertEquals(expected, StringManipulator.method11(s));
    }
    public static Stream<Arguments> sourceMethod11_result(){
        return Stream.of(
                Arguments.arguments("Roma amor", true),
                Arguments.arguments("", true),
                Arguments.arguments("AaAaAaA", true),
                Arguments.arguments("leave", false),
                Arguments.arguments("YamamaY", true),
                Arguments.arguments("somee mos", true),
                Arguments.arguments("some nose", false)
        );
    }
}
