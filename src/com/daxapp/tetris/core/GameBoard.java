package com.daxapp.tetris.core;

import com.daxapp.tetris.constants.TetrisConstants;
import com.daxapp.tetris.core.util.BoardRegionHelper;
import com.daxapp.tetris.core.util.CollisionResult;
import com.daxapp.tetris.vo.LayoutVO;

public class GameBoard
{
	private int[][] board;
	private int row;
	private int col;
	private int currentCol;
	private int currentRow;
	
	private LayoutVO currentLayout;
	
	private boolean tetriminoDead = false;
	
	
	public GameBoard(int row, int col)
	{
		this.row = row;
		this.col = col;
		
		board = new int[row][col];
		setZero();
		                                          
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

	}
	
	public void stepDownTetrimino()
	{
		if(currentLayout.hasDownAvail())
		{
			currentRow++;
			currentLayout.onMoveDown();
		}
		else
		{
			tetriminoDead = true;
			putOnBoard();
		}
		
	}

	public void stepRightTetrimino()
	{
		if(currentLayout.hasRightAvail())
		{
			currentCol++;
			currentLayout.onMoveRight();
		}
			
	}
	
	public void stepLeftTetrimino()
	{
		if(currentLayout.hasLeftAvail())
		{
			currentCol--;
			currentLayout.onMoveLeft();
		}
			
	}

	public boolean isTetriminoAlive()
	{
		return !tetriminoDead && currentRow != 0;
	}
	
	public void rotateTetrimino()
	{
		currentLayout.rotate();
		currentCol += currentLayout.getColOffset();
		currentRow += currentLayout.getRowOffset();
	}
	
	private CollisionResult checkCollision()
	{
		//TODO Verificar cuando un tetrimino tiene bloques q puedes impedir su camino, es decir,
		//por cada bloque del tetrmino, verifico si algo bloquea su mov, es decir dentro del area q ocupe
		// el tetrimino, verifico si lo bloquea y si se quiere hacer un movimiento más,
		//lo pongo como dead y lo seteo en el tablero
		int size = currentLayout.getLayoutSize();
		int lRow,lCol;
		
		CollisionResult ret = null;
		
		for(int i = currentRow; i < currentRow + size;i++)
		{
			for(int j = currentCol; j <  currentCol + size;j++)
			{
				lRow = i - currentRow;
				lCol = j - currentCol;
				if(BoardRegionHelper.isOnBoardRegion(i, j, currentRow, currentCol, size , size) 
						&& lRow < size
						&& currentLayout.getAtPos(lRow, lCol) != TetrisConstants.NO_DATA)
				//(i,j) pertenecen al cuadrado del layout
				{
					
					
					
				}
			
			}
		}
		
		return ret;
		
		
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
