package com.daxapp.tetris.vo;

import com.daxapp.tetris.constants.TetrisConstants;
import com.daxapp.tetris.core.layout.Layout;
import com.daxapp.tetris.core.util.LayoutDrawHelper;

public class LayoutVO extends Layout
{
	private int toLeftAvail; //Cantidad de movimientos a izquierda restantes
	private int toRigthAvail; //Cantidad de movimientos a derecha restantes
	private int toDownAvail;
	
	private int leftBias;
	private int rightBias;
	private int downBias;
	
	private int colOffset;
	private int rowOffset;
	
	public LayoutVO(Layout l)
	{
		super(l.getLayoutMatrix());
		toLeftAvail = (TetrisConstants.TETRIS_COL - getLayoutSize())/2; 
		toRigthAvail = TetrisConstants.TETRIS_COL - (getLayoutSize() + toLeftAvail);
		toDownAvail = TetrisConstants.TETRIS_ROW - (getLayoutSize() - LayoutDrawHelper.getDownBias(this));

		leftBias = LayoutDrawHelper.getLeftBias(this);
		rightBias = LayoutDrawHelper.getRightBias(this);
		downBias = LayoutDrawHelper.getDownBias(this);
		
//		System.out.println("DOWN AVAIL INICIAL " + toDownAvail);
	}
	
	public int getColOffset()
	{
		return colOffset;
	}

	public int getRowOffset()
	{
		return rowOffset;
	}

	public boolean hasLeftAvail()
	{
		//Quedan movimientos a izquierda?
		return avail(toLeftAvail);
		
	}
	
	public boolean hasRightAvail()
	{
		//Quedan movimientos a derecha?
		return avail(toRigthAvail);
	}
	
	public boolean hasDownAvail()
	{
		//Quedan movimientos para abajo?
		return avail(toDownAvail);
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
	
	public void onMoveDown()
	{
		toDownAvail -= 1;
	}
	
	public void rotateAndUpdate()
	{
		super.rotate();
		onRotate();

	}

	
	private void onRotate()
	{
		int lBias = LayoutDrawHelper.getLeftBias(this);
		int rBias = LayoutDrawHelper.getRightBias(this);
		int dBias = LayoutDrawHelper.getDownBias(this);
		
		toLeftAvail += lBias - leftBias; //Si el bias actual es mayor al bias anterior, sumo la diferencia al avail nuevo
		toRigthAvail += rBias - rightBias;
		toDownAvail += dBias - downBias ;
	
		leftBias = lBias; //Columnas vacias q hay hasta llegar al tetrimino por izquierda
		rightBias = rBias;  //Columnas vacias q hay hasta llegar al tetrimino por derecha
		downBias = dBias;
		
	    rowOffset = fixOutRow();
	    colOffset = fixOutCol();
	}
	
	private int fixOutRow()
	{
		int ret = 0;
		if(toDownAvail < 0) //<0
		{
			ret = toDownAvail;
			toDownAvail = 0;
		}
		
		//System.out.println("DOWN AVAIL FIXED -> " + toDownAvail);
		return ret;
	}
	
	private int fixOutCol()
	{
		int ret = 0;
		if(toLeftAvail < 0)
		{
			ret = -toLeftAvail; //> 0, Tengo q sumar a las columna actual del tetrimino tanto como me pase
			toLeftAvail = 0;
			toRigthAvail = TetrisConstants.TETRIS_COL - getLayoutSize();
			
		}
		else if(toRigthAvail < 0)
		{
			ret = toRigthAvail; //< 0
			toRigthAvail = 0;
			toLeftAvail = TetrisConstants.TETRIS_COL - getLayoutSize();
			
		}
		
		return ret;
	}
	
	private boolean avail(int availN)
	{
		if(availN > 0)
			return true;
		return false;
	}

}
