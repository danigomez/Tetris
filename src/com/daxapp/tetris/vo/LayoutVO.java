package com.daxapp.tetris.vo;

import com.daxapp.tetris.constants.TetrisConstants;
import com.daxapp.tetris.core.layout.Layout;
import com.daxapp.tetris.core.util.LayoutDrawHelper;

public class LayoutVO extends Layout
{
	private int toLeftAvail; //Cantidad de movimientos a izquierda restantes
	private int toRigthAvail; //Cantidad de movimientos a derecha restantes
	private int leftBias;
	private int rightBias;
	
	public LayoutVO(Layout l)
	{
		super(l.getLayoutMatrix());
		toLeftAvail = (TetrisConstants.TETRIS_COL - getLayoutSize())/2; 
		toRigthAvail = TetrisConstants.TETRIS_COL - (getLayoutSize() + toLeftAvail);
		leftBias = LayoutDrawHelper.getLeftBias(this);
		rightBias = LayoutDrawHelper.getRightBias(this);
		
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
	
	public void rotate()
	{
		super.rotate();
		onRotate();
		//TODO actualizar los avail a izquierda y derecha ya que al rotar se modifica!!!
		//Chequear si se tiene q sumar o restar el bias segun si el bias anterior es mayor al nuevo
	}
	
	private void onRotate()
	{
		int lBias = LayoutDrawHelper.getLeftBias(this);
		int rBias = LayoutDrawHelper.getRightBias(this);
		
		toLeftAvail += lBias - leftBias;
		toRigthAvail += rBias - rightBias;
		
		System.out.println("LAVAIL -> " + toLeftAvail);
		System.out.println("RAVAIL -> " + toRigthAvail);
		leftBias = lBias;
		rightBias = rBias;
		System.out.println(leftBias);
		System.out.println(rightBias);
	}
	
	
	

}
