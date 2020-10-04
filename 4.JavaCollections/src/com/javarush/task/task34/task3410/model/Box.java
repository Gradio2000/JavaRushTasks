package com.javarush.task.task34.task3410.model;

import java.awt.*;

public class Box extends CollisionObject implements Movable{

    public Box(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.GRAY);

        int xc = getX();
        int yc = getY();
        int height = getHeight();
        int width = getWidth();

        graphics.fillRect(xc - width / 2, yc - height / 2, width, height);
        graphics.setColor(Color.BLUE);
        graphics.drawLine(xc - width / 2, yc - height / 2, xc + width / 2, yc + height / 2);
        graphics.drawLine(xc - width / 2, yc + height / 2, xc + width / 2, yc - height / 2);

    }

    @Override
    public void move(int x, int y) {
        int newX = this.getX() + x;
        int newY = this.getY() + y;

        this.setX(newX);
        this.setY(newY);
    }
}
