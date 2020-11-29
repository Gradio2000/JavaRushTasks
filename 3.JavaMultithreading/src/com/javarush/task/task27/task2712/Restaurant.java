package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Waiter;

public class Restaurant {
    public static void main(String[] args) {
        Tablet tablet = new Tablet(1);
        Cook cook = new Cook("Alex");
        tablet.addObserver(cook);
        Waiter waiter = new Waiter();
        cook.addObserver(waiter);

        tablet.createOrder();
        tablet.createOrder();

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();

//        tablet.createOrder();
//        tablet.createOrder();
    }
}
