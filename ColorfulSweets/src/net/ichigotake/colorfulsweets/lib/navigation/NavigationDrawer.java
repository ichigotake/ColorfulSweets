package net.ichigotake.colorfulsweets.lib.navigation;

import net.ichigotake.colorfulsweets.R;
import android.app.Activity;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;

/**
 * API level 4
 * 
 * Navigation drawer
 */
public class NavigationDrawer {

	final private DrawerLayout mDrawerLayout;
	
	final private ActionBarDrawerToggle mDrawerToggle;
	
	/**
	 * API level 4
	 * 
	 * Constructor
	 * @param activity
	 * @param drawerLayout
	 */
	public NavigationDrawer(Activity activity, DrawerLayout drawerLayout) {
		mDrawerLayout = drawerLayout;
		mDrawerToggle = new ActionBarDrawerToggle(
				activity,
				drawerLayout,
				R.drawable.ic_drawer,
				R.string.navigation_drawer_open,
				R.string.navigation_drawer_close);
		mDrawerLayout.setDrawerListener(mDrawerToggle);
	}
	
	public ActionBarDrawerToggle getToggle() {
		return mDrawerToggle;
	}
	
	/**
	 * API level 4
	 * 
	 * Close navigation drawer
	 */
	public void close() {
		mDrawerLayout.closeDrawers();
	}
	
}
