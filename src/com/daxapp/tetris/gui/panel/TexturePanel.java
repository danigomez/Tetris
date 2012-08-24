package com.daxapp.tetris.gui.panel;

import java.awt.Graphics;

/*PRIORIDAD*/
//TODO Levantar imagenes de cada bloque del tetrimino y dibuja el tetrimino y el tablero!!
//Averiguar como cargar imagenes con Swing!!!

public class TexturePanel extends TetrisPanel
{
	public void paint(Graphics g)
	{
		super.paint(g);
		g.drawString("TEXTURE PANEL",70, 80);
	
	}
}
