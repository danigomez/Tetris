package com.daxapp.tetris.factory;

import java.util.ResourceBundle;

import com.daxapp.tetris.core.Tetrimino;

public class TetriminoFactory
{
	public static Tetrimino createTetriminoByType(int type)
	{
		ResourceBundle bundle = ResourceBundle.getBundle("resources/tetramines");
		
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
