package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return bufferedReader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        writeMessage(Dish.allDishesToString());
        writeMessage("Выберете заказ!");
        Dish[] dishes = Dish.values();
        List<String> allDishes = new ArrayList<>(dishes.length);
        for (int i = 0; i < dishes.length; i++) {
            allDishes.add(dishes[i].toString());
        }
        List<Dish> dishListToOrdered = new ArrayList<>();

        while (true){
            lable:
            {
                String choice = readString();

                if (choice.equalsIgnoreCase("exit")) {
                    break;
                }

                for (int i = 0; i < dishes.length; i++) {
                    if (choice.equalsIgnoreCase(dishes[i].toString())) {
                        dishListToOrdered.add(dishes[i]);
                        break lable;
                    }
                }

                ConsoleHelper.writeMessage("Такого блюда нет!");
            }
        }
        return dishListToOrdered;
    }
}
