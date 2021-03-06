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
		//M�todo para procesamiento auxiliar 
	}
	
	public void Game()
	{
		boolean lose = false;
		int fps = TetrisConstants.FPS;
		long frametime = 1000/fps;
		long start = System.currentTimeMillis(); //Tiempo inicial para conteo de frame
		setResetStatus(false);
		//Se indica que ya inicio el juego.... y que no debe reiniciarse a menos que se lo indique explicitamente
		
		
		onCreateResources(); //Cargo los recursos necesarios para el juego
	
		while(!lose)
		{
	
			if(isReset()) //Si se activa el reset, significa que se debe terminar el juego actual!
				return;
			
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
