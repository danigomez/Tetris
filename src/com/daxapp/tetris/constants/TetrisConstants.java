package com.daxapp.tetris.constants;

import com.daxapp.tetris.core.util.ResourcesLoaderHelper;


public interface TetrisConstants
{
	public static final int TETRAMINE_TYPES = 7; //Indica la candidad de tipos de tetraminos q pueden ser generados
	public static final int TETRIS_COL = 10;
	public static final int BIAS = 1;
	public static final int TETRIS_ROW = 18 + BIAS;
	public static final int NO_DATA = 0;
	public static final int BLOCK = 1;
	public static final int FPS = Integer.parseInt(ResourcesLoaderHelper.loadResourcesById("FPS"));
	public static final int HOLD_TIME_TO_STEP = Integer.parseInt(ResourcesLoaderHelper.loadResourcesById("HOLD_TIME_TO_STEP"));
	// Cuantos frames hay q esperar para q baje un paso por gravedad
	
}
