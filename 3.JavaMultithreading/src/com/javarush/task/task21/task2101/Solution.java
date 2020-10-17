package com.javarush.task.task21.task2101;

/* 
Определяем адрес сети
*/
public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        byte[] net = new byte[4];
        for (int i = 0; i < ip.length; i++) {
            net[i] = (byte) (ip[i] & mask[i]);
        }
        return net;
    }

    public static void print(byte[] bytes) {
        String text = null;
        for (int i = 0; i < bytes.length; i++) {
            text = Integer.toBinaryString(bytes[i]);
            if (text.length() > 8){
              text = text.substring(text.length() - 8);
            }
            else {
                StringBuffer stringBuffer = new StringBuffer(text);
                stringBuffer.reverse();
                while (stringBuffer.length() < 8){
                   stringBuffer.append("0");
                }
                text = stringBuffer.reverse().toString();
            }
            System.out.print(text + " ");
        }
        System.out.println();
    }
}