package com.javarush.task.task34.task3410.view;

import com.javarush.task.task34.task3410.controller.EventListener;
import com.javarush.task.task34.task3410.model.GameObject;
import com.javarush.task.task34.task3410.model.GameObjects;

import javax.swing.*;
import java.awt.*;
import java.util.Set;

public class Field extends JPanel {
    private EventListener eventListener;
    View view;
    public Field(View view) {
        this.view = view;
    }

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public void paint(Graphics g){

            g.setColor(Color.BLACK);
            g.fillRect(getX(), getY(), getWidth(), getHeight());
            GameObjects gameObjects = view.getGameObjects();
            Set<GameObject> set = gameObjects.getAll();
            for (GameObject object : set){
                object.draw(g);
            }
    }
    //
}
