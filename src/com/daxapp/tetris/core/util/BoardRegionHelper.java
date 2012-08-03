package com.daxapp.tetris.core.util;

import com.daxapp.tetris.constants.TetrisConstants;


public class BoardRegionHelper
{
	
	//Indica si currentRow y currentCol se encuentran dentro del área definida por [rowInit,colInit]x[rowMax,colMax]
	public static boolean isOnBoardRegion(int currentRow, int currentCol, int rowInit, int colInit, int rowMax, int colMax)
	{
		return (currentRow >= rowInit && currentRow < rowInit + rowMax) &&
		   	   (currentCol >= colInit && currentCol < colInit + colMax);
	}

}
