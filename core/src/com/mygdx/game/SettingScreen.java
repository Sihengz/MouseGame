package com.mygdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.TimeUtils;

import java.util.Iterator;

public class SettingScreen implements Screen {
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private Music bgm;
    private Stage stage;


    public SettingScreen(final Game game) {
        // wack
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 960, 540);

        // Images
        batch = new SpriteBatch();

        // Sound
        bgm = Gdx.audio.newMusic(Gdx.files.internal("Music/Memories_of_Spring.mp3"));
        bgm.setLooping(true);
        bgm.play();

        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        Skin skin = new Skin(Gdx.files.internal("uiskin.json"));
        TextArea volume = new TextArea("VOLUME", skin);
        Slider slider = new Slider(0, 100, 1, false, skin);
        slider.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                bgm.setVolume(slider.getValue() / 100.0f);
            }
        });

        Table table = new Table();
        table.setFillParent(true);
        table.add(volume);
        table.add(slider);
        stage.addActor(table);


    }

    @Override
    public void render (float delta) {
        ScreenUtils.clear(0.2f, 0.2f, 0.2f, 0.2f);
        camera.update();
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.end();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void show() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }
    @Override
    public void dispose () {
        bgm.dispose();
        batch.dispose();
    }

}
