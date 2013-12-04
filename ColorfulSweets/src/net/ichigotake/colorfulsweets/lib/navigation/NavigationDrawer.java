package net.ichigotake.colorfulsweets.lib.navigation;

import android.app.Activity;
import android.content.res.Configuration;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;

import net.ichigotake.colorfulsweets.R;

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

    public void onPostCreate() {
        mDrawerToggle.syncState();
    }

    public void onConfigurationChanged(Configuration newConfig) {
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        return mDrawerToggle.onOptionsItemSelected(item);
    }
}
