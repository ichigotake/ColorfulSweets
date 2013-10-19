package net.ichigotake.colorfulsweets.lib.menu;

import java.util.ArrayList;
import java.util.List;

import android.view.View.OnClickListener;

public class SimpleMenuListFactory implements MenuItemListFactory {

	final private Menu[] mMenu;
	
	final private OnClickListener mListener;
	
	public SimpleMenuListFactory(Menu[] menu, OnClickListener listener) {
		mMenu = menu;
		mListener = listener;
	}
	
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

}
