package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CurrencyManipulator {
    private String currencyCode;
    private Map<Integer, Integer> denominations = new HashMap<>();

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void addAmount(int denomination, int count){
        if (denominations.containsKey(denomination)){
            int value = denominations.get(denomination) + count;
            denominations.put(denomination, value);
        } else
        denominations.put(denomination, count);
    }

    public int getTotalAmount(){
        int summ = 0;
        for (Integer key : denominations.keySet()) {
            summ = summ + denominations.get(key) * key;
        }
        return summ;
    }

    public boolean hasMoney(){
        return getTotalAmount() != 0;
    }

    public boolean isAmountAvailable(int expectedAmount){
        return getTotalAmount() >= expectedAmount;
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException {
        Map<Integer, Integer> maprez = new HashMap<>();
        Map<Integer, Integer> map1 = new TreeMap<>(Collections.reverseOrder());
        map1.putAll(denominations);

        for (Integer key : map1.keySet()){
            int cashAmount = expectedAmount / key;
            if (cashAmount >= 1){
            maprez.put(key, cashAmount);
            expectedAmount = expectedAmount - cashAmount * key;
            }
        }
        if (expectedAmount != 0){
            maprez.clear();
            throw new NotEnoughMoneyException();
        }
        for (Integer key : maprez.keySet()){
            denominations.put(key, denominations.get(key) - maprez.get(key));
        }
        return maprez;
    }
}
