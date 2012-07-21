package com.daxapp.tetris.core;

import com.daxapp.tetris.constants.TetrisConstants;
import com.daxapp.tetris.pool.TetriminoPool;

public class TetrisLogic extends BaseGameLogic
{
	//TODO Implementar el tablero de tetris
	private GameBoard tetrisBoard;
	private TetriminoPool pool;
	private Tetrimino currentTetrimino;

	
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
			currentTetrimino = pool.getTetrimino();
			tetrisBoard.putTetrimino(currentTetrimino);
		}
	
		return false;
		
	}

	protected void onGraphicsUpdate()
	{
		try
		{
		
			System.out.println(tetrisBoard);
			Thread.sleep(1000);

			tetrisBoard.stepDownTetrimino();
			tetrisBoard.stepRightTetrimino();
			//currentTetrimino.rotate();
			
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
