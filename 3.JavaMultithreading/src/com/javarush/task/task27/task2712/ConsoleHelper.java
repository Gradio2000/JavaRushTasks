package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {


    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        return bufferedReader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> dishList = new ArrayList<>();

        writeMessage(Dish.allDishesToString());
        writeMessage("Выберите блюдо");

        while (true){
            one:
            {
                String choose = readString();
                if (choose.equalsIgnoreCase("exit")) {
                    break;
                }

                for (Dish dish : Dish.values()) {
                    if (choose.equalsIgnoreCase(dish.toString())) {
                        dishList.add(dish);
                        break one;
                    }
                }
                ConsoleHelper.writeMessage("Такого блюда нет");
            }
        }
        return dishList;
    }
}
