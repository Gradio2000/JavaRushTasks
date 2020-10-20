package com.javarush.task.task26.task2603;

import java.util.Comparator;

public class Solution {

    public static void main(String[] args) {

    }

    public static class CustomizedComparator<T> implements Comparator<T> {
        private Comparator<T>[] comparators;

        public CustomizedComparator(Comparator<T>... comparators) {
            this.comparators = comparators;
        }

        @Override
        public int compare(T o1, T o2) {
            for (int i = 0; i < comparators.length; i++) {
                int res = comparators[i].compare(o1, o2);
                if (res != 0){
                    return res;
                }
            }
            return 0;
        }
    }
}
