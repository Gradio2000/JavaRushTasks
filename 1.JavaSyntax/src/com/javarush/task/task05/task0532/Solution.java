package com.javarush.task.task05.task0532;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = 0;
        while (true) {
            String line = reader.readLine();
            try {
                if ((N = Integer.parseInt(line)) > 0) {
                    break;
                }
                else break;
            } catch (NumberFormatException e) {
                break;
            }
        }

        if (N > 0) {
            int[] mass = new int[N];
            BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
            for (int i = 0; i < N; i++) {
                String line = reader1.readLine();
                try {
                    mass[i] = Integer.parseInt(line);
                } catch (NumberFormatException e) {
                    i--;
                    continue;
                }
            }

            int max = Integer.MIN_VALUE;
            for (int i = 0; i < mass.length; i++) {
                if (mass[i] > max) {
                    max = mass[i];
                }
            }
            reader.close();
            reader1.close();
            System.out.println(max);
        }
    }
}
