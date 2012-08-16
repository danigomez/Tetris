package com.daxapp.tetris.core.util;

import java.util.ResourceBundle;

//TODO tratar de optimizar la carga de bundles, q se cierren si no se usan
public class ResourcesLoaderHelper
{
	private static ResourceBundle cfgBundle;
	private static ResourceBundle phraseBundle;
	
	public static String loadResourcesById(String id)
	{
		return (String)loadResource(id,cfgBundle,"resources/configuration/config",false);
	}
	
	public static Object loadInstanceById(String id)
	{
		return loadResource(id,cfgBundle,"resources/configuration/config",true);
	}
	 
	public static String loadPhraseById(String id)
	{
		return (String)loadResource(id,phraseBundle,"resources/phrases/phrases",false);
	}
	
	private static Object loadResource(String id,ResourceBundle bundle,String bundleName,boolean instantiate)
	{
		if(bundle == null)
			bundle = ResourceBundle.getBundle(bundleName);
		if(instantiate)
		{
			try
			{
				return Class.forName(bundle.getString(id)).newInstance();
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		return bundle.getString(id);
	}
}
