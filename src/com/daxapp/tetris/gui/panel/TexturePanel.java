package com.daxapp.tetris.gui.panel;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import com.daxapp.tetris.constants.TetrisConstants;

/*PRIORIDAD*/
//TODO Levantar imagenes de cada bloque del tetrimino y dibuja el tetrimino y el tablero!!
//Averiguar como cargar imagenes con Swing!!!

public class TexturePanel extends TetrisPanel
{
	private Image block = null;
	private Image no_data = null;
	private int height;
	private int width; 
	public TexturePanel()
	{
		try
		{
			block = new ImageIcon(this.getClass().getResource("/resources/images/block.png")).getImage();
			no_data = new ImageIcon(this.getClass().getResource("/resources/images/no_data.png")).getImage();
			height = block.getHeight(this);
			width = block.getWidth(this);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		
		
		int x = 19;
		int y = 45;
		for(String row : toDraw.split("\n"))
		{
			for(int i = 0; i < row.length(); i++)
			{
				String data  = String.valueOf(row.charAt(i));
				
				if(data.equals(TetrisConstants.BLOCK_VO))
					g.drawImage(block,x, y,this);
				else if(data.equals(TetrisConstants.NO_DATA_VO))
					g.drawImage(no_data,x, y,this);
				else
					continue;
				
				x += width;
			}
			x = 19;
			y += height;

		}
	}
}
