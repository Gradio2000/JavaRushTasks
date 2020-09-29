package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import java.util.ResourceBundle;


class LoginCommand implements Command{
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "verifiedCards");
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "login_en");

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        String textCard;
        String textPin;
        while (true) {
            while (true) {
                ConsoleHelper.writeMessage(res.getString("specify.data"));
                textCard = ConsoleHelper.readString();
                if (textCard.toLowerCase().equals("exit")) {
                    throw new InterruptOperationException();
                } else {
                    break;
                }
            }
            while (true) {
                ConsoleHelper.writeMessage(res.getString("specify.data"));
                textPin = ConsoleHelper.readString();
                if (textPin.toLowerCase().equals("exit")) {
                    throw new InterruptOperationException();
                } else {
                    break;
                }
            }

            if (validCreditCards.containsKey(textCard) && validCreditCards.getString(textCard).equals(textPin)) {
                ConsoleHelper.writeMessage(res.getString("success.format"));
                break;
            } else {
                ConsoleHelper.writeMessage(res.getString("not.verified.format"));
                ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
            }
        }
    }
}
