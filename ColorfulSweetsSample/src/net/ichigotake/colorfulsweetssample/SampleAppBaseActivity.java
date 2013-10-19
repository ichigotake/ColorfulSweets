package net.ichigotake.colorfulsweetssample;

import net.ichigotake.colorfulsweets.lib.context.NavigationDrawerActivity;
import net.ichigotake.colorfulsweets.lib.menu.SimpleMenu;
import net.ichigotake.colorfulsweets.lib.menu.SimpleMenuListFactory;
import net.ichigotake.colorfulsweets.lib.navigation.NavigationDrawer;
import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public abstract class SampleAppBaseActivity extends NavigationDrawerActivity {

	@Override
	protected int getLayoutResource() {
		return R.layout.activity_navigation_drawer;
	}
	
	@Override
	protected NavigationDrawer createNavigationDrawer() {
		ListView menuListView = (ListView) findViewById(R.id.left_drawer);
		OnClickListener listener = new NavigationSampleOnClickListener(this);
		SimpleMenuListFactory menuFactory =
				new SimpleMenuListFactory(NavigationSample.values(), listener);
		menuFactory.show(this, menuListView);
		
		DrawerLayout mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		return new NavigationDrawer(this, mDrawerLayout);
	}
	
	/**
	 * item list
	 */
	private enum NavigationSample implements SimpleMenu {

		SMAPLE1(R.string.simple_menu_item_sample1, R.drawable.abc_ic_ab_back_holo_light),
		SMAPLE2(R.string.simple_menu_item_sample2, R.drawable.abc_ic_cab_done_holo_light),
		SMAPLE3(R.string.simple_menu_item_sample3, R.drawable.abc_ic_search),
		SMAPLE4(R.string.simple_menu_item_sample4, R.drawable.abc_ic_commit_search_api_holo_light),
		SMAPLE5(R.string.simple_menu_item_sample5, R.drawable.abc_ic_go),
		SMAPLE6(R.string.simple_menu_item_sample6, R.drawable.abc_ic_clear),
		;

		final private int mTitle;
		
		final private int mIcon;
		
		private NavigationSample(int title, int icon) {
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
	private class NavigationSampleOnClickListener implements OnClickListener {

		final private Context mContext;
		
		public NavigationSampleOnClickListener(Context context) {
			mContext = context;
		}
		@Override
		public void onClick(View view) {
			TextView itemView = (TextView) view;
			String message = new StringBuilder()
				.append("clicked navigation item: ")
				.append(itemView.getText().toString())
				.toString();
			Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
			NavigationDrawerActivity.closeNavigationDrawer(mContext);
		}
		
	}

}
