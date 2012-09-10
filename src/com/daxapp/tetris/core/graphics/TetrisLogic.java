package com.daxapp.tetris.core.graphics;

import java.awt.event.KeyEvent;

import com.daxapp.tetris.constants.TetrisConstants;
import com.daxapp.tetris.core.GameBoard;
import com.daxapp.tetris.core.Tetrimino;
import com.daxapp.tetris.pool.TetriminoPool;


//TODO fijarrse de agregar sonidooo!!

@SuppressWarnings("serial")
public class TetrisLogic extends BaseGameLogic
{
	private GameBoard tetrisBoard;
	private TetriminoPool pool;
	
	private Tetrimino current;
	private Tetrimino next;
	private Tetrimino hold;
	
	private int framesToStep;
	private int points;
	private int gravityStepCounter;
	private int level;
	private int totalLines;
	
	private boolean isOnShift;
	
	protected void onCreateResources()
	{
		pool = new TetriminoPool();
		tetrisBoard = new GameBoard(TetrisConstants.TETRIS_ROW,TetrisConstants.TETRIS_COL);
		current = pool.getTetrimino();
		next = pool.getTetrimino();
		
		framesToStep = TetrisConstants.HOLD_TIME_TO_STEP;//Tiempo de espera inicial para la dificultad más baja
		level = 0; //TODO que se pueda elegir en que nivel empezar
		points = 0;
		totalLines = 0;
		gravityStepCounter = 0;
		isOnShift = false;
		
		tetrisBoard.putTetrimino(current); //Para evitar excepciones al estar el tablero vacio al iniciar el juego

		
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
				
				case KeyEvent.VK_SPACE:
					tetrisBoard.instantDownTetrimino();
					break;
				case KeyEvent.VK_SHIFT:
					shiftTetrimino();
					break;
					
			}
		}
	}

	protected boolean onGameLoopUpdate()
	{
		int lines;
		//TODO contar el tiempo que se tarda en colocar una pieza para aumentar el puntaje según eso!
		if(!tetrisBoard.isTetriminoAlive())
		{
			lines = tetrisBoard.cleanFullLines();
			totalLines += lines;
			points += updatePoints(lines);	
			level = updateLevel(totalLines);
			
			tetrisBoard.putTetrimino(next);
			current = next;
			next = pool.getTetrimino();
			
			isOnShift = false;
			
			
		}
		gravityStepCounter++; //Incremento en 1 el conteo de frames antes del paso por gravedad...
		return tetrisBoard.isDefeated(); //Retorno si es juego está terminado
		
	}

	protected void onGraphicsUpdate()
	{
		boardPanel.setPoints(points + "");
		boardPanel.setLevel(level + "");
		boardPanel.setLines(totalLines + "");
		boardPanel.setNextTetrimino(next.toString());
		if(hold!=null)boardPanel.setHoldTetrimo(hold.toString());

		boardPanel.setToDraw(tetrisBoard.toString());
		boardPanel.updateUI();
	
	}

	protected void onSoundPlay()
	{
		//TODO hacer estooooooooooooooooooooooooo!
	}
	

	private void shiftTetrimino()
	{
		if(hold == null)
		{
			tetrisBoard.putTetrimino(next);
			hold = current;
			current = next;
			next = pool.getTetrimino();
			
		}
		else if(!isOnShift)
		{
			Tetrimino aux;
			
			tetrisBoard.putTetrimino(hold);
			aux = current;
			current = hold;
			hold = aux;

		}
		
		isOnShift = true;
		
	}

	private int updatePoints(int lines)
	{
		switch(lines)
		{
			case 4:
				return TetrisConstants.TETRIS + TetrisConstants.TETRIS*level;
			case 3:
				return TetrisConstants.TRIPlE + TetrisConstants.TRIPlE*level;
			case 2:
				return TetrisConstants.DOBLE + TetrisConstants.DOBLE*level;
			case 1: 
				return TetrisConstants.SIMPLE + TetrisConstants.SIMPLE*level;
			default:
				return 0;
 		}
	}
	
	private int updateLevel(int lines)
	{
		int ret = lines / TetrisConstants.LINES_PER_LEVEL;//Obtengo el nuevo nivel

		if(ret > level)
			framesToStep -= TetrisConstants.HOLD_TIME_DECREMENT;
		return ret;
	}

	public static void main(String[] args)
	{
		TetrisLogic tet = new TetrisLogic();

		while(true)
		{
			if(tet.isReset())
			{
				tet.setResetStatus(false);
				tet.setInputListener();
				tet.Game();
				
			}
			tet.removeInputListener();
		}
		
		
	}
}
