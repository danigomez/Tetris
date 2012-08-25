package com.daxapp.tetris.constants;

import com.daxapp.tetris.core.util.ResourcesLoaderHelper;


public interface TetrisConstants
{
	public static final int BIAS = 1;
	public static final int NO_DATA = 0;
	public static final int BLOCK = 1;
	public static final int FPS = Integer.parseInt(ResourcesLoaderHelper.loadResourcesById("FPS"));
	public static final int HOLD_TIME_TO_STEP = Integer.parseInt(ResourcesLoaderHelper.loadResourcesById("HOLD_TIME_TO_STEP"));
	
	public static final int TETRAMINE_TYPES = 7; //Indica la candidad de tipos de tetraminos q pueden ser generados
	public static final int TETRIS_COL = 10;
	public static final int TETRIS_ROW = 18 + BIAS;

	public static final int LINES_PER_LEVEL = 10; //Líneas que hay que hacer para cambiar de nivel
	public static final int HOLD_TIME_DECREMENT = 1; //Cuantos cuadros menos tarda el step por nivel
	
	/*Puntajes*/
	public static final int SIMPLE = 40;
	public static final int DOBLE = 100;
	public static final int TRIPlE = 300;
	public static final int TETRIS = 1200;
	public static final String START_GRAPH_MODE = "TEXTURE";
	
	/*ASCII*/
	
	public static String BLOCK_VO = "O";
	public static String NO_DATA_VO = "'";
	
	
}
