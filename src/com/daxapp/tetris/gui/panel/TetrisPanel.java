package com.daxapp.tetris.gui.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import com.daxapp.tetris.core.util.ResourcesLoaderHelper;



@SuppressWarnings("serial")
public abstract class TetrisPanel extends JPanel
{
	protected String toDraw="";
	protected String points="";
	protected String level="";
	protected String lines ="";
	protected int colDraw;
	
	private String nextTetrimino;
	private String holdTetrimino;
	
	protected abstract void paintNext(Graphics g,String tetrimino,int x, int y);
	
	public TetrisPanel()
	{
		setBorder(BorderFactory.createLineBorder(Color.black));
		colDraw = 250;
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
		//Imprimo la info del juego actual!
		g.drawString(ResourcesLoaderHelper.loadPhraseById("POINTS") + points +"\n", colDraw, 45);
		g.drawString(ResourcesLoaderHelper.loadPhraseById("LEVEL") + level +"\n", colDraw, 65);
		g.drawString(ResourcesLoaderHelper.loadPhraseById("LINES") + lines , colDraw, 85);

		
		g.drawString(ResourcesLoaderHelper.loadPhraseById("HOLD") , colDraw, 125);
		if(holdTetrimino != null)
		{
			paintNext(g, holdTetrimino, 290,135);
		}
		if(nextTetrimino != null)
		{
			g.drawString(ResourcesLoaderHelper.loadPhraseById("NEXT") , colDraw, 245);
			paintNext(g, nextTetrimino,290,250);
		}
		
	}
	
	public Dimension getPreferredSize() 
	{
		return new Dimension(400,400);
	}


	public void setNextTetrimino(String next)
	{
		nextTetrimino = next;
		
	}
	
	public void setHoldTetrimo(String hold)
	{
		holdTetrimino = hold;
	}
	 

}
