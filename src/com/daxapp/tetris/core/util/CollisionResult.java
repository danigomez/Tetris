package com.daxapp.tetris.core.util;

public class CollisionResult
{
	private boolean onRightCollision;
	private boolean onLeftCollision;
	private boolean onDownCollision;
	private boolean onRotateCollision;
	
	public CollisionResult()
	{
		onDownCollision = false;
		onLeftCollision = false;
		onRightCollision = false;
		onRotateCollision = false;
		
	}
	
	
	public boolean isRightCollision()
	{
		return onRightCollision;
	}
	
	public void setRightCollision(boolean rightCollision)
	{
		this.onRightCollision = rightCollision;
	}
	
	public boolean isLeftCollision()
	{
		return onLeftCollision;
	}
	
	public void setLeftCollision(boolean leftCollision)
	{
		this.onLeftCollision = leftCollision;
	}
	
	public boolean isDownCollision()
	{
		return onDownCollision;
	}
	
	public void setDownCollision(boolean downCollision)
	{
		this.onDownCollision = downCollision;
	}
	
	public boolean isRotatedCollision()
	{
		return onRotateCollision;
	}
	
	public void setRotatedCollision(boolean rotatedCollision)
	{
		this.onRotateCollision = rotatedCollision;
	}
	
	public String toString()
	{
		String ret = "";
		
		ret += "RIGHT COLLISION -> " + onRightCollision + "\n";
		ret +="LEFT COLLISION -> " + onLeftCollision + "\n";
		ret +="DOWN COLLISION -> " + onDownCollision + "\n";
		ret +="ROTO COLLISION -> " + onRotateCollision;
		
		return ret;
	}

}
