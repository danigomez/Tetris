package com.daxapp.tetris.core;

import java.awt.event.KeyEvent;

import com.daxapp.tetris.constants.TetrisConstants;
import com.daxapp.tetris.input.listener.InputHandler;
import com.daxapp.tetris.pool.TetriminoPool;

public class TetrisLogic extends BaseGameLogic
{
	//TODO arrancar la parte grafica con Swing, luego veo otra! :D
	private GameBoard tetrisBoard;
	private TetriminoPool pool;
	private InputHandler handler;
	
	private int gravityStepCounter;

	protected int getFPS()
	{
		return TetrisConstants.FPS;
	}
	
	protected void onCreateResources()
	{
		pool = new TetriminoPool();
		tetrisBoard = new GameBoard(TetrisConstants.TETRIS_ROW,TetrisConstants.TETRIS_COL);
		handler = new InputHandler();
		gravityStepCounter = 0;
		addKeyListener(handler); //TODO hacer una ventana Swing para mostrar el tetris!!

	}
	
	
	protected void auxiliarProc()
	{
		if(gravityStepCounter == TetrisConstants.HOLD_TIME_TO_STEP)
		{
			tetrisBoard.stepDownTetrimino();
			gravityStepCounter = 0;
		}
		
	}

	protected void onInputEvent()
	{
		//TODO Que las teclas y sus acciones se levanten del archivo de configuracion
		switch(handler.getKeyPressed())
		{
			case KeyEvent.VK_UP:
				tetrisBoard.rotateTetrimino();
				break;
				
			case KeyEvent.VK_LEFT:
				tetrisBoard.stepLeftTetrimino();
				break;
				
			case KeyEvent.VK_RIGHT:
				tetrisBoard.stepRightTetrimino();
				break;
				
			case KeyEvent.VK_DOWN:
				tetrisBoard.stepDownTetrimino();
				break;
				
		}
	}

	protected boolean onGameLoopUpdate()
	{
		if(!tetrisBoard.isTetriminoAlive() && gravityStepCounter == 0)
		{
			tetrisBoard.putTetrimino(pool.getTetrimino());
			
		}
		gravityStepCounter++;
		return false;
		
	}

	protected void onGraphicsUpdate()
	{
		try
		{
			System.out.println(tetrisBoard);			

		} catch (Exception e)
		{
			e.printStackTrace();
		}
	
	}

	protected void onSoundPlay()
	{
	
	}

	public static void main(String[] args)
	{
		TetrisLogic tet = new TetrisLogic();
		tet.setVisible(true);
		tet.Game();
		
	}

	
	
}
