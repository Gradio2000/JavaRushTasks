package com.javarush.task.task39.task3908;

import java.util.*;

/*
Возможен ли палиндром?
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(isPalindromePermutation("aassdgggdf"));
    }

    public static boolean isPalindromePermutation(String s) {
        s = s.replace(" ", "").toLowerCase();
            char[] mass = s.toCharArray();
            int count;
            int key;

            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < mass.length; i++) {
                key = (int) mass[i];
                if (!map.containsKey(key)){
                    map.put(key, 1);
                }
                else {
                    count = map.get(key) + 1;
                    map.put(key, count);
                }
            }

            count = 0;

            for (int value : map.values()){
                if (value % 2 != 0){
                    count++;
                }
            }
        System.out.println(count);
            if (count == 0 || count == 1) return true;
            else return false;
    }
}
