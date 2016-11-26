package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Question_10 extends ScreenAdapter{
	Game game;
	SpriteBatch batch;
	Lives lives;
	Texture question_10;
	Skip skip;
	SoundFx sound;

	Rectangle ans1,ans2,ans3,ans4;
	Vector2 touchPoint;

	public Question_10(Game game) {
		this.game = game;
		batch = new SpriteBatch();
		question_10 = new Texture("question_10.png");
		lives = new Lives();
		skip = new Skip();
		sound = new SoundFx();

		touchPoint = new Vector2();
		ans1 = new Rectangle( 20, 720 - 458 + 193, 190 - 20, 608 - 458);
	}

	@Override
	public void render(float delta) {
		update();

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		render();
	}

	private void update() {
		if (Gdx.input.justTouched()) {
			touchPoint.x = Gdx.input.getX();
			touchPoint.y = Gdx.input.getY();

			if (ans1.contains(touchPoint)) {
				sound.playSoundCorrect();
				skip.checkPoint();
				game.setScreen(new Question_11(game));
				this.dispose();
			} else {
				lives.wrong();
				sound.playSoundNope();
			}
		}

		if (!lives.isLive()) {
			game.setScreen(new Fail(game));
			this.dispose();
		}
	}

	private void render() {
		batch.begin();
		batch.draw(question_10, 0, 0);
		batch.end();
		lives.renderLives();
	}
}
