package com.daxapp.tetris.gui.menu;

import javax.swing.JCheckBoxMenuItem;

import com.daxapp.tetris.core.util.ResourcesLoaderHelper;

public class TetrisCheckMenuItem extends JCheckBoxMenuItem
{
	private String key;
	public TetrisCheckMenuItem(String key)
	{
		super(ResourcesLoaderHelper.loadPhraseById(key));
		this.key = key;
	}
	
	public String getPhraseId()
	{
		return key;
	}
}
