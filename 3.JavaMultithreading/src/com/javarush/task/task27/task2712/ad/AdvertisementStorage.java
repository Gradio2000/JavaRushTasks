package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

public class AdvertisementStorage {
    private static AdvertisementStorage instance;
    private final List<Advertisement> videos = new ArrayList<>();

    AdvertisementStorage() {
        Object someContent = new Object();
        list().add(new Advertisement(someContent, "First Video", 5000, 100, 3 * 60));// 3 min)
        list().add(new Advertisement(someContent, "Second Video", 100, 10, 15 * 60)); //15 min)
        list().add(new Advertisement(someContent, "Third Video", 400, 2, 10 * 60)); //10 min)
        list().add(new Advertisement(someContent, "Aaaa Video", 400, 2, 20 * 60)); //20 min)
        list().add(new Advertisement(someContent, "ББББ", 400, 2, 20 * 60)); //20 min)
    }

    public static AdvertisementStorage getInstance(){
        if (instance == null){
            instance = new AdvertisementStorage();
        }
        return instance;
    }

    public List<Advertisement> list(){
        return videos;
    }

    public void add(Advertisement advertisement){
        videos.add(advertisement);
    }
}
