package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.text.SimpleDateFormat;
import java.util.*;

public class StatisticManager {
    private static StatisticManager instance;
    private StatisticStorage statisticStorage = new StatisticStorage();
    Set<Cook> cooks = new HashSet<>();

    private StatisticManager() {
    }

    public static StatisticManager getInstance() {
        if (instance == null){
            instance = new StatisticManager();
        }
        return instance;
    }

    public void register(EventDataRow data){
        statisticStorage.put(data);
    }

    public void register(Cook cook){
        cooks.add(cook);
    }

    public Map<String, Double> totalProfit(){
        Map<String, Double> map = new TreeMap<>(Collections.reverseOrder());
        List<EventDataRow> eventDataRowList = statisticStorage.get(EventType.SELECTED_VIDEOS);
        for (EventDataRow eventDataRow : eventDataRowList){
            VideoSelectedEventDataRow videoEvent = (VideoSelectedEventDataRow) eventDataRow;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            String date = simpleDateFormat.format(videoEvent.getDate());
            double amount = videoEvent.getAmount() / 100.0;
            map.merge(date, amount, (a, b) -> a + b);
        }
        return map;
    }

    public Map<String, Map<String, Integer>> cookWork(){
        Map<String, Map<String, Integer>> resultMap = new TreeMap<>(Collections.reverseOrder());
        Map<String, Integer> cookMap = new TreeMap<>();
        List<EventDataRow> eventDataRowList = statisticStorage.get(EventType.COOKED_ORDER);
        for (EventDataRow eventDataRow : eventDataRowList){
            CookedOrderEventDataRow cookEvent = (CookedOrderEventDataRow) eventDataRow;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            String date = simpleDateFormat.format(cookEvent.getDate());

            String cookName = cookEvent.getCookName();
            int time = cookEvent.getTime();
            if (resultMap.containsKey(date)) {
                cookMap = resultMap.get(date);
            }
                cookMap.merge(cookName, time, (a, b) -> a + b);
                resultMap.put(date, cookMap);
        }

//        Map<String, Map<String, Integer>> testMap = new TreeMap<>(Collections.reverseOrder());
//        Map<String, Integer> cookMapTest = new TreeMap<>();
//        Map<String, Integer> cookMapTest2 = new TreeMap<>();
//        cookMapTest.put("Petrov", 100);
//        cookMapTest.put("Ivanov", 120);
//        cookMapTest.put("Alex", 701);
//        cookMapTest.put("Pupa", 0);
//        cookMapTest2.put("Aaaa", 33);
//        cookMapTest2.put("Qqqq", 44);
//        cookMapTest2.put("Ffff", 55);
//        cookMapTest2.put("Bbbb", 0);
//        testMap.put("22-Nov-2020", cookMapTest);
//        testMap.put("23-Nov-2020", cookMapTest2);

        return resultMap;
    }

    private class StatisticStorage{
        private Map<EventType, List<EventDataRow>> storage = new HashMap<>();

        public StatisticStorage() {
            for (EventType eventType : EventType.values()){
                storage.put(eventType, new ArrayList<>());
            }
        }

        private void put(EventDataRow data){
            List<EventDataRow> list;
            if (storage.get(data.getType()) == null){
                list = new ArrayList<>();
            }
            else {
                list = storage.get(data.getType());
            }

            list.add(data);
            storage.put(data.getType(), list);
        }

        private List<EventDataRow> get(EventType eventType){
            return storage.get(eventType);
        }
    }
}
