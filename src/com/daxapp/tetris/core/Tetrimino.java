package com.daxapp.tetris.core;

import com.daxapp.tetris.core.layout.Layout;

public abstract class Tetrimino
{
	protected Layout layout = getLayoutDefinition(); //Matriz representando a cada tetramino

	protected abstract Layout getLayoutDefinition();
	public void rotate()
	{
		layout.rotate();
	}
	
	public String toString()
	{
		return layout.toString();
	}
	
	public Layout getCurrentLayout()
	{
		return layout;
	}
	
	
}
