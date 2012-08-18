package com.daxapp.tetris.gui.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;



@SuppressWarnings("serial")
public class TetrisPanel extends JPanel
{
	protected String toDraw="";
	protected String points="";
	protected String level="";
	protected String lines ="";
	
	public TetrisPanel()
	{
		setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
	
	public void setToDraw(String draw)
	{
		toDraw = draw;
		
	}
	
	public void setPoints(String points)
	{
		this.points = points;
	}

	public void setLevel(String level)
	{
		this.level = level;
	}
	
	public void setLines(String lines)
	{
		this.lines = lines;
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		
		g.setFont(g.getFont().deriveFont(20f));

		g.drawString("Puntos:" + points +"\n\n", 250, 45);
		g.drawString("Nivel:" + level +"\n\n", 250, 65);
		g.drawString("Lineas:" + lines , 250, 85);
	}
	
	public Dimension getPreferredSize() 
	{
		return new Dimension(400,400);
	}
	 

}
