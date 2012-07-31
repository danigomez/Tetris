package com.daxapp.tetris.core.util;

import com.daxapp.tetris.constants.TetrisConstants;


public class CollisionHelper
{
	//rowPos y colPos representan un punto en matrix, del cual se va a chequear los vecinos q tenga
	//Si alguno de los valores de CollisionResult es true, entonces se setea algun flag en el GameBoard
	//indicando que debe evitarse algún tipo de movimiento para el lado indicado
	//ESTE MÉTODO INDICA SI EXISTE UNA COLISION AL MOVERSE, la colision al rotar es aparte
	public static void collisionOnMove(int[][] matrix, int rowPos, int colPos, CollisionResult ret)
	{
		boolean right,left,down,roto;
		right = ret.isRightCollision();
		left = ret.isLeftCollision();
		down = ret.isDownCollision();
		roto = ret.isRotatedCollision();
		
		if(!right && colPos + 1 < TetrisConstants.TETRIS_COL)
			ret.setRightCollision(matrix[rowPos][colPos+1] == TetrisConstants.BLOCK);
		
		if(!left && colPos - 1 > 0)
			ret.setLeftCollision(matrix[rowPos][colPos-1] == TetrisConstants.BLOCK);
		
		if(!down && rowPos + 1 < TetrisConstants.TETRIS_ROW)
			ret.setDownCollision(matrix[rowPos+1][colPos] == TetrisConstants.BLOCK);
	
	}
}
