package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Waiter;

public class Restaurant {
    public static void main(String[] args) {
        Tablet tablet = new Tablet(1);
        DirectorTablet directorTablet = new DirectorTablet();
        Cook cook1 = new Cook("Alex");
        Waiter waiter = new Waiter();
        tablet.addObserver(cook1);
        cook1.addObserver(waiter);
        tablet.createOrder();
        tablet.createOrder();
//        tablet.createOrder();
//        tablet.createOrder();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();

    }
}
