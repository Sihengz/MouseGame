package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.ScreenUtils;

import com.mygdx.game.Mouse;

public class MainMenuScreen implements Screen {

    final Mouse game;
    private Texture natureImg;
    private Stage stage;
    private Table table;

    OrthographicCamera camera;

    public MainMenuScreen(final Mouse game) {
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 960, 540);
        natureImg = new Texture(Gdx.files.internal("Images/nature.png"));
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        Skin skin = new Skin(Gdx.files.internal("uiskin.json"));
        TextButton start = new TextButton("START", skin);
        start.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new GameScreen(game));
                dispose();
            }
        });

        TextButton setting = new TextButton("SETTING", skin);
        setting.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new SettingScreen(game));
                dispose();
            }
        });

        TextButton screen2 = new TextButton("thingy", skin);
        screen2.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new GameScreen2(game));
                game.dispose();
            }
        });

        table = new Table();
        table.setFillParent(true);
        // table.setDebug(true);
        table.add(start).size(100, 50).pad(0, 250, 0, 0);
        table.row();
        table.add(setting).size(100, 50).pad(0, 250, 0, 0);
        table.row();
        table.add(screen2).size(100, 50).pad(0, 250, 0, 0);
        table.row();

        stage.addActor(table);

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.2f, 1);

        camera.update();
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        game.batch.draw(natureImg, 960 / 2 - 256 / 2 - 100, 540 / 2 - 256 / 2);
        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
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