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
			//TODO agregar el tiempo de frame para tomar los inputs, en ese tiempo de frame,
			//voy incrementando un contador, q al llegar a cierto valor x, hace el paso tipo
			//gravedad por defecto, este paso fuera del if del frame
			onInputEvent();
			lose = onGameLoopUpdate();
			onGraphicsUpdate(); //Correr en otro thread!!
			onSoundPlay();
		}
	}

}
