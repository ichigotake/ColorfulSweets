package net.ichigotake.colorfulsweets.appcompat.navigation;

import android.app.Activity;
import android.content.res.Configuration;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;

import net.ichigotake.colorfulsweets.appcompat.R;

/**
 * API level 4
 * 
 * Navigation drawer
 */
public class NavigationDrawer implements Drawer {

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
    
    /**
     * API level 4
     * 
     * Close navigation drawer
     */
    @Override
    public void close() {
        mDrawerLayout.closeDrawers();
    }

    @Override
    public void onPostCreate() {
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return mDrawerToggle.onOptionsItemSelected(item);
    }
}
