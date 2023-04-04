import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class DateAndTime {
    // Method 19: create a method that checks if a given year is a leap year and returns a boolean
    public static boolean method19(int year){
        if(year<0) {
            throw new IllegalArgumentException("Year is negative");
        }
        if (year % 4 == 0){
            if (year % 100 != 0){
                return true;
            } else return (year % 400 == 0);
        }
        return false;
    }

    // Method 20: create a method that computes the number of days between two dates and returns the result
    public static int method20(LocalDate d1, LocalDate d2){
        return Math.abs((int) d1.until(d2, DAYS) );
    }

    // Method 21: create a method that checks if given date falls on weekend and returns a boolean
    public static boolean method21(LocalDate d){
        String day_week = d.getDayOfWeek().toString();
        day_week = day_week.toLowerCase();
        return day_week.equals("saturday") || day_week.equals("sunday");
    }

    // Method 22: create a method that returns the day of the week for a given date
    public static String method22(LocalDate d){
        String day_week = d.getDayOfWeek().toString();
        return day_week.charAt(0) + day_week.substring(1).toLowerCase();
    }
}
