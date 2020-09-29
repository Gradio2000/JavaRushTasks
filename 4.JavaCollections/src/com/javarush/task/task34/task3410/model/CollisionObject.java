package com.javarush.task.task34.task3410.model;

public abstract class CollisionObject extends GameObject{
    public CollisionObject(int x, int y){
        super(x, y);
    }
    public boolean isCollision(GameObject gameObject, Direction direction) {
        switch (direction) {
            case UP:
                return this.getY() - Model.FIELD_CELL_SIZE == gameObject.getY() && this.getX() == gameObject.getX();
            case DOWN:
                return this.getY() + Model.FIELD_CELL_SIZE == gameObject.getY() && this.getX() == gameObject.getX();
            case LEFT:
                return this.getX() - Model.FIELD_CELL_SIZE == gameObject.getX() && this.getY() == gameObject.getY();
            case RIGHT:
                return this.getX() + Model.FIELD_CELL_SIZE == gameObject.getX() && this.getY() == gameObject.getY();
        }
        return true;
    }
}
