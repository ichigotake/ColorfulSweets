package net.ichigotake.colorfulsweets.lib.menu;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.view.View.OnClickListener;
import android.widget.ListView;

/**
 * API level 1
 */
public class SimpleMenuListFactory implements MenuItemListFactory {

	final private Menu[] mMenu;
	
	final private OnClickListener mListener;
	
	/**
	 * API level 1
	 * 
	 * @param menu
	 * @param listener
	 */
	public SimpleMenuListFactory(Menu[] menu, OnClickListener listener) {
		mMenu = menu;
		mListener = listener;
	}
	
	/**
	 * API level 1
	 * 
	 */
	@Override
	public List<MenuListItem> create() {
		final List<MenuListItem> menus = new ArrayList<MenuListItem>();
		
		int length = mMenu.length;
		for (int i=0; i<length; i++) {
			MenuListItem item = new MenuListItem(mMenu[i]);
			item.setOnClickListener(mListener);
			menus.add(item);
		}
		
		return menus;
	}

	/**
	 * API level 1
	 * 
	 * Show the menu.
	 */
	@Override
	public void show(Activity activity, ListView listView) {
		MenuListAdapter adapter = new MenuListAdapter(activity, create());
		listView.setAdapter(adapter);
		adapter.notifyDataSetChanged();
	}
	

}
