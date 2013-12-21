package net.ichigotake.colorfulsweetssample;

import net.ichigotake.colorfulsweets.lib.menu.SimpleMenu;
import net.ichigotake.colorfulsweets.lib.menu.SimpleSimpleMenuListFactory;
import net.ichigotake.colorfulsweets.lib.view.ListItemOnClickListener;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class SimpleMenuFragment extends Fragment {

	public static SimpleMenuFragment newInstance() {
		return new SimpleMenuFragment();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.simple_menu_list, null);
		
		ListView menuListView = (ListView) view.findViewById(R.id.menu_list);
		ListItemOnClickListener listener = new SimpleMenuSampleOnClickListener(getActivity());
		SimpleSimpleMenuListFactory menuFactory =
				new SimpleSimpleMenuListFactory(SimpleMenuSample.values(), listener);
		menuFactory.show(getActivity(), menuListView);
		
		return view;
	}

	/**
	 * item list
	 */
	private enum SimpleMenuSample implements SimpleMenu {

		SMAPLE1(R.string.simple_menu_item_sample1, R.drawable.abc_ic_ab_back_holo_light),
		SMAPLE2(R.string.simple_menu_item_sample2, R.drawable.abc_ic_cab_done_holo_light),
		SMAPLE3(R.string.simple_menu_item_sample3, R.drawable.abc_ic_search),
		SMAPLE4(R.string.simple_menu_item_sample4, R.drawable.abc_ic_commit_search_api_holo_light),
		SMAPLE5(R.string.simple_menu_item_sample5, R.drawable.abc_ic_go),
		SMAPLE6(R.string.simple_menu_item_sample6, R.drawable.abc_ic_clear),
		;

		final private int mTitle;
		
		final private int mIcon;
		
		private SimpleMenuSample(int title, int icon) {
			mTitle = title;
			mIcon = icon;
		}
		
		@Override
		public int getLabelName() {
			return mTitle;
		}

		@Override
		public int getIconResource() {
			return mIcon;
		}

	}

	/**
	 * item on click listener
	 */
	private class SimpleMenuSampleOnClickListener implements ListItemOnClickListener {

		final private Context mContext;

		public SimpleMenuSampleOnClickListener(Context context) {
			mContext = context;
		}

		@Override
		public void onClick(View view, int position) {
			TextView itemView = (TextView) view;
			String message = new StringBuilder().append("clicked item: ")
					.append(itemView.getText().toString()).toString();
			Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
		}
	}
}
