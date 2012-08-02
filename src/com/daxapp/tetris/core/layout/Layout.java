package com.daxapp.tetris.core.layout;

public class Layout
{
	private int[][] layout;
	private int n;
	

	public Layout(int[][] l)
	{
		layout = l;
		n = layout.length;
	}

	public int getLayoutSize()
	{
		return n;
	}

	public int getAtPos(int row,int col)
	{
		return layout[row][col];
	}
	
	public void rotate()
	{
		int [][] aux = new int[n][n];
		for(int i = 0;i < n;i++)
		{
			for(int j = 0; j < n;j++)
			{
				
				//Rotacion de la forma (xr,yr) = (-y, x) + (xc,yc) 
				//Ejemplo:
				//(0,0) en la matriz, se centra, restando el centro de la matriz (1,1)
				//(-1,-1) => rotado da (1,-1), sumando el centro nuevamente da (2,0) 
				//Por lo tanto la rotacion de (0,0) es (2,0) en la matriz
				int r = -j + n - 1;
				int c = i;
				aux[i][j] = layout[r][c];
				
			}
		}
		
		layout = aux;
			
	}
	
	public void unrotate()
	{
		int [][] aux = new int[n][n];
		for(int i = 0;i < n;i++)
		{
			for(int j = 0; j < n;j++)
			{
				
				//Rotacion de la forma (xr,yr) = (-y, x) + (xc,yc) 
				//Ejemplo:
				//(0,0) en la matriz, se centra, restando el centro de la matriz (1,1)
				//(-1,-1) => rotado da (1,-1), sumando el centro nuevamente da (2,0) 
				//Por lo tanto la rotacion de (0,0) es (2,0) en la matriz
				int r = j;
				int c = -i + n - 1;
				
				aux[i][j] = layout[r][c];
				
			}
		}
		
		layout = aux;
			
	}

	public String toString()
	{
		String s = "";
		for(int i = 0;i < n;i++)
		{
			for(int j = 0; j < n;j++)
			{
				s+= layout[i][j] + " ";
				
			}
			s+="\n";
		}
		return s;
	}
	
	public int[][] getLayoutMatrix()
	{
		return layout;
	}
}