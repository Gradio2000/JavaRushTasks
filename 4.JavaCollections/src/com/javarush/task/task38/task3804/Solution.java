package com.javarush.task.task38.task3804;

/* 
Фабрика исключений
*/

import java.rmi.server.UnicastRemoteObject;

public class Solution {
    public static Class getFactoryClass() {

        return new Factory().getClass();
    }

    public static void main(String[] args) {
        System.out.println(Factory.methodExeption(null));
    }
}

class Factory {

    public static Throwable methodExeption(Enum enumenum) {
        if (enumenum != null) {
            String message = enumenum.toString()
                    .toLowerCase()
                    .replace("_", " ");
            message = message.substring(0, 1).toUpperCase() + message.substring(1);

            if (enumenum instanceof ApplicationExceptionMessage) {
                return new Exception(message);
            } else if (enumenum instanceof DatabaseExceptionMessage) {
                return new RuntimeException(message);
            } else if (enumenum instanceof UserExceptionMessage) {
                return new Error(message);
            } else return new IllegalArgumentException();
        }
        else return new IllegalArgumentException();
    }
}