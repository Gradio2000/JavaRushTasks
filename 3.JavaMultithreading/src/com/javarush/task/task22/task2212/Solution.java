package com.javarush.task.task22.task2212;

/*
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {

        if (telNumber == null) {
            return false;
        }
        return (telNumber.matches("^\\+(\\d[\\-\\(\\)]?){11}\\d$") || telNumber.matches("^[\\(\\d]-?(\\d[\\-\\)]?){8}\\d$"))
                && telNumber.matches("^(\\+)?(\\d)*(\\(\\d{3}\\))?(\\d+-?\\d+-?)?\\d+$");

    }

    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        list.add("+380501234567");
//        list.add("+38(050)1234567");
//        list.add("+38050123-45-67");
//        list.add("050123-4567");
//        list.add("+38)050(1234567");
//        list.add("+38(050)1-23-45-6-7");
//        list.add("050ххх4567");
//        list.add("050123456");
//        list.add("(0)501234567");
//        for (String number : list){
//            System.out.println(checkTelNumber(number));


            System.out.println(checkTelNumber("+38(050)123-45-678")); // false
            System.out.println(checkTelNumber("123456789")); // false
            System.out.println(checkTelNumber("+38(050)1-23-45-67")); // false
            System.out.println(checkTelNumber("050ххх4567")); // false
            System.out.println(checkTelNumber("0-50(123)456")); // false
            System.out.println(checkTelNumber("(0501)234567")); // false
            System.out.println(checkTelNumber("+38050123456")); // false
            System.out.println(checkTelNumber("+380501234567-")); // false
            System.out.println();
            System.out.println(checkTelNumber("0501234560")); // true
            System.out.println(checkTelNumber("+380501234567")); // true
            System.out.println(checkTelNumber("+38(050)12345-67"));// true
            System.out.println(checkTelNumber("+38(050)1234567"));// true
            System.out.println(checkTelNumber("+38050123-45-67"));// true
            System.out.println(checkTelNumber("050123-4567"));// true
            System.out.println(checkTelNumber("05(012)34567")); // true
            System.out.println(checkTelNumber("0501234567")); // true

    }
}
