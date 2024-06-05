package com.mygdx.game;

public class Tile {
    private boolean hasTower;
    private boolean isLane;
    public Tile() {
        hasTower = false;
        isLane = false;
    }
    public boolean getLane() {
        return isLane;
    }

    public boolean isHasTower() {
        return hasTower;
    }

    public void setLane(boolean isLane) {
        this.isLane = isLane;
    }

}
