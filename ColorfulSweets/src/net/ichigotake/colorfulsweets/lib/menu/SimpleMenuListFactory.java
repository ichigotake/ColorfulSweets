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

	final private SimpleMenu[] mMenu;
	
	final private OnClickListener mListener;
	
	/**
	 * API level 1
	 * 
	 * @param menu
	 * @param listener
	 */
	public SimpleMenuListFactory(SimpleMenu[] menu, OnClickListener listener) {
		mMenu = menu;
		mListener = listener;
	}
	
	/**
	 * API level 1
	 * 
	 */
	@Override
	public List<MenuItem> create() {
		final List<MenuItem> menus = new ArrayList<MenuItem>();
		
		int length = mMenu.length;
		for (int i=0; i<length; i++) {
			MenuItem item = new MenuItem(mMenu[i]);
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
		MenuItemListAdapter adapter = new MenuItemListAdapter(activity, create());
		listView.setAdapter(adapter);
		adapter.notifyDataSetChanged();
	}
	

}
