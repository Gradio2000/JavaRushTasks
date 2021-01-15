package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

public class StatisticAdvertisementManager {
    private static StatisticAdvertisementManager instance = new StatisticAdvertisementManager();
    private AdvertisementStorage advertisementStorage = AdvertisementStorage.getInstance();
    private StatisticAdvertisementManager() {
    }

    public static StatisticAdvertisementManager getInstance() {
        return instance;
    }

    public List<Advertisement> getActiveAd(){
        List<Advertisement> activeList = new ArrayList<>();
        List<Advertisement> list = advertisementStorage.list();
        for (Advertisement advertisement : list){
            if (advertisement.getHits() > 0){
                activeList.add(advertisement);
            }
        }
        return activeList;
    }

    public List<Advertisement> getPassiveAd(){
        List<Advertisement> passiveList = new ArrayList<>();
        for (Advertisement advertisement : advertisementStorage.list()){
            if (advertisement.getHits() == 0){
                passiveList.add(advertisement);
            }
        }
        return passiveList;
    }
}
