package com.daxapp.tetris.core.graphics;

import javax.swing.JFrame;

import com.daxapp.tetris.input.listener.InputHandler;


//TODO Empezar a hacer la parte grafica con Canvas y Swing
@SuppressWarnings("serial")
public class GraphicsInterface extends JFrame
{
	protected InputHandler handler;
	public GraphicsInterface()
	{
		this.setVisible(true);
		this.setFocusable(true);
		handler = new InputHandler();
		addKeyListener(handler);
		
	}

}
