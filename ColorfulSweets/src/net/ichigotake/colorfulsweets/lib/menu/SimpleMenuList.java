package net.ichigotake.colorfulsweets.lib.menu;

import java.util.List;

import net.ichigotake.colorfulsweets.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ListView;

import com.google.common.base.Optional;


/**
 * API Level 1
 * Shown menu list.
 */
public class SimpleMenuList {

	final private Context mContext;
	
	private Optional<ListView> mListView = Optional.absent();
	
	/**
	 * API level 1
	 * @param context
	 */
	public SimpleMenuList(Context context) {
		mContext = context;
	}
	
	/**
	 * API level 1
	 * Set the {@link ListView} to display.
	 * @param listView
	 */
	public void setListView(ListView listView) {
		mListView = Optional.fromNullable(listView);
	}
	
	/**
	 * API level 1
	 * Shown menu list
	 * @param Menu item list
	 * @param anchor base {@link ListView}
	 * @param listItemLayout List item resource for {@link MenuItemListAdapter}
	 */
	public void show(List<MenuItem> menus, ListView anchor, int listItemLayout) {
		ListView listView = getListView();
		MenuItemListAdapter adapter = new MenuItemListAdapter(mContext, R.layout.menu_item, menus);
		listView.setAdapter(adapter);
		adapter.notifyDataSetChanged();
	}
	
	/**
	 * API level 1
	 * @return
	 */
	private ListView getListView() {
		final ListView listView;
		if (mListView.isPresent()) {
			listView = mListView.get();
		} else {
			listView = (ListView) LayoutInflater.from(mContext).inflate(R.layout.menu_list, null);
		}
		return listView;
	}
	
}
