package com.javarush.task.task27.task2712.kitchen;

public enum Dish {
    FISH, STEAK, SOUP, JUICE, WATER;
    public static String allDishesToString(){
        StringBuilder stringBuilder = new StringBuilder();
        Dish[] mas = Dish.values();
        for (int i = 0; i < mas.length; i++) {
            stringBuilder.append(mas[i]);
            if (i != mas.length - 1){
                stringBuilder.append(", ");
            }
        }
        return stringBuilder.toString();
    }
}
