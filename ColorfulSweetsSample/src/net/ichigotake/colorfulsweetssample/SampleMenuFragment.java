package net.ichigotake.colorfulsweetssample;

import net.ichigotake.colorfulsweets.lib.fragment.FragmentTransit;
import net.ichigotake.colorfulsweets.lib.menu.SimpleMenu;
import net.ichigotake.colorfulsweets.lib.menu.SimpleMenuListFactory;
import net.ichigotake.colorfulsweets.lib.view.ListItemOnClickListener;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class SampleMenuFragment extends Fragment {
	
	public static SampleMenuFragment newInstance() {
		return new SampleMenuFragment();
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle bundle) {
		View view = inflater.inflate(R.layout.simple_menu_list, null);
		
		ListView menuListView = (ListView) view.findViewById(R.id.menu_list);
		ListItemOnClickListener listener = new SampleMenuOnClickListener(getActivity());
		SimpleMenuListFactory menuFactory =
				new SimpleMenuListFactory(SampleMenu.values(), listener);
		menuFactory.show(getActivity(), menuListView);
		
		return view;
	}
	
	/**
	 * item list
	 */
	private enum SampleMenu implements SimpleMenu {

		SIMPLE_MENU(R.string.sample_menu_simple_menu),
		;

		final private int mTitle;

		private SampleMenu(int title) {
			mTitle = title;
		}

		@Override
		public int getLabelName() {
			return mTitle;
		}

		@Override
		public int getIconResource() {
			return 0; // non icon
		}

	}

	/**
	 * item on click listener
	 */
	private class SampleMenuOnClickListener implements ListItemOnClickListener {

		final private Context mContext;

		public SampleMenuOnClickListener(Context context) {
			mContext = context;
		}

		@Override
		public void onClick(View view, int position) {
			SampleMenu menu = SampleMenu.values()[position];
			switch (menu) {
			case SIMPLE_MENU:
				final Fragment nextFragment = SimpleMenuFragment.newInstance();
				transit(mContext, nextFragment);
				break;
			}
			
		}
		
		private void transit(Context context, Fragment nextFragment) {
			FragmentTransit.from(mContext).toReplace(R.id.content, nextFragment);
		}
		
	}
}