package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Monster {
    private Texture pic;
    private float x;
    private float y;
    public Monster() {
        pic = new Texture(Gdx.files.internal("Images/monster.png"));
        x = 0;
        y = 0;
    }

    public Texture getPic() {
        return pic;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }
}
