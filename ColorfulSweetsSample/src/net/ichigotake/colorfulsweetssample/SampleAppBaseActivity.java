package net.ichigotake.colorfulsweetssample;

import net.ichigotake.colorfulsweets.lib.context.NavigationDrawerActivity;
import net.ichigotake.colorfulsweets.lib.fragment.FragmentTransit;
import net.ichigotake.colorfulsweets.lib.menu.SimpleMenu;
import net.ichigotake.colorfulsweets.lib.menu.SimpleMenuListFactory;
import net.ichigotake.colorfulsweets.lib.navigation.NavigationDrawer;
import net.ichigotake.colorfulsweets.lib.view.ListItemOnClickListener;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.ListView;

public abstract class SampleAppBaseActivity extends NavigationDrawerActivity {

	@Override
	protected int getLayoutResource() {
		return R.layout.activity_navigation_drawer;
	}
	
	@Override
	protected NavigationDrawer createNavigationDrawer() {
		ListView menuListView = (ListView) findViewById(R.id.left_drawer);
		ListItemOnClickListener listener = new NavigationSampleOnClickListener(this);
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

		SIMPLE_MENU(R.string.sample_menu_simple_menu),
		;

		final private int mTitle;

		private NavigationSample(int title) {
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
	private class NavigationSampleOnClickListener implements ListItemOnClickListener {

		final private Context mContext;

		public NavigationSampleOnClickListener(Context context) {
			mContext = context;
		}

		@Override
		public void onClick(View view, int position) {
			NavigationSample menu = NavigationSample.values()[position];
			switch (menu) {
			case SIMPLE_MENU:
				final Fragment nextFragment = SimpleMenuFragment.newInstance();
				transit(mContext, nextFragment);
				break;
			}
			
			NavigationDrawerActivity.closeNavigationDrawer(mContext);
		}
		
		private void transit(Context context, Fragment nextFragment) {
			FragmentTransit.from(mContext).toReplace(R.id.content, nextFragment);
		}
	}
	
}
