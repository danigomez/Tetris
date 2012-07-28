package com.daxapp.tetris.core.util;

public class CollisionResult
{
	private boolean rightCollision;
	private boolean leftCollision;
	private boolean downCollision;
	
	public CollisionResult()
	{
		rightCollision = leftCollision = downCollision = false;
		
	}
	
	
	public boolean isRightCollision()
	{
		return rightCollision;
	}
	
	public void setRightCollision(boolean rightCollision)
	{
		this.rightCollision = rightCollision;
	}
	
	public boolean isLeftCollision()
	{
		return leftCollision;
	}
	
	public void setLeftCollision(boolean leftCollision)
	{
		this.leftCollision = leftCollision;
	}
	
	public boolean isDownCollision()
	{
		return downCollision;
	}
	
	public void setDownCollision(boolean downCollision)
	{
		this.downCollision = downCollision;
	}
	
	

}
