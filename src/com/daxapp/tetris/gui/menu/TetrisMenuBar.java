package com.daxapp.tetris.gui.menu;

import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import com.daxapp.tetris.constants.TetrisConstants;
import com.daxapp.tetris.core.util.ResourcesLoaderHelper;
import com.daxapp.tetris.gui.GraphicsInterface;

//Barra del menú de la ventana, tiene el menú gráfico(por ahora)
public class TetrisMenuBar extends JMenuBar
{
	private TetrisMenuItem asciiItem;
	private TetrisMenuItem textureItem;
	private JMenu graphicsMenu; 
	//TODO que sea una hash de menus, de String -> TetrisMenu, esto para desde afuera de la clase
	//poder tomar cualquier menu y sus estados...
	
	public TetrisMenuBar()
	{
		graphicsMenu = new JMenu(ResourcesLoaderHelper.loadPhraseById("tGRAPH"));
		
		ButtonGroup group = new ButtonGroup();
		
		asciiItem = new TetrisMenuItem("ASCII");
		textureItem = new TetrisMenuItem("TEXTURE");
		
		if(TetrisConstants.START_GRAPH_MODE.equals("ASCII"))
			asciiItem.setSelected(true);
		if(TetrisConstants.START_GRAPH_MODE.equals("TEXTURE"))
			textureItem.setSelected(true); 
		
		group.add(asciiItem);
		group.add(textureItem);
		
		graphicsMenu.add(asciiItem);
		graphicsMenu.add(textureItem);
		this.add(graphicsMenu);
	}
	
	public JMenu getMenu()
	{
		return graphicsMenu;
	}

	public void setListenerClass(GraphicsInterface graphicsInterface)
	{
		asciiItem.addItemListener(graphicsInterface);
		textureItem.addItemListener(graphicsInterface);
		
	}
	
//	private void setGraphStatus(ArrayList<TetrisMenuItem> list)
//	{
//
//		for(TetrisMenuItem item : list)
//		{
//			if(item.getPhraseId().equals(TetrisConstants.START_GRAPH_MODE))
//			{
//				item.setSelected(true);
//				break;
//			}
//		}
//	}
	
}
