package com.javarush.task.task27.task2712.statistic.event;

import com.javarush.task.task27.task2712.ad.Advertisement;

import java.util.Date;
import java.util.List;

public class VideoSelectedEventDataRow implements EventDataRow{
    private List<Advertisement> optimalVideoSet;
    private long amount;
    private int totalDuration;
    private Date currentDate;

    public VideoSelectedEventDataRow(List<Advertisement> optimalVideoSet, long amount, int totalDuration) {
        this.optimalVideoSet = optimalVideoSet;
        this.amount = amount;
        this.totalDuration = totalDuration;
        currentDate = new Date();
    }


//    public VideoSelectedEventDataRow(List<Advertisement> result, long amount, int totalDuration, long l) {
//        this.optimalVideoSet = optimalVideoSet;
//        this.amount = amount;
//        this.totalDuration = totalDuration;
//        this.currentDate = new Date(l);
//    }

    @Override
    public EventType getType() {
        return EventType.SELECTED_VIDEOS;
    }

    @Override
    public Date getDate() {
        return currentDate;
    }

    @Override
    public int getTime() {
        return totalDuration;
    }

    public List<Advertisement> getOptimalVideoSet() {
        return optimalVideoSet;
    }

    public long getAmount() {
        return amount;
    }

    public int getTotalDuration() {
        return totalDuration;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    /*
optimalVideoSet - список видео-роликов, отобранных для показа
amount - сумма денег в копейках
totalDuration - общая продолжительность показа отобранных рекламных роликов
     */
}
