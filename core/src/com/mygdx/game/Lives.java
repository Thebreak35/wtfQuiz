package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Lives {
	SpriteBatch batch;

	Texture num1,num2,num3,num4,num5;
	
	public static int hp = 5;
	
	public Lives()
	{
		batch = new SpriteBatch();
		
		num1 = new Texture("number_1.png");
		num2 = new Texture("number_2.png");
		num3 = new Texture("number_3.png");
		num4 = new Texture("number_4.png");
		num5 = new Texture("number_5.png");
	}
	public void setNewLives()
	{
		hp = 5;
	}
	
	public void wrong()
	{
		hp--;
	}
	
	public int getLives()
	{
		return hp;
	}
	
	public boolean isLive()
	{
		return hp>0;
	}
	
	public void renderLives()
	{	
		if(getLives() == 5)
		{
			batch.begin();
			batch.draw(num5, 180, 25);
			batch.end();
		}
		if(getLives() == 4)
		{
			batch.begin();
			batch.draw(num4, 180, 25);
			batch.end();
		}
		if(getLives() == 3)
		{
			batch.begin();
			batch.draw(num3, 180, 25);
			batch.end();
		}
		if(getLives() == 2)
		{
			batch.begin();
			batch.draw(num2, 180, 25);
			batch.end();
		}
		if(getLives() == 1)
		{
			batch.begin();
			batch.draw(num1, 180, 25);
			batch.end();
		}
	}
}
