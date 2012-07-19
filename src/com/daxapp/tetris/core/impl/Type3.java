package com.daxapp.tetris.core.impl;

import com.daxapp.tetris.core.Tetrimino;
import com.daxapp.tetris.core.layout.Layout;

public class Type3 extends Tetrimino
{
	protected Layout getLayoutDefinition()	
	{
		return new Layout(new int[][]
		                  {{1,1},
						   {1,1}});
	}

}
