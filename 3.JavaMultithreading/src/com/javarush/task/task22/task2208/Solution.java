package com.javarush.task.task22.task2208;

import java.util.*;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("name", "Ivanov");
        map.put("country", null);
        map.put("city", "Moscow");
        map.put("age", "10");
        System.out.println(getQuery(map));
    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder s = new StringBuilder();


        for (String key : params.keySet()) {
            if (params.get(key) != null) {
                if (s.toString().length() != 0){
                    s.append(" and ");
                }
                s.append(key);
                s.append(" = ");
                s.append("'" + params.get(key) + "'");
            }
        }
        return s.toString();
    }
}
