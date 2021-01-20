package com.javarush.task.task35.task3513;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile [][] gameTiles;
    public int score;
    public int maxTile;
    private Stack<Tile[][]> previousStates = new Stack();
    private Stack<Integer> previousScores = new Stack();
    private boolean isSaveNeeded = true;


    public Model() {
        resetGameTiles();
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    public boolean canMove(){
         if (getEmptyTiles().size() > 0){
             return true;
         }

        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[1].length; j++) {
                if (j < gameTiles[1].length - 1 && gameTiles[i][j].value == gameTiles[i][j + 1].value ){
                    return true;
                }
                if (i < gameTiles.length - 1 && gameTiles[i][j].value == gameTiles[i + 1][j].value){
                    return true;
                }
            }
        }
        return false;
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

    private boolean compressTiles(Tile[] tiles){
        boolean changed = false;
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 1; i < tiles.length; i++) {
                if (tiles[i - 1].value == 0 && tiles[i].value != 0) {
                    tiles[i - 1].value = tiles[i].value;
                    tiles[i].value = 0;
                    sorted = false;
                    changed = true;
                }
            }
        }
        return changed;
    }

    private boolean mergeTiles(Tile[] tiles){
        boolean changed = false;
        for (int i = 1; i < tiles.length; i++) {
            if (tiles[i].value != 0) {
                if (tiles[i].value == tiles[i - 1].value) {
                    tiles[i - 1].value += tiles[i].value;
                    tiles[i].value = 0;
                    score += tiles[i - 1].value;
                    changed = true;
                }
            }
            if (tiles[i - 1].value > maxTile){
                maxTile = tiles[i - 1].value;
            }
        }
        compressTiles(tiles);
        return changed;
    }

    public void left(){
        if (isSaveNeeded){
            saveState(gameTiles);
        }
        boolean changed = false;
        Tile[] tiles = new Tile[FIELD_WIDTH];
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[1].length; j++) {
                tiles[j] = gameTiles[i][j];
            }
            if (compressTiles(tiles) || mergeTiles(tiles)){
                changed = true;
            }
        }
        if (changed){
            addTile();
        }
        isSaveNeeded = true;
    }

    public void down(){
        saveState(gameTiles);
        turnArray();
        left();
        turnArray();
        turnArray();
        turnArray();
    }

    public void right(){
        saveState(gameTiles);
        turnArray();
        turnArray();
        left();
        turnArray();
        turnArray();
    }

    public void up(){
        saveState(gameTiles);
        turnArray();
        turnArray();
        turnArray();
        left();
        turnArray();
    }

    private void turnArray(){
        Tile[][] rightTile = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[1].length; j++) {
                rightTile[j][gameTiles.length - i - 1] = gameTiles[i][j];
            }
        }
        gameTiles = rightTile;
    }

    private void saveState(Tile[][] oldTiles){
        Tile[][] savedGame = new Tile[oldTiles.length][oldTiles[1].length];
        for (int i = 0; i < oldTiles.length; i++) {
            for (int j = 0; j < oldTiles.length; j++) {
                Tile tile = new Tile();
                tile.value = oldTiles[i][j].value;
                savedGame[i][j] = tile;
            }
        }
        previousStates.push(savedGame);
        previousScores.push(score);
        isSaveNeeded = false;
    }

    public void rollback(){
        if (!previousStates.isEmpty()){
            gameTiles = previousStates.pop();
        }
        if (!previousScores.isEmpty()){
            score = previousScores.pop();
        }
    }
}
