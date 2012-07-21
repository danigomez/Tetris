package com.daxapp.tetris.vo;

import com.daxapp.tetris.constants.TetrisConstants;
import com.daxapp.tetris.core.layout.Layout;
import com.daxapp.tetris.core.util.LayoutDrawHelper;

public class LayoutVO extends Layout
{
	private int toLeftAvail; //Cantidad de movimientos a izquierda restantes
	private int toRigthAvail; //Cantidad de movimientos a derecha restantes
	
	public LayoutVO(Layout l)
	{
		super(l.getLayoutMatrix());
		toLeftAvail = (TetrisConstants.TETRIS_COL - getLayoutSize())/2;
		toRigthAvail = TetrisConstants.TETRIS_COL - toLeftAvail;
	}
	
	
	public int getBias()
	{
		return LayoutDrawHelper.getBias(this);
	}
	
	public int getToLeftAvail()
	{
		return toLeftAvail;
	}
	
	public int getToRightAvail()
	{
		return toRigthAvail;
	}

}
