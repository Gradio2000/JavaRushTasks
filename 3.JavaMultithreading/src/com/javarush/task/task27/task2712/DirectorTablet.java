package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.text.SimpleDateFormat;
import java.util.*;

public class DirectorTablet {

    public void printAdvertisementProfit() {
        Map<Date, Long> profitMap = StatisticManager.getInstance().getProfit();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        List<Date> dateList = new ArrayList<>(profitMap.keySet());
        Collections.reverse(dateList);
        double totalAmount = 0;
        for (Date date : dateList){
            double profit = profitMap.get(date);
            ConsoleHelper.writeMessage(simpleDateFormat.format(date) + " - " + String.format("%.2f", profit).replaceAll(",", "."));
            totalAmount += profitMap.get(date);
        }
        ConsoleHelper.writeMessage("Total - " + String.format("%.2f", totalAmount).replaceAll(",", "."));
    }

    public void printCookWorkloading(){

    }

    public void printActiveVideoSet(){

    }

    public void printArchivedVideoSet(){

    }

}
