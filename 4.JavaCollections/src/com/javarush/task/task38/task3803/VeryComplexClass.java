package com.javarush.task.task38.task3803;

/* 
Runtime исключения (unchecked exception)
*/

import java.util.Date;

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        Object x = new Integer(0);
        System.out.println((String)x);
    }

    public void methodThrowsNullPointerException() {
        Date[] s = new Date[2];
        System.out.println(new Date().compareTo(s[0]));
    }

    public static void main(String[] args) {
 //       new VeryComplexClass().methodThrowsClassCastException();
  //      new VeryComplexClass().methodThrowsNullPointerException();
    }
}
