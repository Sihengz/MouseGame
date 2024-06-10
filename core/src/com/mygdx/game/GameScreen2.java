package com.mygdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.TimeUtils;

import java.util.ArrayList;
import java.util.Iterator;

public class GameScreen2 implements Screen{
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private Tile[][] tiles;
    private ArrayList<String> path;
    private Monster monster;
    public GameScreen2(final Game game) {
        // wack
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 960, 540);
        batch = new SpriteBatch();
        this.tiles = new Tile[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                tiles[i][j] = new Tile();
            }
        }
        monster = new Monster();
        monster.setX((960 - 540) / 2);
        int x = (960 - 540) / 2;
        int y = 0;
        for (Tile[] row:
                tiles) {
            for (Tile t:
                    row) {
                t.setX(x);
                t.setY(y);
                x += 540 / 10;
            }
            y += 540 / 10;
            x = (960 - 540) / 2;
        }
        path = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            path.add("right");
        }
        for (int i = 0; i < 5; i++) {
            path.add("left");
            path.add("down");

        }
        for (int i = 0; i < 10; i++) {
            path.add("right");
        }
        x = 0;
        y = 0;
        for (int i = 0; i < path.size(); i++) {
            tiles[x][y].setLane(true);
            if (path.get(i).equals("right")) {
                x++;
            }
            if (path.get(i).equals("down")) {
                y++;
            }
            if (path.get(i).equals("left")) {
                x--;
            }
        }
    }


    @Override
    public void show() {

    }

    @Override
    public void render (float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        for (Tile[] row:
             tiles) {
            for (Tile t:
            row) {
                batch.draw(t.getPic(), t.getX(), t.getY());
            }
        }
        batch.draw(monster.getPic(), monster.getX(), monster.getY());
        ArrayList<String> tempPath = new ArrayList<>(path);
        if (tempPath.get(0).equals("right")) {
            monster.setY(monster.getY() + 100 * Gdx.graphics.getDeltaTime());
        }

        batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
