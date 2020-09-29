package com.javarush.task.task40.task4007;

/*
Работа с датами
*/

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Solution {
    public static void main(String[] args) {
        printDate("1.1.2020 00:56:45");
        System.out.println();
        printDate("1.1.2020");
        System.out.println();
        printDate("17:33:40");
    }

    public static void printDate(String date) {
        //напишите тут ваш код
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("hh:mm:ss");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");

        Date date1;
        if (date.length() > 10) {
            try {
                date1 = simpleDateFormat3.parse(date);
                calendar.setTime(date1);
                System.out.println("День: " + calendar.get(Calendar.DATE));
                System.out.println("День недели: " + (calendar.get(Calendar.DAY_OF_WEEK) - 1 == 0 ? 7 : (calendar.get(Calendar.DAY_OF_WEEK) - 1)));
                System.out.println("День месяца: " + calendar.get(Calendar.DAY_OF_MONTH));
                System.out.println("День года: " + calendar.get(Calendar.DAY_OF_YEAR));
                System.out.println("Неделя месяца: " + calendar.get(Calendar.WEEK_OF_MONTH));
                System.out.println("Неделя года: " + calendar.get(Calendar.WEEK_OF_YEAR));
                System.out.println("Месяц: " + (calendar.get(Calendar.MONTH) + 1));
                System.out.println("Год: " + calendar.get(Calendar.YEAR));
                System.out.println("AM или PM: " + (calendar.get(Calendar.AM_PM) == 0 ? "AM" : "PM"));
                System.out.println("Часы: " + calendar.get(Calendar.HOUR));
                System.out.println("Часы дня: " + calendar.get(Calendar.HOUR_OF_DAY));
                System.out.println("Минуты: " + calendar.get(Calendar.MINUTE));
                System.out.println("Секунды: " + calendar.get(Calendar.SECOND));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        else {
            try {
                date1 = simpleDateFormat2.parse(date);
                calendar.setTime(date1);
                System.out.println("День: " + calendar.get(Calendar.DATE));
                System.out.println("День недели: " + (calendar.get(Calendar.DAY_OF_WEEK) - 1 == 0 ? 7 : (calendar.get(Calendar.DAY_OF_WEEK) - 1)));
                System.out.println("День месяца: " + calendar.get(Calendar.DAY_OF_MONTH));
                System.out.println("День года: " + calendar.get(Calendar.DAY_OF_YEAR));
                System.out.println("Неделя месяца: " + calendar.get(Calendar.WEEK_OF_MONTH));
                System.out.println("Неделя года: " + calendar.get(Calendar.WEEK_OF_YEAR));
                System.out.println("Месяц: " + (calendar.get(Calendar.MONTH) + 1));
                System.out.println("Год: " + calendar.get(Calendar.YEAR));
            } catch (ParseException e) {
                try {
                    date1 = simpleDateFormat1.parse(date);
                    calendar.setTime(date1);
                    System.out.println("AM или PM: " + (calendar.get(Calendar.AM_PM) == 0 ? "AM" : "PM"));
                    System.out.println("Часы: " + calendar.get(Calendar.HOUR));
                    System.out.println("Часы дня: " + calendar.get(Calendar.HOUR_OF_DAY));
                    System.out.println("Минуты: " + calendar.get(Calendar.MINUTE));
                    System.out.println("Секунды: " + calendar.get(Calendar.SECOND));
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }
            }
        }
    }
}
