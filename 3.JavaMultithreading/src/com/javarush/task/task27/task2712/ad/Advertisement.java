package com.javarush.task.task27.task2712.ad;

public class Advertisement {
    private Object content;             //видео
    private String name;                //имя/название
    private long initialAmount;         //начальная сумма, стоимость рекламы в копейках
    private int hits;                   //количество оплаченных показов
    private int duration;               //продолжительность в секундах
    private long amountPerOneDisplaying; //стоимостиь одного показа рекламного объявления в копейках (initialAmount/hits)

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        if (hits != 0){
            amountPerOneDisplaying = initialAmount / hits;
        }
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }
}
