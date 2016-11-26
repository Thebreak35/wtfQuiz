package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainMenuScreen extends ScreenAdapter{

	Game game;
	SpriteBatch batch;

	MainMenuWorld mainMenuWorld;
	MainMenuRender mainMenuRender;

	public MainMenuScreen(Game game) {
		this.game = game;
		batch = game.batch;
		mainMenuWorld = new MainMenuWorld();
		mainMenuRender = new MainMenuRender();
	}

	@Override
	public void render(float delta) {
		mainMenuWorld.update();

		if(mainMenuWorld.isTouchStart) {
			this.dispose();
			game.setScreen(new Question_1(game));
		}

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		mainMenuRender.render();
	}
}
