package com.daxapp.tetris.core.impl;

import com.daxapp.tetris.core.Tetrimino;
import com.daxapp.tetris.core.layout.Layout;

public class Type5 extends Tetrimino
{

	@Override
	protected Layout getLayoutDefinition()
	{
		return new Layout(new int[][]
		  		                  {{0,0,0},
		  						   {1,1,1},
		  						   {1,0,0}});
	}

}
