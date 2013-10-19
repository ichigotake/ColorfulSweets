package net.ichigotake.colorfulsweets.lib.navigation;

import java.util.List;

import net.ichigotake.colorfulsweets.lib.menu.Menu;
import net.ichigotake.colorfulsweets.lib.menu.MenuListAdapter;
import net.ichigotake.colorfulsweets.lib.menu.MenuListItem;
import net.ichigotake.colorfulsweets.lib.menu.SimpleMenuListFactory;
import android.app.Activity;
import android.view.View.OnClickListener;
import android.widget.ListView;

/**
 * API level 1
 */
public class SimpleNavigationListFactory {

	final private Activity mActivity;
	
	/**
	 * API level 1
	 * 
	 * Constructor
	 * @param activity
	 */
	public SimpleNavigationListFactory(Activity activity) {
		mActivity = activity;
	}
	
	/**
	 * API level 1
	 * 
	 * @param menuListView
	 * @param menu
	 * @param listener
	 */
	public void create(ListView menuListView, Menu[] menu, OnClickListener listener) {
		List<MenuListItem> menuList = new SimpleMenuListFactory(menu, listener).create();
		MenuListAdapter adapter = new MenuListAdapter(mActivity, menuList);
		menuListView.setAdapter(adapter);
		adapter.notifyDataSetChanged();
	}
	
}
