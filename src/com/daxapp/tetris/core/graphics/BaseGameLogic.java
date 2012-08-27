package com.daxapp.tetris.core.graphics;

import com.daxapp.tetris.constants.TetrisConstants;
import com.daxapp.tetris.gui.GraphicsInterface;

@SuppressWarnings("serial")
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
		reset = false;
		//Se indica que ya inicio el juego.... y que no debe reiniciarse a menos que se lo indique explicitamente
		
		
		onCreateResources(); //Cargo los recursos necesarios para el juego
	
		while(!lose)
		{
			if(reset) //La variable reset puede ser modificada para indicar que debe reiniciar el juego
			{
				return;
			}
			
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
