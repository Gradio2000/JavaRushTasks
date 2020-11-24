package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;
    ConsoleHelper consoleHelper = new ConsoleHelper();

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        dishes = consoleHelper.getAllDishesForOrder();
        ConsoleHelper.writeMessage(toString());
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public int getTotalCookingTime(){
        int orderTotalTime = 0;
        for (Dish dish : dishes){
            orderTotalTime += dish.getDuration();
        }
        return orderTotalTime;
    }

    public boolean isEmpty(){
        return dishes.isEmpty();
    }

    @Override
    public String toString() {
        return "Order: " + tablet +
                ", dishes=" + dishes + "cooking time " + getTotalCookingTime() + "min";
    }


}
