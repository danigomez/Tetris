package com.daxapp.tetris.gui;

import javax.swing.JFrame;

import com.daxapp.tetris.core.util.ResourcesLoaderHelper;
import com.daxapp.tetris.gui.panel.ASCIIPanel;
import com.daxapp.tetris.gui.panel.TetrisPanel;
import com.daxapp.tetris.input.listener.InputHandler;


@SuppressWarnings("serial")
public class GraphicsInterface extends JFrame
{
	protected TetrisPanel panel;
	protected InputHandler handler;
	
	public GraphicsInterface()
	{
		handler = new InputHandler();
		panel = new ASCIIPanel(); //TODO Levantar un ASCIIPanel o un TexturePanel segun se elija!
		
		this.addKeyListener(handler);
		this.setTitle(ResourcesLoaderHelper.loadPhraseById("APP_TITLE") + " " + ResourcesLoaderHelper.loadPhraseById("APP_VERSION"));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(panel);
		this.pack();
		this.setVisible(true);
		this.setFocusable(true);
		this.setResizable(false);
		
	}

	

}
