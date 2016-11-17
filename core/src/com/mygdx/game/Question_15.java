package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Question_15 extends ScreenAdapter{
	Game game;
	SpriteBatch batch;
	Texture question_15;
	Lives lives;
	Skip skip;
	SoundFx sound;
	long tStart = System.currentTimeMillis();
	
	Rectangle ans1,ans2,ans3,ans4,skipButton;
	Vector2 touchPoint;
	
	public Question_15(Game game) {
		this.game = game;
		batch = new SpriteBatch();
		question_15 = new Texture("question_15.png");
		lives = new Lives();
		skip = new Skip();
		sound = new SoundFx();
		
		touchPoint = new Vector2();
		ans1 = new Rectangle( 165, 720 - 360 - 275 , 440-162, 383 - 84);
		ans2 = new Rectangle( 650, 720 - 360 - 290, 940 - 651, 393 - 73);
//		ans3 = new Rectangle( 130, 400 - 120 + 175, 300, 120);
//		ans4 = new Rectangle( 625, 400 - 120 + 175, 300, 120);
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
		long tEnd = System.currentTimeMillis();
		if( ( tEnd - tStart ) / 1000 > 10) {
			changeQuestion();
			if(( tEnd - tStart ) / 1000 > 12) {
				sound.playSoundCorrect();
				game.setScreen(new Question_16(game));
				dispose();
			}
		}
		if(Gdx.input.justTouched())
		{
			touchPoint.x = Gdx.input.getX();
			touchPoint.y = Gdx.input.getY();
			
//			System.out.println(touchPoint);
			
			
			if(ans1.contains(touchPoint))
			{
				sound.playSoundNope();
				lives.wrong();
			}
			
			if(ans2.contains(touchPoint))
			{
				sound.playSoundNope();
				lives.wrong();
			}
			
			if(skipButton.contains(touchPoint) && skip.canSkip())
			{
				sound.playSkipSound();
				skip.useSkip();
				game.setScreen(new Question_16(game));
				dispose();
			}
		}
	}
	
	private void render() {
		batch.begin();
		batch.draw(question_15, 0, 0);
		batch.end();
		lives.renderLives();
		skip.renderSkip();
	}
	
	private void changeQuestion() {
		question_15 = new Texture("question_15_2.png");
	}
}
