package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos(){
        if (storage.list().isEmpty()){
            throw new NoVideoAvailableException();
        }

        //получим список всех доступных роликов
        List<Advertisement> fullList = storage.list();

        //отсортируем список сначала в порядке убывания ценности минуты ролика
        //потом в порядке убывания продолжительности ролика

        Collections.sort(fullList, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return (int) (o1.getAmountPerOneDisplaying() - o2.getAmountPerOneDisplaying());
            }
        }.thenComparing(new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return o1.getDuration() - o2.getDuration();
            }
        }).reversed());

        //создаем список
        List<Advertisement> result = new ArrayList<>();

        for (Advertisement advertisement : fullList){
            if (advertisement.getHits() > 0 && timeSeconds >= advertisement.getDuration()){
                result.add(advertisement);
                timeSeconds -= advertisement.getDuration();
            }
        }

        //снова сортируем для показа сначала в порядке уменьшения стоимости
        //затем в порядке увеличения стоимости секунды
        Collections.sort(result, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return (int) (o1.getAmountPerOneDisplaying() - o2.getAmountPerOneDisplaying());
            }
        }.thenComparing(new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return (int) ((o2.getAmountPerOneDisplaying() * 1000 / o2.getDuration()) - (o1.getAmountPerOneDisplaying() * 1000 / o1.getDuration()));
            }
        }).reversed());

        //выводим через toString();
        for (Advertisement advertisement : result){
            System.out.println(advertisement);
            advertisement.revalidate();
        }
    }
}