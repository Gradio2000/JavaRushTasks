package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.text.SimpleDateFormat;
import java.util.*;

public class DirectorTablet {

    public void printAdvertisementProfit() {
        StatisticManager statisticManager = StatisticManager.getInstance();
        Map<String, Long> profitMap = statisticManager.getProfitMap();
        ArrayList<String> list = new ArrayList(profitMap.keySet());
        Collections.sort(list);

        for (String key : list) {
            double amount = 1.0 * profitMap.get(key) / 100;
            System.out.println(key + " - " + String.format(Locale.ENGLISH, "%.2f", amount));
        }
    }

    public void printCookWorkloading() {
        Map<Date, Map<String, Integer>> map = StatisticManager.getInstance().getCookWorkTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-YYYY", Locale.ENGLISH);
        for (Date dateKey : map.keySet()) {
            String date = simpleDateFormat.format(dateKey);
            ConsoleHelper.writeMessage(date);
            Map<String, Integer> cookMap = map.get(dateKey);
            for (String name : cookMap.keySet()) {
                ConsoleHelper.writeMessage(name + " - " + cookMap.get(name) + " min");
            }

            System.out.println();
        }
    }


    public void printActiveVideoSet() {
        StatisticAdvertisementManager statisticAdvertisementManager = StatisticAdvertisementManager.getInstance();
        Set<Advertisement> activeVedeos = statisticAdvertisementManager.getActiveVideos();
        for (Advertisement advertisement : activeVedeos){
            ConsoleHelper.writeMessage(advertisement.getName() + " - " + advertisement.getHits());
        }
    }

    public void printArchivedVideoSet() {
        StatisticAdvertisementManager statisticAdvertisementManager = StatisticAdvertisementManager.getInstance();
        Set<Advertisement> passiveVedeos = statisticAdvertisementManager.getPassiveVideos();
        for (Advertisement advertisement : passiveVedeos){
            ConsoleHelper.writeMessage(advertisement.getName());
        }
    }
}
