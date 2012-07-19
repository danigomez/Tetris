package com.daxapp.tetris.core;

import com.daxapp.tetris.constants.TetrisConstants;
import com.daxapp.tetris.core.layout.Layout;
import com.daxapp.tetris.core.util.BoardRegionHelper;

public class GameBoard
{
	private int[][] board;
	private int row;
	private int col;
	//TODO Fijarse si se puede hacer algo así como un TetriminoUpdateHandler q se encarge de mover el tetrmino en pantalla
	private Layout currentLayout;
	
	private int currentCol;
	private int currentRow;
	
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
		currentLayout = tetrimino.getCurrentLayout();
		int layoutSize = currentLayout.getLayoutSize();
		currentCol = (TetrisConstants.TETRIS_COL - layoutSize)/2; //Obtengo la posicion centrada del tetrimino
		currentRow = 0;

	}
	
	public void stepDownTetrimino()
	{
		currentRow++;
	}

	public boolean isTetriminoAlive()
	{
		if(currentRow != 0)
			return true;
		return false;
	}
	
	public boolean isTetriminoDead()
	{
		//TODO indica si un tetrimino debe ser fijado dentro de los valores del tablero
		
		
		return false;
	}
	
	
	private boolean checkCollision(Layout layout)
	{
		//TODO Verificar cuando un tetrimino tiene bloques q puedes impedir su camino, es decir,
		//por cada bloque del tetrmino, verifico si algo bloquea su mov, es decir dentro del area q ocupe
		// el tetrimino, verifico si lo bloquea y si se quiere hacer un movimiento más,
		//lo pongo como dead y lo seteo en el tablero
		
		return false;
	}
	
	public String toString()
	{
		String ret = "";
		int size = currentLayout.getLayoutSize();
		for(int i = 0; i < TetrisConstants.TETRIS_ROW;i++)
		{
			for(int j = 0; j < TetrisConstants.TETRIS_COL;j++)
			{
				if(BoardRegionHelper.isOnBoardRegion(i, j, currentRow, currentCol, size , size))
				{
					ret += currentLayout.getAtPos(i - currentRow, j - currentCol); //La resta es para no pasarme de los límites de los layouts
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
}
