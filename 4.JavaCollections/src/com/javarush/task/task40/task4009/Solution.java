package com.javarush.task.task40.task4009;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoField;
import java.util.Locale;

/* 
Buon Compleanno!
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getWeekdayOfBirthday("30.05.1984", "2015"));
    }

    public static String getWeekdayOfBirthday(String birthday, String year) {
        //напишите тут ваш код
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.y");
        LocalDate localDate = LocalDate.parse(birthday, formatter);
        Year year1 = Year.parse(year);
        localDate = localDate.minusYears(localDate.getYear()).plusYears(year1.get(ChronoField.YEAR));
        return localDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ITALIAN);
    }
}
