package com.javarush.task.task30.task3010;

/*
Минимальное допустимое основание системы счисления
*/

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Pattern pattern = Pattern.compile("[^A-Za-z0-9]");
        Matcher matcher = null;
        try {
            matcher = pattern.matcher(args[0]);
            if (matcher.find()){
                System.out.println("incorrect");
                return;
            }
            else {
                for (int i = 2; i <= 36; i++) {
                    try {
                        new BigInteger(args[0], i);
                        System.out.println(i);
                    } catch (Exception e) {
                        continue;
                    }
                    return;
                }
            }


        } catch (Exception e) {

        }

    }
}