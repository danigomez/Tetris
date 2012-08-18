package com.daxapp.tetris.core;

import com.daxapp.tetris.constants.TetrisConstants;
import com.daxapp.tetris.core.util.BoardRegionHelper;
import com.daxapp.tetris.core.util.CollisionHelper;
import com.daxapp.tetris.core.util.CollisionResult;
import com.daxapp.tetris.vo.LayoutVO;

public class GameBoard
{
	private int[][] board;
	private int row;
	private int col;
	private int currentCol;
	private int currentRow;
	private boolean tetriminoDead = false;
	
	private LayoutVO currentLayout;
	private CollisionResult collisionResult;
	
	
	public GameBoard(int row, int col)
	{
		this.row = row;
		this.col = col;
		
		board = new int[row][col];
		setZero();
		
		                                          
	}
	
	//Setea en 0 todo el tablero
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

	//Coloca en juego un nuevo tetrimino
	public void putTetrimino(Tetrimino tetrimino)
	{
		tetriminoDead = false;
		currentLayout = new LayoutVO(tetrimino.getCurrentLayout());
		int layoutSize = currentLayout.getLayoutSize();
		currentCol = (TetrisConstants.TETRIS_COL - layoutSize)/2; //Obtengo la posicion centrada del tetrimino
		currentRow = 0;
		collisionResult = checkCollision();

	}
	
	//Mueve hacia abajo al tetrimino, chequeando si existen colisiones o si tiene
	//movimientos disponibles, de no ser posible ninguna de las dos cosas, significa
	//que el tetrimino está dead!
	public boolean stepDownTetrimino()
	{
		
		if(currentLayout.hasDownAvail() && !collisionResult.isDownCollision())
		{
			currentRow++;
			currentLayout.onMoveDown();
			collisionResult = checkCollision();
			return true;
		}
		else
		{
			tetriminoDead = true;
			putOnBoard();
			return false;
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
	
	//Baja la pieza hasta que choca con otra o llega hasta el fondo
	public void instantDownTetrimino()
	{
		while(stepDownTetrimino());
	}

	//Si el tetrimino no está muerto(no esta en el fondo o parado por otro tetrimino)
	//y la fila actual != 0, o sea, está en juego, entonces está vivo
	public boolean isTetriminoAlive()
	{
		return !tetriminoDead;
	}
	
	//Retorna las colisiones a izquierda,derecha y abajo del tetrimino en juego
	private CollisionResult checkCollision()
	{
		return CollisionHelper.getAllCollisions(board, currentLayout, currentRow, currentCol);
	}
	
	//Limpia las filas que tengan todos sus valores en BLOCK
	public int cleanFullLines()
	{
		int clearedLines = 0;
		for(int i = 0; i < TetrisConstants.TETRIS_ROW;i++)
		{
			if(isFullRow(i))
			{
				stepDownRow(i);
				clearedLines++;
			}
		}
		
		return clearedLines;
	}
	
	public boolean isDefeated()
	{
		return currentRow == 0 && collisionResult.isDownCollision();
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
						ret += TetrisConstants.BLOCK_VO; 
		
				}
				else if(board[i][j] == TetrisConstants.NO_DATA)
				{
					ret += TetrisConstants.NO_DATA_VO; 
				}
				else
				{
					ret += TetrisConstants.BLOCK_VO; 
				}
				ret += " ";
			}
			
			ret += "\n";
		}
		
		
		return ret;
	}
	
	
	private void stepDownRow(int row)
	{
		for(int i = row - 1; i >= 0;i--)
		{
			for(int j = 0; j < TetrisConstants.TETRIS_COL;j++)
			{
				board[i+1][j] = board[i][j];
			}
		}
	}
	
	
	private boolean isFullRow(int row)
	{
		for(int i = 0;i < TetrisConstants.TETRIS_COL;i++)
		{
			if(board[row][i] == TetrisConstants.NO_DATA)
				return false;
		}
		return true;
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
