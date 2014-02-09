package net.ichigotake.colorfulsweets.common.database;

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
