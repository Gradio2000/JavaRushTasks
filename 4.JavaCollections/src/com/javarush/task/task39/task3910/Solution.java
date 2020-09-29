package com.javarush.task.task39.task3910;

/* 
isPowerOfThree
*/
public class Solution {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            isPowerOfThree(i);
        }
    }

    public static boolean isPowerOfThree(int n) {
        System.out.println(Math.log(n) / Math.log(3) % 1);
        return Math.log(n) / Math.log(3) % 1 == 0;
    }
}
