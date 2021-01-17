package com.javarush.task.task35.task3513;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile [][] gameTiles;

    public Model() {
        this.gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[1].length; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
    }
}
