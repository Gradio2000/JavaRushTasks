package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.text.SimpleDateFormat;
import java.util.*;

public class StatisticManager {
    private static StatisticManager ourInstance = new StatisticManager();

    public static StatisticManager getInstance() {
        return ourInstance;
    }

    private StatisticStorage statisticStorage = new StatisticStorage();
    private Set<Cook> cooks = new HashSet<>();

    private StatisticManager() {
    }

    private class StatisticStorage {
        private Map<EventType, List<EventDataRow>> storage = new HashMap<>();

        private StatisticStorage() {
            for (EventType type : EventType.values()) {
                this.storage.put(type, new ArrayList<EventDataRow>());
            }
        }

        private void put(EventDataRow data) {
            EventType type = data.getType();
            if (!this.storage.containsKey(type))
                throw new UnsupportedOperationException();

            this.storage.get(type).add(data);
        }

        private List<EventDataRow> get(EventType type) {
            if (!this.storage.containsKey(type))
                throw new UnsupportedOperationException();

            return this.storage.get(type);
        }
        public Map<EventType, List<EventDataRow>> getStorage() {
            return storage;
        }
    }

    public void register(EventDataRow data) {
        this.statisticStorage.put(data);
    }

    public void register(Cook cook) {
        this.cooks.add(cook);
    }

    public Map<String, Long> getProfitMap() {
        Map<String, Long> res = new HashMap();
        List<EventDataRow> rows = statisticStorage.get(EventType.SELECTED_VIDEOS);
        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        long total = 0l;
        for (EventDataRow row : rows) {
            VideoSelectedEventDataRow dataRow = (VideoSelectedEventDataRow) row;
            String date = format.format(dataRow.getDate());
            if (!res.containsKey(date)) {
                res.put(date, 0l);
            }
            total += dataRow.getAmount();
            res.put(date, res.get(date) + dataRow.getAmount());
        }

        res.put("Total", total);

        return res;
    }

    public Map<Date, Map<String, Integer>> getCookWorkTime(){
        Map<Date, Map<String, Integer>> cookWorkTimeMap = new TreeMap<>(Comparator.reverseOrder());
        Map<String, Integer> cookTimeMap = new TreeMap<>();

        //получим полное хранилище событий
        Map<EventType, List<EventDataRow>> storage = statisticStorage.getStorage();

        //достанем из хранилища событий список событий нужного нам типа
        List<EventDataRow> coocsList = new ArrayList<>();
        for (EventType type : storage.keySet()){
            if (type.equals(EventType.COOKED_ORDER)){
                coocsList = storage.get(type);
            }
        }

        //теперь попработаем с этим списком событий:
        for (EventDataRow eventDataRow : coocsList){
            //извлекаем необходимые данные
            CookedOrderEventDataRow cookedOrderEventDataRow = (CookedOrderEventDataRow) eventDataRow;
            Date date = cookedOrderEventDataRow.getDate();
            String name = cookedOrderEventDataRow.getCookName();
            int time = cookedOrderEventDataRow.getTime();

            //найдем в результатирующей карте запись (карту) с датой события
            if (cookWorkTimeMap.containsKey(date)) { //если она там есть...
                cookTimeMap = cookWorkTimeMap.get(date);
                //найдем нужного повара
                if (cookTimeMap.containsKey(name)){ //если он там есть...
                    int totalTime = cookTimeMap.get(name) + time;
                    cookTimeMap.put(name, totalTime);
                }
                else { // если его там нет...
                    cookTimeMap.put(name, time);
                }
                cookWorkTimeMap.put(date, cookTimeMap);
            }
            else { //если ее там нет
                cookTimeMap.put(name, time);
                cookWorkTimeMap.put(date, cookTimeMap);
            }
        }
        return cookWorkTimeMap;
    }
}
