package com.daxapp.tetris.input.listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener
{
	private int keyCode;
	public void keyPressed(KeyEvent event)
	{
		keyCode = event.getKeyCode();

	}

	public void keyReleased(KeyEvent event)
	{

	}

	public void keyTyped(KeyEvent event)
	{
		
	}
	
	public int getKeyPressed()
	{
		int aux = keyCode;
		keyCode = -1;
		return aux;
	}

}
