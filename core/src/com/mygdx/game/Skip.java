package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Skip {
	SpriteBatch batch;

	Texture num0,num1,num2,num3,num4,num5,skipButton;

	public static int times = 1;

	public Skip() {
		batch = new SpriteBatch();

		num0 = new Texture("number_0.png");
		num1 = new Texture("number_1.png");
		num2 = new Texture("number_2.png");
		num3 = new Texture("number_3.png");
		num4 = new Texture("number_4.png");
		num5 = new Texture("number_5.png");
		skipButton = new Texture("skip.png");
	}

	public void setNewSkip() {
		times = 1;
	}

	public void useSkip() {
		times--;
	}

	public void checkPoint() {
		times++;
	}

	public int getSkip() {
		return times;
	}

	public boolean canSkip() {
		return times>0;
	}

	public void renderSkip() {
		batch.begin();
		batch.draw(skipButton, 180 + 700, 20);
		batch.end();
		if (getSkip() == 5) {
			batch.begin();
			batch.draw(num5, 180 + 600, 25);
			batch.end();
		}

		if (getSkip() == 4) {
			batch.begin();
			batch.draw(num4, 180 + 600, 25);
			batch.end();
		}

		if (getSkip() == 3) {
			batch.begin();
			batch.draw(num3, 180 + 600, 25);
			batch.end();
		}

		if(getSkip() == 2) {
			batch.begin();
			batch.draw(num2, 180 + 600, 25);
			batch.end();
		}

		if(getSkip() == 1) {
			batch.begin();
			batch.draw(num1, 180 + 600, 25);
			batch.end();
		}

		if(getSkip() == 0) {
			batch.begin();
			batch.draw(num0, 180 + 600, 25);
			batch.end();
		}
	}
}
