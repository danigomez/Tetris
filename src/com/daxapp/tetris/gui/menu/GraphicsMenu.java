package com.daxapp.tetris.gui.menu;

import javax.swing.ButtonGroup;
import javax.swing.JMenu;

import com.daxapp.tetris.constants.TetrisConstants;
import com.daxapp.tetris.core.util.ResourcesLoaderHelper;
import com.daxapp.tetris.gui.GraphicsInterface;

public class GraphicsMenu extends JMenu
{
	private TetrisCheckMenuItem asciiItem;
	private TetrisCheckMenuItem textureItem;
	public GraphicsMenu(String label)
	{
		super(ResourcesLoaderHelper.loadPhraseById(label));
		ButtonGroup group = new ButtonGroup();
		asciiItem = new TetrisCheckMenuItem("ASCII");
		textureItem = new TetrisCheckMenuItem("TEXTURE");
		if(TetrisConstants.START_GRAPH_MODE.equals("ASCII"))
			asciiItem.setSelected(true);
		if(TetrisConstants.START_GRAPH_MODE.equals("TEXTURE"))
			textureItem.setSelected(true); 
		
		group.add(asciiItem);
		group.add(textureItem);
		
		
		this.add(asciiItem);
		this.add(textureItem);
		
	}
	
	public void setListenerClass(GraphicsInterface graphicsInterface)
	{
		asciiItem.addItemListener(graphicsInterface);
		textureItem.addItemListener(graphicsInterface);
		
	}
}
