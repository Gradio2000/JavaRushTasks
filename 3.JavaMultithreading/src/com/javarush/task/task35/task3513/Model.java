package com.javarush.task.task35.task3513;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile [][] gameTiles;
    public int score;
    public int maxTile;


    public Model() {
        resetGameTiles();
    }

    private void addTile(){
        List<Tile> tileList = getEmptyTiles();
        if (!tileList.isEmpty()) {
            Tile tile = tileList.get((int) (tileList.size() * Math.random()));
            tile.value = Math.random() < 0.9 ? 2 : 4;
        }
    }

    private List<Tile> getEmptyTiles(){
        List<Tile> tileList = new ArrayList<>();
        for (Tile[] gameTile : gameTiles) {
            for (int j = 0; j < gameTiles[1].length; j++) {
                Tile tile = gameTile[j];
                if (tile.isEmpty()) {
                    tileList.add(tile);
                }
            }
        }
        return tileList;
    }

    public void resetGameTiles(){
        gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[1].length; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
    }

    private void compressTiles(Tile[] tiles){
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 1; i < tiles.length; i++) {
                if (tiles[i - 1].value == 0 && tiles[i].value != 0) {
                    tiles[i - 1] = tiles[i];
                    tiles[i] = new Tile();
                    sorted = false;
                }
            }
        }
    }

    private void mergeTiles(Tile[] tiles){
        for (int i = 1; i < tiles.length; i++) {
            if (tiles[i].value == tiles[i - 1].value){
                tiles[i - 1].value += tiles[i].value;
                tiles[i].value = 0;
                score += tiles[i - 1].value;
            }
            if (tiles[i - 1].value > maxTile){
                maxTile = tiles[i - 1].value;
            }
        }
        compressTiles(tiles);
    }
}
