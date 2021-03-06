package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Question_18 extends ScreenAdapter{
	Game game;
	SpriteBatch batch;
	Texture question_18,question_18_2;
	Lives lives;
	Skip skip;
	SoundFx sound;
	private static int n = 1;

	Rectangle ans1,ans2,ans3,ans4,skipButton,trueAnswer;
	Vector2 touchPoint;

	public Question_18(Game game)  {
		this.game = game;
		batch = new SpriteBatch();
		question_18 = new Texture("question_18.png");
		question_18_2 = new Texture("question_18_2.png");
		lives = new Lives();
		skip = new Skip();
		sound = new SoundFx();

		touchPoint = new Vector2();
		ans1 = new Rectangle( 130, 400 - 120, 300, 120);
		ans2 = new Rectangle( 625, 400 - 120, 300, 120);
		ans3 = new Rectangle( 130, 400 - 120 + 175, 300, 120);
		ans4 = new Rectangle( 625, 400 - 120 + 175, 300, 120);
		skipButton = new Rectangle(180 + 700,720 - 60 - 20 ,150 ,60);
		trueAnswer = new Rectangle(220, 170 - 7, 50, 14);
	}

	@Override
	public void render(float delta) {
		update();

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		render();
	}

	private void update() {
		touchPoint.x = Gdx.input.getX();
		touchPoint.y = Gdx.input.getY();

		if (trueAnswer.contains(touchPoint)) {
			n = 0;
		} else {
			n = 1;
		}

		if (Gdx.input.justTouched()) {
			if (trueAnswer.contains(touchPoint)) {
				sound.playSoundCorrect();
				game.setScreen( new Question_19(game) );
				dispose();
			}
		}

		if (!lives.isLive()) {
			game.setScreen(new Fail(game));
			dispose();
		}
	}

	private void render() {
		changPicture(n);
		lives.renderLives();
	}

	private void changPicture(int inp) {
		if (inp == 0) {
			batch.begin();
			batch.draw(question_18_2, 0, 0);
			batch.end();
		} else {
			batch.begin();
			batch.draw(question_18, 0, 0);
			batch.end();
		}
	}
}
