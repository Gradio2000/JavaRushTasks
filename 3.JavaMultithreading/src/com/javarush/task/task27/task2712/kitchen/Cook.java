package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.Observer;

public class Cook extends Observable implements Observer {
    String name;

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void update(Observable observable, Object order) {
        Order order1 = (Order) order;
        ConsoleHelper.writeMessage("Start cooking - " + order);
        StatisticManager.getInstance().register(new CookedOrderEventDataRow(
                order1.toString(),
                name,
                order1.getTotalCookingTime(),
                order1.getDishes()));

        setChanged();
        notifyObservers(order);
    }
}
