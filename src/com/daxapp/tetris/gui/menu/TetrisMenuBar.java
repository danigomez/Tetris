package com.daxapp.tetris.gui.menu;

import javax.swing.JMenuBar;

import com.daxapp.tetris.gui.GraphicsInterface;

//TODO agregar un nuevo men� en donde se eliga la dificultad de inicio y un bot�n de start!
//Barra del men� de la ventana, tiene el men� gr�fico(por ahora)
public class TetrisMenuBar extends JMenuBar
{

	private GraphicsMenu graphicsMenu;
	private OptionsMenu optionsMenu;
	
	
	public TetrisMenuBar()
	{
		graphicsMenu = new GraphicsMenu("tGRAPH");
		optionsMenu = new OptionsMenu("tOPTIONS");

		this.add(optionsMenu);
		this.add(graphicsMenu);

	}

	public void setListenerClass(GraphicsInterface graphicsInterface)
	{
		graphicsMenu.setListenerClass(graphicsInterface);
		optionsMenu.setListenerClass(graphicsInterface);
		
	}
}
