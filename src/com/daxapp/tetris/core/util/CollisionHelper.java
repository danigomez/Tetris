package com.daxapp.tetris.core.util;

import com.daxapp.tetris.constants.TetrisConstants;
import com.daxapp.tetris.core.layout.Layout;


public class CollisionHelper
{
	
	public static CollisionResult getAllCollisions(int[][] matrix, Layout layout, int rowInit, int colInit)
	{
		int size = layout.getLayoutSize();
		int lRow,lCol;
		
		
		CollisionResult ret = new CollisionResult();
		//Move Collision
		for(int i = rowInit; i < rowInit + size;i++)
		{
			for(int j = colInit; j <  colInit + size;j++)
			{
				lRow = i - rowInit;
				lCol = j - colInit;
				if(BoardRegionHelper.isOnBoardRegion(i, j, rowInit, colInit, size , size) 
						&& lRow < size
						&& layout.getAtPos(lRow, lCol) != TetrisConstants.NO_DATA)
				//(i,j) pertenecen al cuadrado del layout
				{
					
					CollisionHelper.onMoveCollision(matrix, i, j, ret);
					
				}
			
			}
		}
		
		CollisionHelper.onRotateCollision(matrix, layout, rowInit, colInit,ret);
		
		return ret;
	}
	
	private static void onMoveCollision(int[][] matrix, int rowPos, int colPos, CollisionResult ret)
	{
		//Este m�todo se llama por cada bloque del tetrimino al cual se quiere verificar la colisi�n
		boolean right,left,down;
		
		//Al ser llamado por cada bloque solo verifico la colisi�n una vez,
		//en el caso de que se haya detectado no la vuelvo a verificar para este tetrimino
		right = ret.isRightCollision();
		left = ret.isLeftCollision();
		down = ret.isDownCollision();
	
		if(!right && colPos + 1 < TetrisConstants.TETRIS_COL)
			ret.setRightCollision(matrix[rowPos][colPos+1] == TetrisConstants.BLOCK);
		
		if(!left && colPos - 1 > 0)
			ret.setLeftCollision(matrix[rowPos][colPos-1] == TetrisConstants.BLOCK);
		
		if(!down && rowPos + 1 < TetrisConstants.TETRIS_ROW)
			ret.setDownCollision(matrix[rowPos+1][colPos] == TetrisConstants.BLOCK);
		
		
	}
	
	private static void onRotateCollision(int[][] matrix, Layout layout, int rowPos, int colPos, CollisionResult ret)
	{
		int lRow,lCol;
		int size = layout.getLayoutSize();
		boolean roto = false;
		layout.rotate();

		for(int i = rowPos;!roto && i < rowPos + size;i++)
		{
			for(int j = colPos;!roto && j <  colPos + size;j++)
			{
				lRow = i - rowPos;
				lCol = j - colPos;
				if(BoardRegionHelper.isOnBoardRegion(i, j, rowPos, colPos, size , size) 
						&& lRow < size
						&& layout.getAtPos(lRow, lCol) != TetrisConstants.NO_DATA)
				//(i,j) pertenecen al cuadrado del layout
				{
					
					if(matrix[i][j] == layout.getAtPos(lRow, lCol))
						roto = true;
				}
			
			}
		}
		ret.setRotatedCollision(roto);
		layout.unrotate();
	}
}
