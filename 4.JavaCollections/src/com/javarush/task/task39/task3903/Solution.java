package com.javarush.task.task39.task3903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Неравноценный обмен
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Please enter a number: ");

        long number = Long.parseLong(reader.readLine());
        System.out.println("Please enter the first index: ");
        int i = Integer.parseInt(reader.readLine());
        System.out.println("Please enter the second index: ");
        int j = Integer.parseInt(reader.readLine());

        System.out.println("The result of swapping bits is " + swapBits(number, i, j));
    }

    public static long swapBits(long number, int i, int j) {
        String s = Long.toBinaryString(number);
        int count = s.length();
        while (count < 64){
            s = 0 + s;
            count++;
        }

        char[] mass = s.toCharArray();

        try {
            char z = mass[63 - i];
            mass[63 - i] = mass[63 - j];
            mass[63 - j] = z;
            String x = "";
            for (int k = 0; k < mass.length; k++) {
                x = x + mass[k];
            }
            number = Long.parseLong(x, 2);

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return number;
    }
}
