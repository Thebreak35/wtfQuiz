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
	SoundFx sound;
	
	public Fail(Game game)
	{
		this.game = game;
		batch = new SpriteBatch();
		bg = new Texture("fail.png");
		lives = new Lives();
		skip = new Skip();
		sound = new SoundFx();
		
		sound.playSoundSad(1);
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
			sound.playSoundSad(0);
			lives.setNewLives();
			skip.setNewSkip();
//			this.dispose();
			dispose();
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
