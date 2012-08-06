package com.daxapp.tetris.factory;

import java.util.ResourceBundle;

import com.daxapp.tetris.core.Tetrimino;

public class TetriminoFactory
{
	private static ResourceBundle bundle;
	public static Tetrimino createTetriminoByType(int type)
	{
		if(bundle == null)
			bundle = ResourceBundle.getBundle("resources/tetramines");
		
		Tetrimino ret;
		try
		{
			ret = (Tetrimino)Class.forName(bundle.getString(type+"")).newInstance();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		} 
		
		return ret;
	}
}
