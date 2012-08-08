package com.daxapp.tetris.core.graphics;

import com.daxapp.tetris.constants.TetrisConstants;

public abstract class BaseGameLogic extends GraphicsInterface
{
	protected abstract void onCreateResources();
	protected abstract void onInputEvent();
	protected abstract boolean onGameLoopUpdate(); 
	protected abstract void onGraphicsUpdate();
	protected abstract void onSoundPlay();
	
	protected void auxiliarProc()
	{
		//Método para procesamiento auxiliar 
	}
	
	public void Game()
	{
		boolean lose = false;
		int fps = TetrisConstants.FPS;
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
