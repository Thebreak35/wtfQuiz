package com.mygdx.game;

import java.sql.Time;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public class SoundFx {
	
	Sound correctSound;
	Sound nopeSound;
	Sound sadSound;
	Sound introSound;
	Sound skipSound;
	Sound BGMusic;
	Sound applause;
	
	
	public SoundFx() {
		correctSound = Gdx.audio.newSound(Gdx.files.internal("correct.mp3"));
		nopeSound = Gdx.audio.newSound(Gdx.files.internal("nope.mp3"));
		sadSound = Gdx.audio.newSound(Gdx.files.internal("sad.mp3"));
		introSound = Gdx.audio.newSound(Gdx.files.internal("intro.mp3"));
		skipSound = Gdx.audio.newSound(Gdx.files.internal("skip.mp3"));
		applause = Gdx.audio.newSound(Gdx.files.internal("applause.mp3"));
//		BGMusic = Gdx.audio.newSound(Gdx.files.internal("bgmusic.mp3"));
	}
	
	public void playSoundCorrect() {
		correctSound.play();
	}
	
	public void playSoundNope(){
		nopeSound.play((float)1.0,(float)1.3,(float)0);
	}
	
	public void playSoundSad(int inp) {
		if(inp == 1) {
			sadSound.play();
		}
		else {
			sadSound.stop();
		}
	}
	
	public void playIntroSound(int inp) {
		if(inp == 1) {
			introSound.play();
		}
		else {
			introSound.stop();
		}
	}
	
	public void playSkipSound() {
		skipSound.play();
	}
	
	public void playApplauseSound() {
		applause.play();
	}
	
//	public void playBGMusic(int inp) {
//		if(inp == 1) {
//			BGMusic.loop();
//		}
//		else {
//			BGMusic.stop();
//			BGMusic.dispose();
//		}
//		
//	}
}
