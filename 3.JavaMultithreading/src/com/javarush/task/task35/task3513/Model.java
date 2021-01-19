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


//        Tile tile1 = new Tile();
//        Tile tile2 = new Tile();
//        Tile tile3 = new Tile();
//        Tile tile4 = new Tile();
//        Tile tile5 = new Tile();
//        Tile tile6 = new Tile();
//        Tile tile7 = new Tile();
//        Tile tile8 = new Tile();
//        Tile tile9 = new Tile();
//        Tile tile10 = new Tile();
//        Tile tile11 = new Tile();
//        Tile tile12 = new Tile();
//        Tile tile13 = new Tile();
//        Tile tile14 = new Tile();
//        Tile tile15 = new Tile();
//        Tile tile16 = new Tile();
//
//        tile1.value = 1;
//        tile2.value = 0;
//        tile3.value = 0;
//        tile4.value = 4;
//
//        tile5.value = 4;
//        tile6.value = 4;
//        tile7.value = 0;
//        tile8.value = 3;
//
//        tile9.value = 0;
//        tile10.value = 3;
//        tile11.value = 3;
//        tile12.value = 1;
//
//        tile13.value = 1;
//        tile14.value = 1;
//        tile15.value = 0;
//        tile16.value = 1;
//        gameTiles = new Tile[][]{
//                {tile1, tile2, tile3, tile4},
//                {tile5, tile6, tile7, tile8},
//                {tile9, tile10, tile11, tile12},
//                {tile13, tile14, tile15, tile16}};


        //--------------
//        for (int i = 0; i < gameTiles.length; i++) {
//            for (int j = 0; j < gameTiles[1].length; j++) {
//                System.out.print(gameTiles[i][j].value);
//            }
//            System.out.println();
//        }
//        //---------------
        System.out.println("-------------");

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

    private void resetGameTiles(){
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
        //--------------
//        for (int i = 0; i < tiles.length; i++) {
//            for (int j = 0; j < gameTiles[1].length; j++) {
//                System.out.print(gameTiles[i][j].value);
//            }
//            System.out.println();
//        }
        //---------------


    }
}
