package com.daxapp.tetris.core.util;

import java.util.ResourceBundle;

public class ResourcesLoaderHelper
{
	private static ResourceBundle bundle;
	public static String loadResourcesById(String id)
	{
		if(bundle == null)
			bundle = ResourceBundle.getBundle("resources/configuration/config");
		
		return bundle.getString(id);
		
	}
}
