package com.daxapp.tetris.core.util;

import java.util.ResourceBundle;

//TODO tratar de optimizar la carga de bundles, q se cierren si no se usan
public class ResourcesLoaderHelper
{
	private static ResourceBundle cfgBundle;
	private static ResourceBundle phraseBundle;
	
	public static String loadResourcesById(String id)
	{
		return loadResource(id,cfgBundle,"resources/configuration/config");
	}
	 
	public static String loadPhraseById(String id)
	{
		return loadResource(id,phraseBundle,"resources/phrases/phrases");
	}
	
	private static String loadResource(String id,ResourceBundle bundle,String bundleName)
	{
		if(bundle == null)
			bundle = ResourceBundle.getBundle(bundleName);
		
		return bundle.getString(id);
	}
}
