package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Fail extends ScreenAdapter{
	Game game;
	Texture bg;
	SpriteBatch batch;
	Lives lives;
	Skip skip;
	
	public Fail(Game game)
	{
		this.game = game;
		batch = new SpriteBatch();
		bg = new Texture("fail.png");
		lives = new Lives();
		skip = new Skip();
	}
	
	@Override
	public void render(float delta)
	{
		update();
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	
		render();
	}
	
	private void update()
	{
		if(Gdx.input.justTouched())
		{
			lives.setNewLives();
			skip.setNewSkip();
			game.setScreen(new MainMenuScreen(game));
		}
	}

	private void render()
	{
		batch.begin();
		batch.draw(bg, 0, 0);
		batch.end();
	}
}
