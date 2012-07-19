package com.daxapp.tetris.pool;

import java.util.ArrayList;
import java.util.List;

import com.daxapp.tetris.constants.TetrisConstants;
import com.daxapp.tetris.core.Tetrimino;
import com.daxapp.tetris.factory.TetriminoFactory;

public class TetriminoPool
{
	private List<Tetrimino> pool;
	
	public TetriminoPool()
	{
		pool = new ArrayList<Tetrimino>();
		for(int i = 0; i < TetrisConstants.TETRAMINE_TYPES;i++)
		{
			Tetrimino t = TetriminoFactory.createTetriminoByType(i);//Voy generando cada uno de los tetraminos
			pool.add(t);
		}
	}
	
	public Tetrimino getTetrimino()
	{
		int rand = (int)(Math.random()*10 % TetrisConstants.TETRAMINE_TYPES);
		//TODO Arreglar el random, hacer un LFSR de 64 bits
		return pool.get(rand);
	}
}
