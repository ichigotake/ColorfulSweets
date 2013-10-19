package net.ichigotake.colorfulsweetssample;

import java.util.List;

import net.ichigotake.colorfulsweets.lib.menu.SimpleMenu;
import net.ichigotake.colorfulsweets.lib.menu.MenuItem;
import net.ichigotake.colorfulsweets.lib.menu.SimpleMenuListFactory;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
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
		OnClickListener listener = new SimpleMenuSampleOnClickListener(getActivity());
		SimpleMenuListFactory menuFactory = new SimpleMenuListFactory(SimpleMenuSample.values(), listener);
		menuFactory.show(getActivity(), menuListView);
		
		return view;
	}

	/**
	 * item list
	 */
	private enum SimpleMenuSample implements SimpleMenu {

		SMAPLE1(R.string.simple_menu_item_sample1),
		SMAPLE2(R.string.simple_menu_item_sample2),
		SMAPLE3(R.string.simple_menu_item_sample3),
		SMAPLE4(R.string.simple_menu_item_sample4),
		SMAPLE5(R.string.simple_menu_item_sample5),
		SMAPLE6(R.string.simple_menu_item_sample6),
		;

		final private int mTitle;

		private SimpleMenuSample(int title) {
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
	private class SimpleMenuSampleOnClickListener implements OnClickListener {

		final private Context mContext;

		public SimpleMenuSampleOnClickListener(Context context) {
			mContext = context;
		}

		@Override
		public void onClick(View view) {
			TextView itemView = (TextView) view;
			String message = new StringBuilder().append("clicked item: ")
					.append(itemView.getText().toString()).toString();
			Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
		}
	}
}
