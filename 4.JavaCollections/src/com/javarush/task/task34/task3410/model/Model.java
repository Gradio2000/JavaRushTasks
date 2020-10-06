package com.javarush.task.task34.task3410.model;

import com.javarush.task.task34.task3410.controller.EventListener;

import java.io.IOException;
import java.nio.file.Paths;

public class Model {
    public static final int FIELD_CELL_SIZE = 20;
    private EventListener eventListener;
    private GameObjects gameObjects;
    private int currentLevel = 60;
    private LevelLoader levelLoader = new LevelLoader(Paths.get("/Users/aleksejlaskin/Documents/JavaRushTasks/4.JavaCollections/src/com/javarush/task/task34/task3410/res/levels.txt"));

    public void setEventListener(EventListener eventListener){
        this.eventListener = eventListener;
    }

    public GameObjects getGameObjects(){
        return gameObjects;
    }

    public void restartLevel(int level) throws IOException {
        gameObjects = levelLoader.getLevel(level);
    }

    public void restart() throws IOException {
        restartLevel(currentLevel);
    }
    public void startNextLevel() throws IOException {
        currentLevel++;
        restartLevel(currentLevel);
    }
    public void move(Direction direction) {
        Player player = gameObjects.getPlayer();
        if (checkWallCollision(player, direction)){
            return;
        }
        if (checkBoxCollisionAndMoveIfAvailable(direction)){
            return;
        }
        switch (direction){
            case LEFT:
                player.move(-FIELD_CELL_SIZE, 0);
                break;
            case RIGHT:
                player.move(FIELD_CELL_SIZE, 0);
                break;
            case UP:
                player.move(0, -FIELD_CELL_SIZE);
                break;
            case DOWN:
                player.move(0, FIELD_CELL_SIZE);
                break;
        }
        checkCompletion();
    }

    public boolean checkWallCollision(CollisionObject gameObject, Direction direction){
        for (Wall wall : gameObjects.getWalls()){
            if (gameObject.isCollision(wall, direction)){
                return true;
            }
        }
        return false;
    }

    public boolean checkBoxCollisionAndMoveIfAvailable(Direction direction){
        Player player = gameObjects.getPlayer();
        for (Box box : gameObjects.getBoxes()){
            if (player.isCollision(box, direction)){
                if (checkWallCollision(box, direction)){
                    return true;
                }
                for (Box box2 : gameObjects.getBoxes()){
                    if (box.isCollision(box2, direction)){
                        return true;
                    }
                }
                switch (direction){
                    case LEFT:
                        box.move(-FIELD_CELL_SIZE, 0);
                        break;
                    case RIGHT:
                        box.move(FIELD_CELL_SIZE, 0);
                        break;
                    case UP:
                        box.move(0, -FIELD_CELL_SIZE);
                        break;
                    case DOWN:
                        box.move(0, FIELD_CELL_SIZE);
                        break;
                }
            }
        }
        return false;
    }

    public void checkCompletion(){
        int count = 0;
        for (Home home : gameObjects.getHomes()){
            for (Box box : gameObjects.getBoxes()){
                if (box.getX() == home.getX() && box.getY() == home.getY()){
                    count++;
                }
            }
        }
        if (count == gameObjects.getBoxes().size()){
            eventListener.levelCompleted(currentLevel);
        }
    }
}
