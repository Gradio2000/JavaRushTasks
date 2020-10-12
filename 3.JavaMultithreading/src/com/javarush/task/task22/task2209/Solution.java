package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //...
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader = new BufferedReader(new FileReader(fileName));
        String text = "";
        String line;
        while ((line = bufferedReader.readLine()) != null){
            text = text + line;
        }
        String[] mass = text.split(" ");
        StringBuilder result = getLine(mass);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder s = new StringBuilder();
        if (words.length == 0 || words == null) return s;

        List<String> list = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            s.append(list.get(i));
        }
        return s;
    }
}
