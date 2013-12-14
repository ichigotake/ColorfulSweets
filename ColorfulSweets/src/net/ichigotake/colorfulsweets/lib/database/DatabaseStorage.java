package net.ichigotake.colorfulsweets.lib.database;

/**
 * API level 1
 * 
 * The database storage interface.
 */
public interface DatabaseStorage {

    public String getName();
    
    public int getVersion();
    
    public boolean exists();
}
