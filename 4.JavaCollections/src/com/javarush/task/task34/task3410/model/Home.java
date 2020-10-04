package com.javarush.task.task34.task3410.model;

import java.awt.*;

public class Home extends GameObject{
    public Home(int x, int y) {
        super(x, y);
        setWidth(2);
        setHeight(2);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.RED);
        int xc = getX();
        int yc = getY();
        int height = getHeight();
        int width = getWidth();

        graphics.drawOval(xc - width / 2, yc - height / 2, width, height);
    }
}
