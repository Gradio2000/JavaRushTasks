package com.javarush.task.task25.task2510;

/* 
Поживем - увидим
*/
public class Solution extends Thread {

    public Solution() {
        this.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                String massege;
                if (e instanceof Error){
                     massege = "Нельзя дальше работать";
                 }
                  else if (e instanceof Exception){
                    massege = "Надо обработать";
                 }
                 else {
                     massege = "Поживем - увидим";
                 }
                System.out.println(massege);
            }
        });
    }

    public static void main(String[] args) {
    }
}
