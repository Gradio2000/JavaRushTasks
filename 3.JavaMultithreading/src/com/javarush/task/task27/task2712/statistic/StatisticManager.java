package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.*;

public class StatisticManager {
    private static StatisticManager statisticManager;
    private StatisticStorage statisticStorage = new StatisticStorage();
    Set<Cook> cooks = new HashSet<>();

    private StatisticManager() {
    }

    public static StatisticManager getInstance(){
        if (statisticManager == null){
            statisticManager = new StatisticManager();
        }
        return statisticManager;
    }

    public void register(EventDataRow data){
        statisticStorage.put(data);
    }

    public void register(Cook cook){
        cooks.add(cook);
    }

    public Map<Date, Long> getProfit(){
        Map<Date, Long> profitByDateMap = new TreeMap<>();
        //получим полное хранилище событий
        Map<EventType, List<EventDataRow>> storage = statisticStorage.getStorage();

        //достанем из хранилища событий список событий нужного нам типа
        List<EventDataRow> videosList = new ArrayList<>();
        for (EventType type : storage.keySet()){
            if (type.equals(EventType.SELECTED_VIDEOS)){
                videosList = storage.get(type);
            }
        }

        //теперь попработаем с этим списком событий:
        for (EventDataRow eventType : videosList){
            VideoSelectedEventDataRow videoSelectedEventDataRow = (VideoSelectedEventDataRow) eventType;
            Date eventDate = videoSelectedEventDataRow.getDate();
            long eventAmount = videoSelectedEventDataRow.getAmount();

            if (profitByDateMap.containsKey(eventDate)){
                long tempAmont = profitByDateMap.get(eventDate) + eventAmount;
                profitByDateMap.put(eventDate, tempAmont);
            }
            else {
                profitByDateMap.put(eventDate, eventAmount);
            }
        }

        return profitByDateMap;
    }




    private class StatisticStorage {
        private Map<EventType, List<EventDataRow>> storage = new HashMap<>();

        public StatisticStorage() {
            for (EventType type : EventType.values()){
                storage.put(type, new ArrayList<>());
            }
        }

        private void put(EventDataRow data){
            List<EventDataRow> list = storage.get(data.getType());
            list.add(data);
            storage.put(data.getType(), list);
        }

        public Map<EventType, List<EventDataRow>> getStorage() {
            return storage;
        }
    }

}
