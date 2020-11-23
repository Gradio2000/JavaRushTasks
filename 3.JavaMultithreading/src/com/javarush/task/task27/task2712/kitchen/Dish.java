package com.javarush.task.task27.task2712.kitchen;

public enum Dish {
    Fish(25), Steak(30), Soup(15), Juice(5), Water(3);

    private int duration;

    public int getDuration() {
        return duration;
    }

    Dish(int duration) {
        this.duration = duration;
    }

    public static String allDishesToString() {
        String result = "";

        for (Dish dish : Dish.values()) {
            if ("".equals(result)) {
                result += dish.name();
            } else {
                result += ", " + dish.name();
            }
        }
        return result;
    }
}
