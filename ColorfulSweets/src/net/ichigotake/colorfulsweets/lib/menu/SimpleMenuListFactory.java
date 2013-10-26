package net.ichigotake.colorfulsweets.lib.menu;

import java.util.ArrayList;
import java.util.List;

import net.ichigotake.colorfulsweets.lib.view.ListItemOnClickListener;
import android.content.Context;
import android.widget.ListView;

/**
 * API level 1
 */
public class SimpleMenuListFactory implements MenuItemListFactory {

	final private SimpleMenu[] mMenu;
	
	final private ListItemOnClickListener mListener;
	
	/**
	 * API level 1
	 * 
	 * @param menu
	 * @param listener
	 */
	public SimpleMenuListFactory(SimpleMenu[] menu, ListItemOnClickListener listener) {
		mMenu = menu;
		mListener = listener;
	}
	
	public SimpleMenuListFactory(SimpleMenu[] menu) {
		mMenu = menu;
		mListener = null;
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
	public void show(Context context, ListView listView) {
		MenuItemListAdapter adapter = new MenuItemListAdapter(context, create());
		listView.setAdapter(adapter);
		adapter.notifyDataSetChanged();
	}
	

}
