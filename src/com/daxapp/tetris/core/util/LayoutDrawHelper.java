package com.daxapp.tetris.core.util;

import com.daxapp.tetris.constants.TetrisConstants;
import com.daxapp.tetris.core.layout.Layout;

public class LayoutDrawHelper
{
	public static boolean isZeroRow(Layout layout, int row)
	{
		int size = layout.getLayoutSize();
		
		for(int j = 0; j < size;j++)
		{
			if(layout.getAtPos(row, j) == TetrisConstants.BLOCK)
				return false;
			
		}
		
		return true;
	}

	public static int getBias(Layout layout)
	{
		int bias = 0;
		for(int i = 0;LayoutDrawHelper.isZeroRow(layout, i + bias);i++)
		{
			bias++;
		}
		return bias;
	}
	
	
	

}
