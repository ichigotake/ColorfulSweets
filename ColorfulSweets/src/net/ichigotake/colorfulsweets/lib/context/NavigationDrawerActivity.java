package net.ichigotake.colorfulsweets.lib.context;

import net.ichigotake.colorfulsweets.R;
import net.ichigotake.colorfulsweets.lib.actionbar.ActionBarSetting;
import net.ichigotake.colorfulsweets.lib.navigation.NavigationDrawer;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;

/**
 * API level 7
 * 
 * 
 */
public abstract class NavigationDrawerActivity extends ActionBarActivity {

	private ActionBarDrawerToggle mDrawerToggle;
	
	private NavigationDrawer mNavigationDrawer;
	
	/**
	 * API level 1
	 * 
	 * The identifier for resource to {@link Activity#setContentView(int)} .
	 * @return
	 */
	abstract protected int getLayoutResource();
	
	/**
	 * API level 4
	 * 
	 * Create {@link NavigationDrawer} .
	 * @return
	 */
	abstract protected NavigationDrawer createNavigationDrawer();
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(getLayoutResource());
		
		ActionBarSetting.withHomeUpAsEnabled(getSupportActionBar(), R.string.app_name);
		
		mNavigationDrawer = createNavigationDrawer();
		mDrawerToggle = mNavigationDrawer.getToggle();
		
	}
	
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		mDrawerToggle.syncState();
	}
	
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		mDrawerToggle.onConfigurationChanged(newConfig);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		
		return super.onOptionsItemSelected(item);
	}
	
	/**
	 * API level 7
	 * 
	 * Close navigation drawer.
	 */
	public void closeNavigationDrawer() {
		mNavigationDrawer.close();
	}
	
	/**
	 * API level 7
	 * 
	 * Close navigation drawer.
	 * @param context
	 */
	public static void closeNavigationDrawer(Context context) {
		if (context instanceof NavigationDrawerActivity) {
			NavigationDrawerActivity activity = (NavigationDrawerActivity) context;
			activity.closeNavigationDrawer();
		}
	}
}
