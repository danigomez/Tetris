package com.daxapp.tetris.gui.panel;

import java.awt.Graphics;

import com.daxapp.tetris.constants.TetrisConstants;

public class ASCIIPanel extends TetrisPanel
{
	public void paint(Graphics g)
	{
		super.paint(g);
		g.setFont(g.getFont().deriveFont(20f));
		int fontSize = g.getFont().getSize();
		
		int i = 19;
		int j = 45;

		for(String row : toDraw.split("\n"))
		{
			g.drawString(row + "\n",i,j);
			j += fontSize;
		}
		
	}

}
