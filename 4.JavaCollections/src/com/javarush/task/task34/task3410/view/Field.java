package com.javarush.task.task34.task3410.view;

import com.javarush.task.task34.task3410.controller.EventListener;
import com.javarush.task.task34.task3410.model.Direction;
import com.javarush.task.task34.task3410.model.GameObject;
import com.javarush.task.task34.task3410.model.GameObjects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Set;

public class Field extends JPanel {
    private EventListener eventListener;
    View view;
    public Field(View view) {
        this.view = view;
        KeyHandler keyHandler = new KeyHandler();
        addKeyListener(keyHandler);
        setFocusable(true);
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

    public class KeyHandler extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()){
                case KeyEvent.VK_LEFT:
                    eventListener.move(Direction.LEFT);
                case KeyEvent.VK_RIGHT:
                    eventListener.move(Direction.RIGHT);
                case KeyEvent.VK_UP:
                    eventListener.move(Direction.UP);
                case KeyEvent.VK_DOWN:
                    eventListener.move(Direction.DOWN);
                case KeyEvent.VK_R:
                    eventListener.restart();
            }
        }
    }
}
