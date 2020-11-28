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
        Map<Date, Map<String, Integer>> map = StatisticManager.getInstance().getCookWorkTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-YYYY", Locale.ENGLISH);
        for (Date dateKey : map.keySet()){
            String date = simpleDateFormat.format(dateKey);
            ConsoleHelper.writeMessage(date);
            Map<String, Integer> cookMap = map.get(dateKey);
            for (String name : cookMap.keySet()){
                ConsoleHelper.writeMessage(name + " - " + cookMap.get(name) + " min");
            }
        }
    }

    public void printActiveVideoSet(){

    }

    public void printArchivedVideoSet(){

    }

}
