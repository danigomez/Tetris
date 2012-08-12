package com.daxapp.tetris.gui.panel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;



@SuppressWarnings("serial")
public class TetrisPanel extends JPanel
{
	protected String toDraw="";
	public TetrisPanel()
	{
		setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
	
	public void setToDraw(String draw)
	{
		toDraw = draw;
		
	}

	 public Dimension getPreferredSize() 
	 {
		return new Dimension(200,400);
	 }
	 

}
