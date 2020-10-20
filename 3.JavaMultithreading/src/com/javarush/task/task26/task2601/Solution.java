package com.javarush.task.task26.task2601;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Почитать в инете про медиану выборки
*/
public class Solution{

    public static void main(String[] args) {
//        Integer[] array = new Integer[]{10,20,20,30,20,50,60,22};
//        System.out.println(Arrays.toString(sort(array)));

    }

    public static Integer[] sort(Integer[] array)  {
        int mediana;
        List<Integer> list =  Arrays.asList(array);
        Collections.sort(list);
        System.out.println(list);

        if (list.size() % 2 != 0) {
            mediana = list.get(list.size() / 2);
        }
        else {
            int x1 = list.get(list.size() / 2 - 1);
            int x2 = list.get(list.size() / 2);
            mediana = (x1 + x2) / 2;
            System.out.println(String.format("%d %d %d", x1, x2, mediana));
        }
        int raznitsa;

        List<A> aList = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            raznitsa = Math.abs(array[i] - mediana);
            aList.add(new A(raznitsa, array[i]));
        }

        Collections.sort(aList);

        for (int i = 0; i < aList.size(); i++) {
            array[i] = aList.get(i).getVal();
        }
        return array;
    }

}

class A implements Comparable<A>{
    private int raz;
    private int val;

    public A(int raz, int val) {
        this.raz = raz;
        this.val = val;
    }

    public int getRaz() {
        return raz;
    }

    public void setRaz(int raz) {
        this.raz = raz;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    @Override
    public int compareTo(A o) {
        return this.raz - o.raz;
    }
}