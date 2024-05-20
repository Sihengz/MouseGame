package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.math.Rectangle;

public class MyGdxGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture img;
	private Sound explosion;
	private Music bgm;
	private OrthographicCamera camera;
	private Rectangle mouse;

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("mouse.png");
		mouse = new Rectangle();
		mouse.x = 960 / 2 - 64 / 2;
		mouse.y = 20;
		mouse.width = 256;
		mouse.height = 256;
		explosion = Gdx.audio.newSound(Gdx.files.internal("explosion.mp3"));
		bgm = Gdx.audio.newMusic(Gdx.files.internal("Memories_of_Spring.mp3"));
		bgm.setLooping(true);
		bgm.play();
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(img, mouse.x, mouse.y);
		batch.end();



	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
