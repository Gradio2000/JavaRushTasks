package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JАмиго и Диего лучшие друзья"));
    }

    public static String getPartOfString(String string) {
        String result = "";
        String[] mass = new String[0];
        try {
            mass = string.split(" ");
            result = mass[1] + " " + mass[2] + " " + mass[3] + " " + mass[4];
       }
       catch (RuntimeException e){
           if (mass.length < 5) throw new TooShortStringException();
       }

        return result;
    }

    public static class TooShortStringException extends RuntimeException{
    }
}
