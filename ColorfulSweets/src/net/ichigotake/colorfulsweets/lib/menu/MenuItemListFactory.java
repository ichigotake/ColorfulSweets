package net.ichigotake.colorfulsweets.lib.menu;

import android.content.Context;
import android.widget.ListView;

import java.util.List;

/**
 * API level 1
 *
 */
public interface MenuItemListFactory {

    public List<MenuItem> create();
    
    public void show(Context context, ListView listView);
}
