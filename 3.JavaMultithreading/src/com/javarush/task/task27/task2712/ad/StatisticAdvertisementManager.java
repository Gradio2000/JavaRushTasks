package com.javarush.task.task27.task2712.ad;

import java.util.Set;
import java.util.TreeSet;

public class StatisticAdvertisementManager {
    private static StatisticAdvertisementManager statisticAdvertisementManager;
    AdvertisementStorage advertisementStorage = AdvertisementStorage.getInstance();
    private StatisticAdvertisementManager() {
    }
    public static StatisticAdvertisementManager getInstance(){
        if (statisticAdvertisementManager == null){
            statisticAdvertisementManager = new StatisticAdvertisementManager();
        }
        return statisticAdvertisementManager;
    }

    public Set<Advertisement> getActiveVideos(){
        Set<Advertisement> activeVideos = new TreeSet<>();
        for (Advertisement advertisement : advertisementStorage.list()){
            if (advertisement.getHits() > 0){
                activeVideos.add(advertisement);
            }
        }
        return activeVideos;
    }

    public Set<Advertisement> getPassiveVideos(){
        Set<Advertisement> passiveVideos = new TreeSet<>();
        for (Advertisement advertisement : advertisementStorage.list()){
            if (advertisement.getHits() == 0){
                passiveVideos.add(advertisement);
            }
        }
        return passiveVideos;
    }


}

