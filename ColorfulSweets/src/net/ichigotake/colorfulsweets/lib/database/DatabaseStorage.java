package net.ichigotake.colorfulsweets.lib.database;

import android.content.Context;

/**
 * API level 1
 * 
 * The database storage interface.
 * 
 * TODO document for method.
 */
public interface DatabaseStorage {

	public Context getContext();
	
	public String getName();
	
	public int getVersion();
	
	public boolean isExists();
}
