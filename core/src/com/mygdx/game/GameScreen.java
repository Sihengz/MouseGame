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

import java.util.Iterator;

public class GameScreen implements Screen {
	private Texture mouseImg;
	private Texture fruitImg;
	private Array<Rectangle> fruits;
	private long lastFruitTime;
	private Sound dingSound;
	private Music bgm;
	private OrthographicCamera camera;
	private Rectangle mouse;
	public SpriteBatch batch;

	

	public GameScreen(final Game game) {
		// wack
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 960, 540);

		// Images
		batch = new SpriteBatch();
		mouseImg = new Texture(Gdx.files.internal("mouse.png"));
		fruitImg = new Texture(Gdx.files.internal("fruit.png"));
		fruits = new Array<Rectangle>();
		spawnFruit();

		mouse = new Rectangle();
		mouse.x = 960 / 2 - 256 / 2;
		mouse.y = 560 / 2 - 256 / 2;
		mouse.width = 256;
		mouse.height = 256;

		// Sound
		bgm = Gdx.audio.newMusic(Gdx.files.internal("Memories_of_Spring.mp3"));
		bgm.setLooping(true);
		bgm.play();

		dingSound = Gdx.audio.newSound(Gdx.files.internal("ding.mp3"));


	}

	@Override
	public void render (float delta) {
		ScreenUtils.clear(1, 0, 0, 1);
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(mouseImg, mouse.x, mouse.y);
		for(Rectangle fruit: fruits) {
			batch.draw(fruitImg, fruit.x, fruit.y);
		}
		batch.end();
		for (Iterator<Rectangle> iter = fruits.iterator(); iter.hasNext(); ) {
			Rectangle raindrop = iter.next();
			if(raindrop.overlaps(mouse)) {
				dingSound.play();
				iter.remove();
			}
		}

		if(Gdx.input.isTouched()) {
			Vector3 touchPos = new Vector3();
			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touchPos);
			mouse.x = touchPos.x - 256 / 2;
			mouse.y = touchPos.y - 256 / 2;
		}

		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) mouse.x -= 200 * Gdx.graphics.getDeltaTime();
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) mouse.x += 200 * Gdx.graphics.getDeltaTime();
		if(Gdx.input.isKeyPressed(Input.Keys.UP)) mouse.y += 200 * Gdx.graphics.getDeltaTime();
		if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) mouse.y -= 200 * Gdx.graphics.getDeltaTime();



		if(TimeUtils.nanoTime() - lastFruitTime > 1000000000) spawnFruit();
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
		fruitImg.dispose();
		mouseImg.dispose();
		dingSound.dispose();
		bgm.dispose();
		batch.dispose();
	}

	private void spawnFruit() {
		Rectangle fruit = new Rectangle();
		fruit.x = MathUtils.random(0, 800-50);
		fruit.y = MathUtils.random(0, 640-50);
		fruit.width = 50;
		fruit.height = 50;
		fruits.add(fruit);
		lastFruitTime = TimeUtils.nanoTime();
	}

}
