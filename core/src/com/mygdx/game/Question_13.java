package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Question_13 extends ScreenAdapter{
	Game game;
	SpriteBatch batch;
	Lives lives;
	Texture question_13;
	Skip skip;
	SoundFx sound;

	Rectangle ans1,ans2,ans3,ans4,skipButton;
	Vector2 touchPoint;

	public Question_13(Game game) {
		this.game = game;
		batch = new SpriteBatch();
		question_13 = new Texture("question_13.png");
		lives = new Lives();
		skip = new Skip();
		sound = new SoundFx();

		touchPoint = new Vector2();
		ans1 = new Rectangle( 130, 400 - 120, 300, 120);
		ans2 = new Rectangle( 625, 400 - 120, 300, 120);
		ans3 = new Rectangle( 130, 400 - 120 + 175, 300, 120);
		ans4 = new Rectangle( 625, 400 - 120 + 175, 300, 120);
		skipButton = new Rectangle(180 + 700,720 - 60 - 20 ,150 ,60);
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
				sound.playSoundNope();
				lives.wrong();
			}

			if (ans2.contains(touchPoint)) {
				sound.playSoundNope();
				lives.wrong();
			}

			if (ans3.contains(touchPoint)) {
				sound.playSoundCorrect();
				game.setScreen(new Question_14(game));
				dispose();
			}

			if (ans4.contains(touchPoint)) {
				sound.playSoundNope();
				lives.wrong();
			}

			if (skipButton.contains(touchPoint) && skip.canSkip()) {
				sound.playSkipSound();
				skip.useSkip();
				game.setScreen(new Question_14(game));
				dispose();
			}
		}

		if (!lives.isLive()) {
			game.setScreen(new Fail(game));
			dispose();
		}
	}

	private void render() {
		batch.begin();
		batch.draw(question_13, 0, 0);
		batch.end();
		lives.renderLives();
		skip.renderSkip();
	}
}
