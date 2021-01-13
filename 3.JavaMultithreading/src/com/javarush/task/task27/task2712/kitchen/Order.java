package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;


    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        dishes = ConsoleHelper.getAllDishesForOrder();
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public Tablet getTablet() {
        return tablet;
    }

    @Override
    public String toString() {
        if (dishes.isEmpty()){
            return "";
        }
        else {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < dishes.size(); i++) {
                stringBuilder.append(dishes.get(i));
                if (i != dishes.size() - 1){
                    stringBuilder.append(", ");
                }
            }
            return "Your order: [" + stringBuilder.toString() + "] of "
                    + tablet.toString() + ", cooking time " + getTotalCookingTime() + "min";
        }

    }

    public int getTotalCookingTime(){
        int duration = 0;
        for (Dish dish : dishes){
            duration += dish.getDuration();
        }
        return duration;

    }

    public boolean isEmpty(){
        return dishes.isEmpty();
    }
}
