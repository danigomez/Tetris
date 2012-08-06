package com.daxapp.tetris.core;

import com.daxapp.tetris.constants.TetrisConstants;
import com.daxapp.tetris.core.util.BoardRegionHelper;
import com.daxapp.tetris.core.util.CollisionHelper;
import com.daxapp.tetris.core.util.CollisionResult;
import com.daxapp.tetris.vo.LayoutVO;

public class GameBoard
{
	//TODO Agregar la clase TetriminoUpdateHandler, y q el GameBoard llame a sus métodos,
	//se va a encargar de manipular todo el movimiento del tetrimino(REFACTOR)
	private int[][] board;
	private int row;
	private int col;
	private int currentCol;
	private int currentRow;
	
	private LayoutVO currentLayout;

	private CollisionResult collisionResult;
	
	private boolean tetriminoDead = false;
	
	
	public GameBoard(int row, int col)
	{
		this.row = row;
		this.col = col;
		
		board = new int[row][col];
		setZero();
		                                          
	}
	
	public int cleanFullLines()
	{
		//TODO chequea las lineas que están como completas y las elimina del tablero...
		//retorna la cantidad de lineas eliminadas(para poder calcular el puntaje)
		
		return 0;
	}
	
	private void setZero()
	{
		for(int i = 0; i < row;i++)
		{
			
			for(int j = 0; j < col;j++)
			{
				board[i][j] = TetrisConstants.NO_DATA;
			}
		}
	}

	public void putTetrimino(Tetrimino tetrimino)
	{
		tetriminoDead = false;
		currentLayout = new LayoutVO(tetrimino.getCurrentLayout());
		int layoutSize = currentLayout.getLayoutSize();
		currentCol = (TetrisConstants.TETRIS_COL - layoutSize)/2; //Obtengo la posicion centrada del tetrimino
		currentRow = 0;
		collisionResult = new CollisionResult();

	}
	
	public void stepDownTetrimino()
	{
		
		if(currentLayout.hasDownAvail() && !collisionResult.isDownCollision())
		{
			currentRow++;
			currentLayout.onMoveDown();
			collisionResult = checkCollision();
		}
		else
		{
			tetriminoDead = true;
			putOnBoard();
		}
		
	}

	public void stepRightTetrimino()
	{
		if(currentLayout.hasRightAvail() && !collisionResult.isRightCollision())
		{
			currentCol++;
			currentLayout.onMoveRight();
			collisionResult = checkCollision();
		}
			
	}
	
	public void stepLeftTetrimino()
	{
		if(currentLayout.hasLeftAvail() && !collisionResult.isLeftCollision())
		{
			currentCol--;
			currentLayout.onMoveLeft();
			collisionResult = checkCollision();
		}
			
	}
	
	public void rotateTetrimino()
	{
		if(!collisionResult.isRotatedCollision())
		{
			currentLayout.rotateAndUpdate();
			currentCol += currentLayout.getColOffset();
			currentRow += currentLayout.getRowOffset();
			collisionResult = checkCollision();
		}
	}

	public boolean isTetriminoAlive()
	{
		return !tetriminoDead && currentRow != 0;
	}
	
	
	
	private CollisionResult checkCollision()
	{

		return CollisionHelper.getAllCollisions(board, currentLayout, currentRow, currentCol);
		
	}


	public String toString()
	{
		String ret = "";
		
		int size = currentLayout.getLayoutSize();
		//int bias = currentLayout.getBias(); //Cant de íneas en blanco q no tienen q ser dibujadas
	
		int lRow,lCol;
		int toDraw;
		
		for(int i = TetrisConstants.BIAS; i < TetrisConstants.TETRIS_ROW;i++)
		{
			for(int j = 0; j < TetrisConstants.TETRIS_COL;j++)
			{
				lRow = i - currentRow;
				lCol = j - currentCol;
				
				if(BoardRegionHelper.isOnBoardRegion(i, j, currentRow, currentCol, size , size) 
						&& lRow < size
						&& (toDraw = currentLayout.getAtPos(lRow, lCol)) != TetrisConstants.NO_DATA)
				//(i,j) pertenecen al cuadrado del layout
				{
						ret += toDraw; 
		
				}
				else
				{
					ret += board[i][j];
				}
				ret += " ";
			}
			
			ret += "\n";
		}
		
		
		return ret;
	}
	
	
	private void putOnBoard()
	{
		int size = currentLayout.getLayoutSize();
		
		int lRow,lCol;
		int toDraw;
		for(int i = currentRow; i < TetrisConstants.TETRIS_ROW;i++)
		{
			for(int j = currentCol; j < TetrisConstants.TETRIS_COL;j++)
			{
				lRow = i - currentRow;
				lCol = j - currentCol;
				if(BoardRegionHelper.isOnBoardRegion(i, j, currentRow, currentCol, size , size) 
						&& lRow < size
						&& (toDraw = currentLayout.getAtPos(lRow, lCol)) != TetrisConstants.NO_DATA)
				//(i,j) pertenecen al cuadrado del layout
				{
					board[i][j] = toDraw;
				}
			
			}
			
		}
	}

}
