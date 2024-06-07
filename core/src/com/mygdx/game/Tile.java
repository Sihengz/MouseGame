package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Tile {
    private boolean hasTower;
    private boolean isLane;
    private Texture pic;
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
    }

    public Texture getPic() {
        return pic;
    }
}
