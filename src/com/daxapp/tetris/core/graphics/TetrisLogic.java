package com.daxapp.tetris.core.graphics;

import java.awt.event.KeyEvent;

import com.daxapp.tetris.constants.TetrisConstants;
import com.daxapp.tetris.core.GameBoard;
import com.daxapp.tetris.pool.TetriminoPool;

public class TetrisLogic extends BaseGameLogic
{
	private GameBoard tetrisBoard;
	private TetriminoPool pool;
	
	private int gravityStepCounter;
	
	protected void onCreateResources()
	{
		pool = new TetriminoPool();
		tetrisBoard = new GameBoard(TetrisConstants.TETRIS_ROW,TetrisConstants.TETRIS_COL);
		
		gravityStepCounter = 0;
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
		return tetrisBoard.isDefeated();
		
	}

	protected void onGraphicsUpdate()
	//TODO Nota: este m�todo va a dejar de existir cuando se integre el core con Canvas
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
		tet.Game();
		
	}
}