package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BotClient extends Client{

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }



   public class BotSocketThread extends SocketThread{

       protected String getUserName(){
           int x = (int) (1 + Math.random() * 100);
           return "date_bat_" + x;
       }

       @Override
       protected void clientMainLoop() throws IOException, ClassNotFoundException {
           sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
           super.clientMainLoop();
       }

       @Override
       protected void processIncomingMessage(String message) {
           ConsoleHelper.writeMessage(message);

           String name = null;
           String text = null;
           SimpleDateFormat dateFormat;
           String date;

           if (!message.contains(":") || message == null) {
               return;
           }
           else {

               String[] mass = message.split(": ");
               if (mass.length != 2) return;
               name = mass[0];
               text = mass[1];
           }


           String answer = "Информация для " + name + ": ";
           if (text.equalsIgnoreCase("дата")) {
               dateFormat = new SimpleDateFormat("d.MM.yyyy");
               date = dateFormat.format(Calendar.getInstance().getTime());
               BotClient.this.sendTextMessage(answer + date);
           }
           else if (text.equals("день")){
               dateFormat = new SimpleDateFormat("d");
               date = dateFormat.format(Calendar.getInstance().getTime());
               BotClient.this.sendTextMessage(answer + date);
           }
           else if (text.equals("месяц")){
               dateFormat = new SimpleDateFormat("MMMM");
               date = dateFormat.format(Calendar.getInstance().getTime());
               BotClient.this.sendTextMessage(answer + date);
           }
           else if (text.equals("год")){
               dateFormat = new SimpleDateFormat("yyyy");
               date = dateFormat.format(Calendar.getInstance().getTime());
               BotClient.this.sendTextMessage(answer + date);
           }
           else if (text.equals("время")){
               dateFormat = new SimpleDateFormat("H:mm:ss");
               date = dateFormat.format(Calendar.getInstance().getTime());
               BotClient.this.sendTextMessage(answer + date);
           }
           else if (text.equals("час")){
               dateFormat = new SimpleDateFormat("H");
               date = dateFormat.format(Calendar.getInstance().getTime());
               BotClient.this.sendTextMessage(answer + date);
           }
           else if (text.equals("минуты")){
               dateFormat = new SimpleDateFormat("m");
               date = dateFormat.format(Calendar.getInstance().getTime());
               BotClient.this.sendTextMessage(answer + date);
           }
           else if (text.equals("секунды")){
               dateFormat = new SimpleDateFormat("s");
               date = dateFormat.format(Calendar.getInstance().getTime());
               BotClient.this.sendTextMessage(answer + date);
           }
       }



   }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        int x = (int) (1 + Math.random()* 99);
        return "date_bot_" + x;
    }
}
