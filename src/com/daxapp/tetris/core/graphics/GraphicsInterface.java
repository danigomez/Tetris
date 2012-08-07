package com.daxapp.tetris.core.graphics;

import javax.swing.JFrame;

import com.daxapp.tetris.input.listener.InputHandler;

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
