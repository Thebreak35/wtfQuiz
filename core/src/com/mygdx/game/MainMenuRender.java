package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainMenuRender {

	SpriteBatch batch;
	
	Texture bgImg;
	Texture startImg;
	
	public MainMenuRender()
	{
		batch = new SpriteBatch();
		bgImg = new Texture("bg.png");
		startImg = new Texture("start.png");
	}
	
	public void render()
	{
		renderBg();
		renderStart();
	}
	
	private void renderBg()
	{

		batch.begin();
		batch.draw(bgImg, 0, 0);
		batch.end();
	}
	private void renderStart()
	{
		batch.begin();
		batch.draw(startImg, 375, 320);
		batch.end();
	}
}
