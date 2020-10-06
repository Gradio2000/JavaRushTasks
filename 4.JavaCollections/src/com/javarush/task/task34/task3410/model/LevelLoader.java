package com.javarush.task.task34.task3410.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class LevelLoader {
    Path levels;

    public LevelLoader(Path levels) {
        this.levels = levels;
    }

    public GameObjects getLevel(int level) throws IOException {
        Set<Wall> wallSet = new HashSet<>();
        Set<Home> homeSet = new HashSet<>();
        Set<Box> boxSet = new HashSet<>();
        Player player = null;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(String.valueOf(levels)));
        String line;
        boolean ourLevel = false;
        boolean start = false;
        int x = Model.FIELD_CELL_SIZE / 2;
        int y = Model.FIELD_CELL_SIZE / 2;
        while ((line = bufferedReader.readLine()) != null){
            if (start){
                if (line.isEmpty()){
                    start = false;
                    continue;
                }
                char[] chars = line.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    switch (chars[i]){
                        case ' ':
                            x = x + Model.FIELD_CELL_SIZE;
                            break;
                        case 'X':
                            wallSet.add(new Wall(x, y));
                            x = x + Model.FIELD_CELL_SIZE;
                            break;
                        case '*':
                            boxSet.add(new Box(x, y));
                            x = x + Model.FIELD_CELL_SIZE;
                            break;
                        case '.':
                            homeSet.add(new Home(x, y));
                            x = x + Model.FIELD_CELL_SIZE;
                            break;
                        case '@':
                            player = new Player(x, y);
                            x = x + Model.FIELD_CELL_SIZE;
                            break;
                        case '&':
                            boxSet.add(new Box(x, y));
                            homeSet.add(new Home(x, y));
                            x = x + Model.FIELD_CELL_SIZE;
                            break;
                    }

                }
                y = y + Model.FIELD_CELL_SIZE;
                x = Model.FIELD_CELL_SIZE / 2;

                continue;
            }


            if (ourLevel && line.isEmpty()){
                start = true;
                ourLevel = false;
                continue;
            }

            if (line.contains("Maze")){
                String[] mass = line.split(" ");

                if (level > 60){
                    level = level % 60;
                }
                if (Integer.parseInt(mass[1]) == level){
                    ourLevel = true;
                    continue;
                }
            }
        }
        return new GameObjects(wallSet, boxSet, homeSet, player);
    }
}
