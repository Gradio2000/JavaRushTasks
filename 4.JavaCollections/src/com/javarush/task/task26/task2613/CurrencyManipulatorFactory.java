package com.javarush.task.task26.task2613;

import java.util.*;

public class CurrencyManipulatorFactory {
    private static Map<String, CurrencyManipulator> map = new HashMap<>();
    private CurrencyManipulatorFactory() {
    }

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode){
        if (map.containsKey(currencyCode)){
            return map.get(currencyCode);
        }
        else {
            CurrencyManipulator manipulator = new CurrencyManipulator(currencyCode);
            map.put(currencyCode, manipulator);
            return manipulator;
        }
    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators(){
        Collection<CurrencyManipulator> currencyManipulators = new HashSet<CurrencyManipulator>();
        for (String key : map.keySet()){
            currencyManipulators.add(map.get(key));
        }
        return currencyManipulators;
    }
}
