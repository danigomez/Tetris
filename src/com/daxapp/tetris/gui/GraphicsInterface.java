package com.daxapp.tetris.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JMenuItem;

import com.daxapp.tetris.constants.TetrisConstants;
import com.daxapp.tetris.core.util.ResourcesLoaderHelper;
import com.daxapp.tetris.gui.menu.TetrisCheckMenuItem;
import com.daxapp.tetris.gui.menu.TetrisMenuBar;
import com.daxapp.tetris.gui.panel.TetrisPanel;
import com.daxapp.tetris.input.listener.InputHandler;


@SuppressWarnings("serial")
public class GraphicsInterface extends JFrame implements ItemListener, ActionListener
{
	protected TetrisPanel boardPanel;
	protected TetrisMenuBar menuBar;
	
	protected InputHandler handler;
	protected String selectedPanel = TetrisConstants.START_GRAPH_MODE;
	protected boolean reset = true; //Indica que se debe comenzar el juego
	
	public GraphicsInterface()
	{
		handler = new InputHandler();
		menuBar = new TetrisMenuBar();
		boardPanel = (TetrisPanel)ResourcesLoaderHelper.loadInstanceById(selectedPanel);
		
		menuBar.setListenerClass(this);
		
		this.addKeyListener(handler);
		this.setTitle(ResourcesLoaderHelper.loadPhraseById("APP_TITLE") + " " + ResourcesLoaderHelper.loadPhraseById("APP_VERSION"));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(boardPanel);
		this.setJMenuBar(menuBar);
		
		this.pack();
		this.setVisible(true);
		this.setFocusable(true);
		this.setResizable(false);

		
	}
	
	//TODO a lo mejor puede ir en el MenuBar, seria más lógico ahí!
	public void itemStateChanged(ItemEvent e)
	{
		TetrisCheckMenuItem item = (TetrisCheckMenuItem)e.getItem();

		if(item.getState())
		{
			//Tomo la instancia del panel que se haya seleccionado en el menú
			boardPanel = (TetrisPanel)ResourcesLoaderHelper.loadInstanceById(((TetrisCheckMenuItem)item).getPhraseId());
			
			this.getContentPane().removeAll();
			this.add(boardPanel);
			this.pack();
		}
		
	}

	public void actionPerformed(ActionEvent e)
	{
		reset = true;
		
	}
	
	public boolean isReset()
	{
		return reset;
	}

	

}
