package com.javarush.task.task40.task4006;

import java.io.*;
import java.net.Socket;
import java.net.URL;

/* 
Отправка GET-запроса через сокет
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        getSite(new URL("http://javarush.ru/social.html"));
//        getSite(new URL("http://www.yandex.ru"));
    }

    public static void getSite(URL url) {
        try {
            Socket socket = new Socket(url.getHost(), url.getDefaultPort());
            OutputStream outputStream = socket.getOutputStream();

            String request = "GET "+url.getFile()+" HTTP/1.1\r\n";
            request +="Host: "+url.getHost()+"\r\n\r\n";
            outputStream.write(request.getBytes());
            outputStream.flush();

            InputStream inputStream = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String string;
            while ((string = bufferedReader.readLine()) != null){
                System.out.println(string);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}