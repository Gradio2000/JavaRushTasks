package com.javarush.task.task22.task2211;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Charset utf8 = Charset.forName("UTF-8");
        Charset Windows1251 = Charset.forName("Windows-1251");
        FileInputStream fis = new FileInputStream(args[0]);
        byte[] bytes = new byte[1000];
        fis.read(bytes);
        String s = new String(bytes, Windows1251);
        byte[] newBytes = s.getBytes(utf8);
        FileOutputStream fos = new FileOutputStream(args[1]);
        fos.write(newBytes);
    }
}
