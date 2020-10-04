package com.javarush.task.task34.task3410.view;

import com.javarush.task.task34.task3410.model.Home;

import javax.swing.*;
import java.awt.*;

public class Field extends JPanel {
    View view;
    public Field(View view) {
        this.view = view;
    }

    public void paint(Graphics g){
//        Player player = new Player(50, 50);
//        player.draw(g);
//        Box box = new Box(50,30);
//        box.draw(g);
        Home home = new Home(50, 70);
        home.draw(g);
    }
}
