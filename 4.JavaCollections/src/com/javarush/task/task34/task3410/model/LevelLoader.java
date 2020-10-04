package com.javarush.task.task34.task3410.model;

import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class LevelLoader {
    public LevelLoader(Path levels) {
    }

    public GameObjects getLevel(int level){
        Set<Wall> wallSet = new HashSet<>();
        Set<Home> homeSet = new HashSet<>();
        Set<Box> boxSet = new HashSet<>();

        wallSet.add(new Wall(100, 100));
        wallSet.add(new Wall(120, 100));
        wallSet.add(new Wall(140, 100));
        homeSet.add(new Home(30, 30));
        boxSet.add(new Box(50, 50));
        Player player = new Player(70, 70);

        return new GameObjects(wallSet, boxSet, homeSet, player);
    }
}
