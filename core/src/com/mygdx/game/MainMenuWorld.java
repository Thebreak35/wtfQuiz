package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class MainMenuWorld {
	Game game;
	Vector2 touchPoint;
	Rectangle start;
	
	public static boolean isTouchStart;
	
	public MainMenuWorld()
	{
		touchPoint = new Vector2();
		start = new Rectangle( 375, 720 - 320 - 120, 300 ,120 );
		isTouchStart = false;
	}
	
	public void update()
	{
		if(Gdx.input.justTouched())
		{
			touchPoint.x = Gdx.input.getX();
			touchPoint.y = Gdx.input.getY();
			if(start.contains(touchPoint))
			{
				isTouchStart = true;
			}
		}
	}
}
