package com.javarush.task.task39.task3912;

/* 
Максимальная площадь
*/

public class Solution {
    public static void main(String[] args) {
        int[][] matrix = {{1, 0, 0, 0, 0, 0},
                          {0, 0, 0, 0, 0, 0},
                          {1, 1, 1, 1, 1, 1},
                          {1, 1, 1, 1, 1, 1},
                          {1, 1, 1, 1, 1, 1},
                          {0, 0, 1, 1, 1, 1},
        };
        System.out.println(maxSquare(matrix));
    }

    public static int maxSquare(int[][] matrix) {
        int max = 0;
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
               if (matrix[i][j] != 0){
                   matrix[i][j] = Math.min(matrix[i - 1][j], Math.min(matrix[i - 1][j - 1], matrix[i][j - 1])) + 1;
                   if (matrix[i][j] > max){
                       max = matrix[i][j];
                   }
               }
            }
        }
        return max * max;
    }
}
