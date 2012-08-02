package com.daxapp.tetris.core;

import com.daxapp.tetris.constants.TetrisConstants;
import com.daxapp.tetris.pool.TetriminoPool;

public class TetrisLogic extends BaseGameLogic
{
	private GameBoard tetrisBoard;
	private TetriminoPool pool;

	
	protected void onCreateResources()
	{
		pool = new TetriminoPool();
		tetrisBoard = new GameBoard(TetrisConstants.TETRIS_ROW,TetrisConstants.TETRIS_COL);

	}
	
	protected void onInputEvent()
	{
		
	}

	protected boolean onGameLoopUpdate()
	{
		if(!tetrisBoard.isTetriminoAlive())
		{
			tetrisBoard.putTetrimino(pool.getTetrimino());
//			tetrisBoard.putTetrimino(new Type4());// TODO chequear el caso en q da mal el downAvail con esta pieza
			
			
		}
	
		return false;
		
	}

	protected void onGraphicsUpdate()
	{
		try
		{
			System.out.println(tetrisBoard);
			Thread.sleep(250);
			tetrisBoard.stepDownTetrimino();
			tetrisBoard.rotateTetrimino();
			
			
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
