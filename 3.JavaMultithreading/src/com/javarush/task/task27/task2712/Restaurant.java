package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;

public class Restaurant {
    public static void main(String[] args) {
        Tablet tablet = new Tablet(1);
        Cook cook = new Cook("Alex");
        tablet.addObserver(cook);
        tablet.createOrder();


//        tablet.createOrder();
//        tablet.createOrder();
//        tablet.createOrder();
    }
}
