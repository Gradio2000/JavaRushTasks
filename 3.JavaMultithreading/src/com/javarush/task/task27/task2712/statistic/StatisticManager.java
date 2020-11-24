package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticManager {
    private static StatisticManager statisticManager;
    private StatisticStorage statisticStorage = new StatisticStorage();
    private StatisticManager() {
    }
    public static StatisticManager getInstance(){
        if (statisticManager == null){
            statisticManager = new StatisticManager();
        }
        return statisticManager;
    }

    public void register(EventDataRow data){

    }

    private class StatisticStorage {
        private Map<EventType, List<EventDataRow>> storage = new HashMap<>();

        public StatisticStorage() {
            for (EventType type : EventType.values()){
                storage.put(type, new ArrayList<>());
            }
        }
    }

}
