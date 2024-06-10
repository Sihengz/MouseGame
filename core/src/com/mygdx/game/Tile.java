package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.awt.*;

public class Tile {
    private boolean hasTower;
    private boolean isLane;
    private Texture pic;
    private int x;
    private int y;
    public Tile() {
        hasTower = false;
        isLane = false;
        pic = new Texture(Gdx.files.internal("Images/grass.png"));
    }
    public boolean getLane() {
        return isLane;
    }

    public boolean isHasTower() {
        return hasTower;
    }

    public void setLane(boolean isLane) {
        this.isLane = isLane;
        pic = new Texture(Gdx.files.internal("Images/path.png"));
    }

    public Texture getPic() {
        return pic;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
