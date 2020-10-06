package com.javarush.task.task34.task3410.controller;

import com.javarush.task.task34.task3410.model.Direction;
import com.javarush.task.task34.task3410.model.GameObjects;
import com.javarush.task.task34.task3410.model.Model;
import com.javarush.task.task34.task3410.view.View;

import java.io.IOException;

public class Controller implements EventListener {
    private View view;
    private Model model;
    public Controller() throws IOException {
        view = new View(this);
        model = new Model();
        model.restart();
        view.init();
        model.setEventListener(this);
        view.setEventListener(this);

    }

    public static void main(String[] args) throws IOException {
        Controller controller = new Controller();
    }

    public GameObjects getGameObjects(){
        return model.getGameObjects();
    }


    @Override
    public void move(Direction direction) {
        model.move(direction);
        view.update();
    }

    @Override
    public void restart() {
        try {
            model.restart();
        } catch (IOException e) {
            e.printStackTrace();
        }
        view.update();
    }

    @Override
    public void startNextLevel() {
        try {
            model.startNextLevel();
        } catch (IOException e) {
            e.printStackTrace();
        }
        view.update();
    }

    @Override
    public void levelCompleted(int level) {
        view.completed(level);
    }
}
