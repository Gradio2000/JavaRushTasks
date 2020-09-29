package com.javarush.task.task39.task3901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/* 
Уникальные подстроки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter your string: ");
        String s = bufferedReader.readLine();

        System.out.println("The longest unique substring length is: \n" + lengthOfLongestUniqueSubstring(s));
    }

    public static int lengthOfLongestUniqueSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;
        char[] mass = s.toCharArray();
        int count = 0;
        int result = 0;

        for (int i = 0; i < mass.length; i++) {
            count = counter(i, mass);
            if (count > result){
                result = count;
            }
        }
        return result;
    }

    public static int counter(int i, char[] mass){
        Set<Character> set = new HashSet<>();
        for (int z = i; z < mass.length; z++) {
            if (!set.add(mass[z])){
                break;
            }
        }
        return set.size();
    }
}
