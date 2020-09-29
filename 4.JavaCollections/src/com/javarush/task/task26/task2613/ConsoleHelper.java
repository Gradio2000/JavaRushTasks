package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;


public class ConsoleHelper {
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "common_en");
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

   public static String readString() throws InterruptOperationException {
       String line = null;
       try {
           line = bis.readLine();
       } catch (IOException e) {
           e.printStackTrace();
       }
       if (line.toLowerCase().equals("exit")) {
           writeMessage(res.getString("the.end"));
            throw new InterruptOperationException();
        }
        return line;
   }

    public static String askCurrencyCode() throws InterruptOperationException {
        writeMessage(res.getString("choose.currency.code"));
        String currencyCode;
        while (true){
            if (!((currencyCode = readString()).length() != 3)) break;
            writeMessage(res.getString("invalid.data"));
        }
        return currencyCode.toUpperCase();
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {

        boolean stop = false;
        String text = "";
        String[] digists = new String[0];
        boolean isTwoDigist = false;
        boolean isNum = false;
        while (!stop){
            text = readString();
            digists = text.split(" ");
            if (digists.length == 2) {
                isTwoDigist = true;
                if (digists[0].matches("[\\d]+") && digists[1].matches("[\\d]+")){
                    isNum = true;
                }
            }
            if (isNum && isTwoDigist) {
                stop = true;
            }
            else writeMessage("invalid.data");
        }
        return digists;
    }

    public static Operation askOperation() throws InterruptOperationException{
        int commandNum = 0;
        boolean stop = false;
        boolean isNum = false;
        String text = "";
        Operation operation = null;
        while (!stop) {
            writeMessage(res.getString("choose.operation"));
            writeMessage(res.getString("operation.INFO"));
            writeMessage(res.getString("operation.DEPOSIT"));
            writeMessage(res.getString("operation.WITHDRAW"));
            writeMessage(res.getString("operation.EXIT"));
            text = readString();
            try {
              commandNum = Integer.parseInt(text);
              operation = Operation.getAllowableOperationByOrdinal(commandNum);
              stop = true;
          }
          catch (IllegalArgumentException e){
              stop = false;
          }
        }
        return operation;
    }
    public static void printExitMessage(){
        writeMessage(res.getString("the.end"));
    }
}
