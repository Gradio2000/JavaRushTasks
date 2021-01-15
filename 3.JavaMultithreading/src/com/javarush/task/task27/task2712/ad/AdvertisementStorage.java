package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

public class AdvertisementStorage {
    private static AdvertisementStorage instance;
    private final List<Advertisement> videos = new ArrayList<>();
    private Object someContent = new Object();

    private AdvertisementStorage() {
       videos.add(new Advertisement(someContent, "First Video", 5000, 100, 3 * 60));   // 3 min, 50
       videos.add(new Advertisement(someContent, "Second Video", 100, 10, 15 * 60));   //15 min, 10
       videos.add(new Advertisement(someContent, "Third Video", 400, 2, 10 * 60)) ;    //10 min, 200
       videos.add(new Advertisement(someContent, "Fourth Video", 400, 2, 50 * 60)) ;    //50 min, 200
       videos.add(new Advertisement(someContent, "AAA Video", 500, 2, 50 * 60)) ;    //50 min, 200
    }

    public static AdvertisementStorage getInstance() {
        if (instance == null){
            instance =  new AdvertisementStorage();
        }
        return instance;
    }

    public List<Advertisement> list(){
        return this.videos;
    }

    public void add(Advertisement advertisement){
        videos.add(advertisement);
    }
}
