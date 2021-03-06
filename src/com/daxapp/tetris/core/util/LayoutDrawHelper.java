package com.daxapp.tetris.core.util;

import com.daxapp.tetris.constants.TetrisConstants;
import com.daxapp.tetris.core.layout.Layout;

public class LayoutDrawHelper
{
	private static boolean isZeroRow(Layout layout, int row)
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
		for(int i = 0;LayoutDrawHelper.isZeroRow(layout, i);i++)
		{
			bias++;
		}
		return bias;
	}
	
	public static int getDownBias(Layout layout)
	{
		int ret = 0;
		
		for(int i = layout.getLayoutSize()-1;LayoutDrawHelper.isZeroRow(layout, i);i--)
		{
			ret++;
		}
		
		return ret;
	}
	
	public static int getLeftBias(Layout layout)
	{
		int auxbias = 0,bias = 10,aux = 0;
		int size = layout.getLayoutSize();
		boolean zero;
		
		for(int i = 0;i < size;i++)
		{
			zero = isZeroRow(layout, i);
			auxbias = 0;
			for(int j = 0;j < size; j++)
			{
				aux = j;
				if(!zero && layout.getAtPos(i, j) == TetrisConstants.NO_DATA)
				{
					auxbias++;
				}
				else
				{
					break;
				}
			}
			if(aux == 0)
			{
				bias = 0;
			}
			else if(auxbias != 0 && bias > auxbias)
			{
				bias = auxbias;
			}
			
		}
		//System.out.println("LEFT BIAS ->" + bias);
		return bias;
	}

	public static int getRightBias(Layout layout)
	{
		int auxbias = 0,bias = 10,aux = 0;
		int size = layout.getLayoutSize();
		boolean zero;
		
		for(int i = 0;i < size;i++)
		{
			zero = isZeroRow(layout, i);
			auxbias = 0;
			for(int j = size-1;j >= 0; j--)
			{
				aux = j;
				if(!zero && layout.getAtPos(i, j) == TetrisConstants.NO_DATA)
				{
					auxbias++;
				}
				else
				{
					break;
				}
			}
			if(aux == size - 1)
			{
				bias = 0;
			}
			else if(auxbias != 0 && bias > auxbias)
			{
				bias = auxbias;
			}
			
		}
		//System.out.println("RIGHT BIAS ->" + bias);
		return bias;
	}
	

}
