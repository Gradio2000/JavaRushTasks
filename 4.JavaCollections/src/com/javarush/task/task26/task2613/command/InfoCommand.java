package com.javarush.task.task26.task2613.command;
import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;

import java.util.Collection;
import java.util.Iterator;
import java.util.ResourceBundle;


class InfoCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "info_en");
    @Override
    public void execute() {
        ConsoleHelper.writeMessage(res.getString("before"));
        Collection manipulators = CurrencyManipulatorFactory.getAllCurrencyManipulators();
        if (manipulators.size() == 0){
            ConsoleHelper.writeMessage(res.getString("no.money"));
        }
        else {
            CurrencyManipulator manipulator;
            Iterator<CurrencyManipulator> iterator = manipulators.iterator();
            while (iterator.hasNext()){
                manipulator = iterator.next();
                int total = manipulator.getTotalAmount();
                if (total == 0){
                    ConsoleHelper.writeMessage(res.getString("no.money"));
                }
                else {
                    ConsoleHelper.writeMessage(manipulator.getCurrencyCode() + " - " + total);
                }

            }
        }
    }
}
