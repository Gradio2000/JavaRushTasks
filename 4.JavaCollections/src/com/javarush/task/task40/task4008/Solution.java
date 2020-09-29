package com.javarush.task.task40.task4008;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class Solution {
    public static void main(String[] args) {
        printDate("17.9.2015 08:35:24");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("04:33:40");
    }

    public static void printDate(String date) {
        //напишите тут ваш код
        if (date.length() <= 10 && date.contains(".")){
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d.M.yyyy");
            LocalDate localDate = LocalDate.parse(date, dateTimeFormatter);
            System.out.println("День: " + localDate.getDayOfMonth());
            System.out.println("День недели: " + localDate.get(ChronoField.DAY_OF_WEEK));
            System.out.println("День месяца: " + localDate.get(ChronoField.DAY_OF_MONTH));
            System.out.println("День года: " + localDate.get(ChronoField.DAY_OF_YEAR));
            System.out.println("Неделя месяца: " + localDate.get(WeekFields.of(Locale.getDefault()).weekOfMonth()));
            System.out.println("Неделя года: " + localDate.get(WeekFields.of(Locale.getDefault()).weekOfYear()));
            System.out.println("Месяц: " + localDate.getMonthValue());
            System.out.println("Год: " + localDate.getYear());
        }
        else if (date.length() <= 10 && date.contains(":")){
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("H:m:s");
            LocalTime localDate = LocalTime.parse(date, dateTimeFormatter);
            System.out.println("AM или PM: " + ((localDate.get(ChronoField.AMPM_OF_DAY) == 0 ? "AM" : "PM")));
            System.out.println("Часы: " + localDate.get(ChronoField.CLOCK_HOUR_OF_AMPM));
            System.out.println("Часы дня: " + localDate.get(ChronoField.CLOCK_HOUR_OF_DAY));
            System.out.println("Минуты: " + localDate.get(ChronoField.MINUTE_OF_HOUR));
            System.out.println("Секунды: " + localDate.get(ChronoField.SECOND_OF_MINUTE));
        }
        else {
            String[] mass = date.split(" ");
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d.M.yyyy");
            LocalDate localDate = LocalDate.parse(mass[0], dateTimeFormatter);
            DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("H:m:s");
            LocalTime localDate1 = LocalTime.parse(mass[1], dateTimeFormatter1);
            System.out.println("День: " + localDate.getDayOfMonth());
            System.out.println("День недели: " + localDate.get(ChronoField.DAY_OF_WEEK));
            System.out.println("День месяца: " + localDate.get(ChronoField.DAY_OF_MONTH));
            System.out.println("День года: " + localDate.get(ChronoField.DAY_OF_YEAR));
            System.out.println("Неделя месяца: " + localDate.get(WeekFields.of(Locale.getDefault()).weekOfMonth()));
            System.out.println("Неделя года: " + localDate.get(WeekFields.of(Locale.getDefault()).weekOfYear()));
            System.out.println("Месяц: " + localDate.getMonthValue());
            System.out.println("Год: " + localDate.getYear());
            System.out.println("AM или PM: " + ((localDate1.get(ChronoField.AMPM_OF_DAY) == 0 ? "AM" : "PM")));
            System.out.println("Часы: " + localDate1.get(ChronoField.CLOCK_HOUR_OF_AMPM));
            System.out.println("Часы дня: " + localDate1.get(ChronoField.CLOCK_HOUR_OF_DAY));
            System.out.println("Минуты: " + localDate1.get(ChronoField.MINUTE_OF_HOUR));
            System.out.println("Секунды: " + localDate1.get(ChronoField.SECOND_OF_MINUTE));
        }
    }
}
