package com.javarush.task.task39.task3905;

public class PhotoPaint {
    public boolean paintFill(Color[][] image, int x, int y, Color desiredColor) {
        if (image.length <= y || image[0].length <= x) return false;
        if (desiredColor.equals(image[y][x])) return false;
        image[y][x] = desiredColor;
        return true;
    }
}
