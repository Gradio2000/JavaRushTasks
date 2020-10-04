package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();
        // захаркодим имена!
//        String file1 = "/Users/aleksejlaskin/Documents/1/1.txt";
//        String file2 = "/Users/aleksejlaskin/Documents/1/2.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file1));
        List<String> list1 = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            list1.add(line);
        }
        bufferedReader.close();
        BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file2));
        List<String> list2 = new ArrayList<>();
        while ((line = bufferedReader2.readLine()) != null) {
            list2.add(line);
        }
        bufferedReader2.close();
//        System.out.println(list1);
//        System.out.println(list2);

        int count = 0;
        for (int i = 0; i < list1.size(); i++) {
            if (count <= i && count < list2.size() && list1.get(i).equals(list2.get(count))) {
                LineItem lineItem = new LineItem(Type.SAME, list1.get(i));
                lines.add(lineItem);
                count++;
                System.out.println(lineItem.type + " " + lineItem.line);

            } else if (count <= i && count < list2.size() - 1 && list1.get(i).equals(list2.get(count + 1))) {
                LineItem lineItem = new LineItem(Type.ADDED, list2.get(count));
                lines.add(lineItem);
                i--;
                count++;
                System.out.println(lineItem.type + " " + lineItem.line);
            } else {
                LineItem lineItem = new LineItem(Type.REMOVED, list1.get(i));
                lines.add(lineItem);
                System.out.println(lineItem.type + " " + lineItem.line);
            }
            if (i + 1 == list1.size() && count < list2.size()){
                while (count < list2.size()){
                    LineItem lineItem = new LineItem(Type.ADDED, list2.get(count));
                    count++;
                    System.out.println(lineItem.type + " " + lineItem.line);
                }
            }
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
