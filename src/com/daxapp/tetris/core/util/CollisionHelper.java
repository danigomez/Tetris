package com.daxapp.tetris.core.util;

import com.daxapp.tetris.constants.TetrisConstants;
import com.daxapp.tetris.core.layout.Layout;


public class CollisionHelper
{
	public static void onMoveCollision(int[][] matrix, int rowPos, int colPos, CollisionResult ret)
	{
		//Este método se llama por cada bloque del tetrimino al cual se quiere verificar la colisión
		boolean right,left,down,roto;
		
		//Al ser llamado por cada bloque solo verifico la colisión una vez,
		//en el caso de que se haya detectado no la vuelvo a verificar para este tetrimino
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
	
	public static void onRotateCollision(Layout layout)
	{
		
	}
}
