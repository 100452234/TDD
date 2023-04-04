import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.stream.Stream;

public class DateAndTimeTest {
    // Method 19
    // Test result is correct
    @ParameterizedTest(name = "Check if year {0} is leap year or not")
    @MethodSource("sourceMethod19_result")
    public void checkMethod19_result(int y, boolean expected){
        Assertions.assertEquals(expected, DateAndTime.method19(y));
    }
    public static Stream<Arguments> sourceMethod19_result(){
        return Stream.of(
                Arguments.arguments(2020, true),
                Arguments.arguments(1991, false),
                Arguments.arguments(1900, false),
                Arguments.arguments(2000, true)
        );
    }

    // Test exception thrown when year is negative
    @ParameterizedTest(name = "Check throw if year {0} is negative")
    @MethodSource("sourceMethod19_throw")
    public void checkMethod19_throw(int y){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            DateAndTime.method19(y);
        });
    }
    public static Stream<Arguments> sourceMethod19_throw(){
        return Stream.of(
                Arguments.arguments(-1900)
        );
    }

    // Method 20
    // Test result is correct
    @ParameterizedTest(name = "Check if days between {0} and {1} is {2}")
    @MethodSource("sourceMethod20_result")
    public void checkMethod20_result(LocalDate d1, LocalDate d2, int expected){
        Assertions.assertEquals(expected, DateAndTime.method20(d1, d2));
    }
    public static Stream<Arguments> sourceMethod20_result(){
        return Stream.of(
                Arguments.arguments(LocalDate.of(2020, 7, 23), LocalDate.of(2023, 3, 29), 979),
                Arguments.arguments(LocalDate.of(2023, 3, 29), LocalDate.of(2020, 7, 23), 979),
                Arguments.arguments(LocalDate.of(2023, 3, 29), LocalDate.of(2023, 3, 29), 0),
                Arguments.arguments(LocalDate.of(2000, 3, 29), LocalDate.of(2023, 3, 29), 8400),
                Arguments.arguments(LocalDate.of(2023, 3, 3), LocalDate.of(2024, 12, 24), 662),
                Arguments.arguments(LocalDate.of(2020, 2, 28), LocalDate.of(2020, 3, 1), 2),
                Arguments.arguments(LocalDate.of(2021, 2, 28), LocalDate.of(2021, 3, 1), 1),
                Arguments.arguments(LocalDate.of(2020, 12, 31), LocalDate.of(2021, 1, 1), 1)
        );
    }

    // Method 21
    // Test result is correct
    @ParameterizedTest(name = "Check if date {0} falls on weekend")
    @MethodSource("sourceMethod21_result")
    public void checkMethod21_result(LocalDate d, boolean expected){
        Assertions.assertEquals(expected, DateAndTime.method21(d));
    }
    public static Stream<Arguments> sourceMethod21_result(){
        return Stream.of(
                Arguments.arguments(LocalDate.of(2023, 4, 3), false),
                Arguments.arguments(LocalDate.of(2023, 4, 4), false),
                Arguments.arguments(LocalDate.of(2023, 4, 5), false),
                Arguments.arguments(LocalDate.of(2023, 4, 6), false),
                Arguments.arguments(LocalDate.of(2023, 4, 7), false),
                Arguments.arguments(LocalDate.of(2023, 4, 8), true),
                Arguments.arguments(LocalDate.of(2023, 4, 9), true)
        );
    }

    // Method 22
    // Test result is correct
    @ParameterizedTest(name = "Check if date {0} is {1}")
    @MethodSource("sourceMethod22_result")
    public void checkMethod22_result(LocalDate d, String expected){
        Assertions.assertEquals(expected, DateAndTime.method22(d));
    }
    public static Stream<Arguments> sourceMethod22_result(){
        return Stream.of(
                Arguments.arguments(LocalDate.of(2023, 4, 3), "Monday"),
                Arguments.arguments(LocalDate.of(2023, 4, 4), "Tuesday"),
                Arguments.arguments(LocalDate.of(2023, 4, 5), "Wednesday"),
                Arguments.arguments(LocalDate.of(2023, 4, 6), "Thursday"),
                Arguments.arguments(LocalDate.of(2023, 4, 7), "Friday"),
                Arguments.arguments(LocalDate.of(2023, 4, 8), "Saturday"),
                Arguments.arguments(LocalDate.of(2023, 4, 9), "Sunday")
        );
    }
}
