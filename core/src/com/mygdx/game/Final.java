package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Final extends ScreenAdapter {
	Game game;
	SpriteBatch batch;
	Texture finalPic;
	SoundFx sound;
	
	Rectangle ans3,ans4;
	Vector2 touchPoint;
	
	public Final(Game game) 
	{
		this.game = game;
		batch = new SpriteBatch();
		finalPic = new Texture("final.png");
		sound = new SoundFx();
		
		touchPoint = new Vector2();
		ans3 = new Rectangle( 130, 400 - 120 + 175, 300, 120);
		ans4 = new Rectangle( 625, 400 - 120 + 175, 300, 120);
		
		sound.playApplauseSound();
		
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
		if( Gdx.input.justTouched() ) {
			touchPoint.x = Gdx.input.getX();
			touchPoint.y = Gdx.input.getY();
			
//			System.out.println(touchPoint);
			
			
			if( ans3.contains(touchPoint) ) {
				sound.playSoundCorrect();
				this.dispose();
				game.setScreen(new MainMenuScreen(game));
			}
			
			if( ans4.contains(touchPoint) ) {
				sound.playSoundNope();
				this.dispose();
				game.setScreen(new MainMenuScreen(game));
			}
			
//			System.out.println(lives.hp);
//			System.out.println(lives.getLives());
//			System.out.println(lives.isLive());
		}
	}
	
	private void render() {
		batch.begin();
		batch.draw(finalPic, 0, 0);
		batch.end();
	}
}
