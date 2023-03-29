import java.time.LocalDate;
import java.time.Period;

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
        if (d1.isEqual(d2)){
            return 0;
        }

        int year = Math.abs(Period.between(d1, d2).getYears());
        int month = Math.abs(Period.between(d1, d2).getMonths());
        int day = Math.abs(Period.between(d1, d2).getDays());
        System.out.println(year);
        System.out.println(month);
        System.out.println(day);
        System.out.println("period "+Period.between(d1, d2));

        int start, end;
        if (d1.isBefore(d2)){
            start = d1.getYear();
            end = d2.getYear();
        }else{
            start = d2.getYear();
            end = d1.getYear();
        }

        // Check how many leap years are between dates
        int countLeap = 0;
        for(int i = start; i < end; i++){
            if(method19(i)){
                countLeap += 1;
            }
        }
        System.out.println(countLeap*366);
        System.out.println((year-countLeap)*365);
        System.out.println((int)Math.floor(month*30.4167)-1);
        System.out.println(day);

        return countLeap*366 + (year-countLeap)*365 + (int)Math.floor(month*30.4167)-1 + day;
    }
}
