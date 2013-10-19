package net.ichigotake.colorfulsweets.lib.menu;

import java.util.List;

import net.ichigotake.colorfulsweets.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * API level 1
 * 
 * Shown menu list with {@link ArrayAdapter}
 * TODO replacement extends class {@link ArrayAdapter} to {@link BaseAdapter} ?
 */
public class MenuListAdapter extends ArrayAdapter<MenuItem> {
	
	final private LayoutInflater mInflater;
	
	final private int mItemLayoutRes;
	
	/**
	 * API level 1
	 * 
	 * Constructor
	 * @param context The current context.
	 * @param menus The shown menu list.
	 */
	public MenuListAdapter(Context context, List<MenuItem> menus) {
		this(context, R.layout.menu_item, menus);
	}
	
	/**
	 * API level 1
	 * 
	 * Constructor
	 * @param context The current context.
	 * The resource ID for a layout file containing a TextView to use when instantiating views.
	 * @param itemLayoutRes The resource ID for a layout file containing a {@link TextView} to use when instantiating views.
	 * @param menus The shown menu list from {@link MenuItem}
	 */
	public MenuListAdapter(Context context, int itemLayoutRes, List<MenuItem> menus) {
		super(context, itemLayoutRes, menus);
		mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mItemLayoutRes = itemLayoutRes;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = mInflater.inflate(mItemLayoutRes, null);
		}
		
		MenuItem item = getItem(position);
		
		TextView itemText = (TextView) convertView;
		if (item.isLabelNamePresent()) {
			itemText.setText(item.getLabelName().get());
		} else {
			itemText.setText(item.getDefaultLabelName());
		}
		
		itemText.setCompoundDrawablesWithIntrinsicBounds(item.getDefaultIcon(), 0, 0, 0);
		itemText.setOnClickListener(item.getOnClickListener());
		
		return convertView;
	}
	
}
