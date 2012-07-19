package com.daxapp.tetris.core;

public abstract class BaseGameLogic
{
	protected abstract void onCreateResources();
	protected abstract void onInputEvent();
	protected abstract boolean onGameLoopUpdate(); 
	protected abstract void onGraphicsUpdate(); //En un Thread diferente!! (TODO de momento de puede obviar)!
	protected abstract void onSoundPlay();

	public void Game()
	{
		boolean lose = false;
		onCreateResources();
		while(!lose)
		{
			onInputEvent();
			lose = onGameLoopUpdate();
			onGraphicsUpdate(); //Correr en otro thread!!
			onSoundPlay();
		}
	}

	
	
}
