package com.daxapp.tetris.gui;

import javax.swing.JFrame;

import com.daxapp.tetris.core.util.ResourcesLoaderHelper;
import com.daxapp.tetris.gui.panel.TetrisPanel;
import com.daxapp.tetris.input.listener.InputHandler;


@SuppressWarnings("serial")
public class GraphicsInterface extends JFrame
{
	protected TetrisPanel boardPanel;
	protected InputHandler handler;
	protected String selectedPanel = "ASCII";
	//TODO este valor se toma de un menu dentro de la ventana
	//el valor que tiene es solo para prueba
	
	//TODO agregar un label con el puntaje y el nivel actual, separado del panel de dibujo del tablero
	public GraphicsInterface()
	{
		handler = new InputHandler();
		boardPanel = (TetrisPanel)ResourcesLoaderHelper.loadInstanceById(selectedPanel);
		
		this.addKeyListener(handler);
		this.setTitle(ResourcesLoaderHelper.loadPhraseById("APP_TITLE") + " " + ResourcesLoaderHelper.loadPhraseById("APP_VERSION"));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(boardPanel);
		this.pack();
		this.setVisible(true);
		this.setFocusable(true);
		this.setResizable(false);
		
	}

	

}
