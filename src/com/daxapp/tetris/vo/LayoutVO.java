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
		toRigthAvail = TetrisConstants.TETRIS_COL - (getLayoutSize() + toLeftAvail);
		System.out.println(toLeftAvail);
		System.out.println(toRigthAvail);
	}
	
	
	public int getBias()
	{
		return LayoutDrawHelper.getBias(this);
	}
	
	public boolean hasLeftAvail()
	{
		if(toLeftAvail > 0)
			return true;
		return false;
		
	}
	
	public boolean hasRightAvail()
	{
		if(toRigthAvail > 0)
			return true;
		return false;
		
	}
	
	public void onMoveRight()
	{
		toRigthAvail -= 1;
		toLeftAvail += 1;
	}
	
	public void onMoveLeft()
	{
		toRigthAvail += 1;
		toLeftAvail -= 1;
	}
	
	
	
	

}
