package com.javarush.task.task37.task3714;

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Древний Рим
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman number to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result equals " + romanToInteger(romanString));
    }

    public static int romanToInteger(String s) {
        Map<String, Integer> map = new HashMap();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);

        List<Integer> list = new ArrayList<>();

        Pattern pattern = Pattern.compile("\\w");
        Matcher matcher = pattern.matcher(s);

        while (matcher.find()) {
            list.add(map.get(matcher.group()));
        }

        int temp = 0;

        if (list.size() == 1) {
            return list.get(0);
        } else {
            temp = list.get(list.size() - 1);
            for (int i = list.size() - 1; i > 0; i--) {
                if (i != 0 && list.get(i) <= list.get(i - 1)) {
                    temp = temp + list.get(i - 1);
                } else if (i != 0 && list.get(i) > list.get(i - 1)) {
                    temp = temp - list.get(i - 1);
                }
            }
        }
        return temp;
    }
}



