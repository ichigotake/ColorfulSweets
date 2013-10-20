package net.ichigotake.colorfulsweets.lib.menu;

import java.util.List;

import android.content.Context;
import android.widget.ListView;

/**
 * API level 1
 *
 */
public interface MenuItemListFactory {

	public List<MenuItem> create();
	
	public void show(Context context, ListView listView);
}
