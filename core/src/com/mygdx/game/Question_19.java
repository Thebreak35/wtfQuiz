package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Question_19 extends ScreenAdapter {
	Game game;
	SpriteBatch batch;
	Texture question_19;
	Lives lives;
	Skip skip;
	SoundFx sound;
	
	Rectangle ans1,ans2,ans3,ans4,skipButton;
	Vector2 touchPoint;
	private static int n = 0;
	public Question_19(Game game) 
	{
		this.game = game;
		batch = new SpriteBatch();
		question_19 = new Texture("question_19.png");
		lives = new Lives();
		skip = new Skip();
		sound = new SoundFx();
		
		touchPoint = new Vector2();
		ans1 = new Rectangle( 130, 400 - 120, 300, 120);
		ans2 = new Rectangle( 625, 400 - 120, 300, 120);
		ans3 = new Rectangle( 130, 400 - 120 + 175, 300, 120);
		ans4 = new Rectangle( 625, 400 - 120 + 175, 300, 120);
		skipButton = new Rectangle(180 + 700,720 - 60 - 20 ,150 ,60);
		
		resetN();
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
			
			pressColor(n);
			System.out.println(n);
//			System.out.println(touchPoint);		
			
//			if( skipButton.contains(touchPoint) && skip.canSkip() ) {
//				sound.playSkipSound();
//				skip.useSkip();
//				this.dispose();
//				game.setScreen(new Question_2(game));
//			}
			
//			System.out.println(lives.hp);
//			System.out.println(lives.getLives());
//			System.out.println(lives.isLive());
		}
		
		if( !lives.isLive() ) {
			this.dispose();
			game.setScreen(new Fail(game));
		}
	}
	
	private void render() {
		batch.begin();
		batch.draw(question_19, 0, 0);
		batch.end();
		lives.renderLives();
//		skip.renderSkip();
	}
	
	private boolean ans1IsCorrect() {
		if( ans1.contains(touchPoint) ) {
			sound.playSoundCorrect();
			return true;
		} else {
			resetN();
			sound.playSoundNope();
			lives.wrong();
			return false;
		}
	}
	
	private boolean ans2IsCorrect() {
		if( ans2.contains(touchPoint) ) {
			sound.playSoundCorrect();
			return true;
		} else {
			resetN();
			sound.playSoundNope();
			lives.wrong();
			return false;
		}
	}
	
	private boolean ans3IsCorrect() {
		if( ans3.contains(touchPoint) ) {
			sound.playSoundCorrect();
			return true;
		} else {
			resetN();
			sound.playSoundNope();
			lives.wrong();
			return false;
		}
	}
	
	private boolean ans4IsCorrect() {
		if( ans4.contains(touchPoint) ) {
			sound.playSoundCorrect();
			return true;
		} else {
			resetN();
			sound.playSoundNope();
			lives.wrong();
			return false;
		}
	}
	
	private void pressColor(int n) {
		if(n == 0 && ans2IsCorrect()) {
			countN();
		}
		if(n == 1 && ans1IsCorrect()) {
			countN();
		}
		if(n == 2 && ans3IsCorrect()) {
			countN();
		}
		if(n == 3 && ans4IsCorrect()) {
			game.setScreen(new Final(game));
		}
	}
	
	private void countN() {
		n++;
	}
	
	private void resetN() {
		n = 0;
	}
}
