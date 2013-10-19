package net.ichigotake.colorfulsweets.lib.menu;

import java.util.List;

import android.app.Activity;
import android.widget.ListView;

/**
 * API level 1
 *
 */
public interface MenuItemListFactory {

	public List<MenuItem> create();
	
	public void show(Activity activity, ListView listView);
}
