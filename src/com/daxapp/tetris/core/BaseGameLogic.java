package com.daxapp.tetris.core;



public abstract class BaseGameLogic
{
	protected abstract void onCreateResources();
	protected abstract void onInputEvent();
	protected abstract boolean onGameLoopUpdate(); 
	protected abstract void onGraphicsUpdate(); //En un Thread diferente!! (TODO de momento de puede obviar)!
	protected abstract void onSoundPlay();
	protected abstract int getFPS();
	
	protected void auxiliarProc()
	{
		//Método para procesamiento auxiliar s
	}
	
	public void Game()
	{
		boolean lose = false;
		int fps = getFPS();
		long frametime = 1000/fps;
		long start = System.currentTimeMillis(); //Tiempo inicial para conteo de frame
	
		onCreateResources(); //Cargo los recursos necesarios para el juego
	
		while(!lose)
		{
			auxiliarProc();
			if(System.currentTimeMillis() - start >= frametime)
			{
				onInputEvent();
				lose = onGameLoopUpdate();
				onGraphicsUpdate(); //Correr en otro thread!!
				onSoundPlay();
				
				start = System.currentTimeMillis();
			}
		}
	}

}
