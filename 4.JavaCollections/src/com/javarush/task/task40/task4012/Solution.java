package com.javarush.task.task40.task4012;

import java.time.*;
import java.time.temporal.ChronoUnit;

/* 
Полезные методы DateTime API
*/

public class Solution {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        System.out.println(isLeap(date));
        LocalDateTime time = LocalDateTime.of(2027, Month.JULY, 9, 11, 6, 22);
        System.out.println(isBefore(time));
        System.out.println(getPeriodBetween(LocalDate.of(2020,4,9), LocalDate.now()));
    }

    public static boolean isLeap(LocalDate date) {
       return date.isLeapYear();
    }

    public static boolean isBefore(LocalDateTime dateTime) {
        return dateTime.isBefore(LocalDateTime.now());
    }

    public static LocalTime addTime(LocalTime time, int n, ChronoUnit chronoUnit) {
        return time.plus(n, chronoUnit);
    }

    public static Period getPeriodBetween(LocalDate firstDate, LocalDate secondDate) {
        if (firstDate.isBefore(secondDate)){
            return Period.between(firstDate, secondDate);
        }
        else return Period.between(secondDate, firstDate);

    }
}
