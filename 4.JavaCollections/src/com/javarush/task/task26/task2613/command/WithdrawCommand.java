package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;



import java.util.*;

class WithdrawCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "withdraw_en");
    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        ConsoleHelper.writeMessage(res.getString("specify.amount"));
        int intSumm;
        while (true){
            String summ;
            if ((summ = ConsoleHelper.readString()).matches("[\\d]+")){
                intSumm = Integer.parseInt(summ);
                if (manipulator.isAmountAvailable(intSumm)){
                    ConsoleHelper.writeMessage(res.getString("success.format"));
                    break;
                }
                ConsoleHelper.writeMessage(res.getString("not.enough.money"));
            }
            ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
        }
        Map<Integer, Integer> map;
        try {
            map = manipulator.withdrawAmount(intSumm);
            TreeMap<Integer, Integer> treeMap = new TreeMap<>(Collections.reverseOrder());
            treeMap.putAll(map);
            for (Integer key : treeMap.keySet()) {
                ConsoleHelper.writeMessage("\t" + key + " - " + treeMap.get(key));
            }
            ConsoleHelper.writeMessage(res.getString("success.format"));
        }
        catch(NotEnoughMoneyException e){
            ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
        }
    }
}
