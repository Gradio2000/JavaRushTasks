package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Arrays;

/* 
Алгоритмы-числа
*/
public class Solution {

    public static long[] getNumbers(long N) {

        ArrayList<Long> list = new ArrayList<>();
        ArrayList<Long> res = new ArrayList<>();

        long[][] mass = new long[10][10];
        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < mass[0].length; j++) {
                mass[i][j] = (long) Math.pow(i, j);
            }
        }

        int[] srcArr = new int[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        long result1 = 0;
        for (int i = 0; i < srcArr.length; i++) {
            result1 = srcArr[i] + result1 * 10;
            list.add(result1);
        }

        int c = String.valueOf(N).length();
        System.out.println(c);


        System.out.println(list);
        System.out.println(res);


        long[] result = null;
        return result;
    }

    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(Long.MAX_VALUE)));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(100)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);
    }
}
