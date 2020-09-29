package com.javarush.task.task39.task3904;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Лестница
*/
public class Solution {
    private static int n = 10;

    public static void main(String[] args) {
        System.out.println("The number of possible ascents for " + n + " steps is: " + numberOfPossibleAscents(n));
    }

    public static long numberOfPossibleAscents(int n) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        List<Long> list = new ArrayList<>();
        list.add((long) 1);
        list.add((long) 2);
        list.add((long) 4);

        for (int i = 3; i < n; i++) {
            list.add(list.get(i - 1) + list.get(i - 2) + list.get(i - 3));
        }
//        System.out.println(list);
        return list.get(list.size() - 1);
    }
}

