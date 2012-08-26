package com.daxapp.tetris.gui.menu;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import com.daxapp.tetris.core.util.ResourcesLoaderHelper;
import com.daxapp.tetris.gui.GraphicsInterface;

public class OptionsMenu extends JMenu
{
	private JMenuItem newGameItem;
	public OptionsMenu(String label)
	{
		super(ResourcesLoaderHelper.loadPhraseById(label));
		newGameItem = new JMenuItem(ResourcesLoaderHelper.loadPhraseById("NEW_GAME"));
		this.add(newGameItem);
	}
	
	public void setListenerClass(GraphicsInterface graphicsInterface)
	{		
		newGameItem.addActionListener(graphicsInterface);
		
	}

}
