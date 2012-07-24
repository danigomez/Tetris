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
	
	private int colOffset;
	private int rowOffset;
	
	
	
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
	}
	
	public void onRotate()
	{
		//TODO Agregar el control para el bounding de las filas, es decir, q al rotar no se pase de los l�mites
		//del tablero hacia abajo o arriba

		int lBias = LayoutDrawHelper.getLeftBias(this);
		int rBias = LayoutDrawHelper.getRightBias(this);
		
		toLeftAvail += lBias - leftBias; //Si el bias actual es mayor al bias anterior, sumo la diferencia al avail nuevo
		toRigthAvail += rBias - rightBias;

		leftBias = lBias; //Columnas vacias q hay hasta llegar al tetrimino por izquierda
		rightBias = rBias;  //Columnas vacias q hay hasta llegar al tetrimino por derecha
		
	    rowOffset = fixOutRow();
	    colOffset = fixOutCol();
	}
	
	private int fixOutRow()
	{
		//TODO actualiza el bias vertical e indica con q offset se tiene q arreglar la fila de dibujado en el tablero
		return 0;
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
		else if(toRigthAvail >= TetrisConstants.TETRIS_COL)
		{
			ret = TetrisConstants.TETRIS_COL - toRigthAvail; //< 0
			toRigthAvail = 0;
			toLeftAvail = TetrisConstants.TETRIS_COL - getLayoutSize();
			
		}
		
		System.out.println("LEFT AVAIL -> " + toLeftAvail);
		System.out.println("RIGHT AVAIL -> " + toRigthAvail);
		
		return ret;
	}
	
	private boolean avail(int availN)
	{
		if(availN > 0)
			return true;
		return false;
	}

}
