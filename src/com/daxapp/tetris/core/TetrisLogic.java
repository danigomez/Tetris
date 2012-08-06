package com.daxapp.tetris.core;

import com.daxapp.tetris.constants.TetrisConstants;
import com.daxapp.tetris.pool.TetriminoPool;

public class TetrisLogic extends BaseGameLogic
{
	private GameBoard tetrisBoard;
	private TetriminoPool pool;
	private int gravityStepCounter;

	protected int getFPS()
	{
		return TetrisConstants.FPS;
	}
	
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
		tet.Game();
	}

	
	
}
