package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(74);
        solution.createExpression(1234);
        solution.createExpression(2);
    }

    public void createExpression(int number) {
        //напишите тут ваш код
        StringBuilder resultString = new StringBuilder();
        resultString.append(number);
        resultString.append(" = ");
        int count = 0;
        int temp;
        do {
            int res = number % 3;
            if (res == 2){
                resultString.append("- ");
                resultString.append((int) (1 * Math.pow(3, count)));
                resultString.append(" ");
                number = number / 3 + 1;
            }
            else if (res == 1){
                resultString.append("+ ");
                resultString.append((int) (1 * Math.pow(3, count)));
                resultString.append(" ");
                number = number / 3;
            }
            else if (res == 0){
                number = number / 3;
            }
            count++;
        }while (number > 0);
        String text = resultString.toString();
        System.out.println(text.substring(0, text.length() - 1));
    }
}