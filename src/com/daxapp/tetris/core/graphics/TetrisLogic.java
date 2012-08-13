package com.daxapp.tetris.core.graphics;

import java.awt.event.KeyEvent;

import com.daxapp.tetris.constants.TetrisConstants;
import com.daxapp.tetris.core.GameBoard;
import com.daxapp.tetris.pool.TetriminoPool;

@SuppressWarnings("serial")
public class TetrisLogic extends BaseGameLogic
{
	private GameBoard tetrisBoard;
	private TetriminoPool pool;
	
	private int framesToStep;
	private int points;
	private int gravityStepCounter;
	//private int level;
	
	protected void onCreateResources()
	{
		pool = new TetriminoPool();
		tetrisBoard = new GameBoard(TetrisConstants.TETRIS_ROW,TetrisConstants.TETRIS_COL);
		tetrisBoard.putTetrimino(pool.getTetrimino()); //Para evitar excepciones al estar el tablero vacio al iniciar el juego
		framesToStep = TetrisConstants.HOLD_TIME_TO_STEP;//Tiempo de espera inicial para la dificultad más baja
		
		//level = 1; //TODO que se pueda elegir en que nivel empezar
		points = 0;
		gravityStepCounter = 0;
		
	}
	
	protected void auxiliarProc()
	{
		if(gravityStepCounter >= framesToStep )
		{
			tetrisBoard.stepDownTetrimino();
			gravityStepCounter = 0;
		}
		
	}

	protected void onInputEvent()
	{
		//TODO Que las teclas y sus acciones se levanten del archivo de configuracion
		if(tetrisBoard.isTetriminoAlive())
		{
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
	}

	protected boolean onGameLoopUpdate()
	{
		if(!tetrisBoard.isTetriminoAlive())
		{
			tetrisBoard.cleanFullLines();//TODO tomar la cantidad de líneas limpiadas para saber cuando cambiar de nivel!
										 //Chequear porque parece qu al cambiar mucho de nivel, loopea algo. revisarrrr!
			tetrisBoard.putTetrimino(pool.getTetrimino());
			
		}
		gravityStepCounter++;
		return tetrisBoard.isDefeated();
		
	}

	protected void onGraphicsUpdate()
	{
		panel.setToDraw(tetrisBoard.toString());
		panel.updateUI();
	
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
