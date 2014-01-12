package net.ichigotake.colorfulsweets.lib.compat.activity;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;

import com.google.common.base.Optional;

import net.ichigotake.colorfulsweets.R;
import net.ichigotake.colorfulsweets.lib.compat.actionbar.ActionBarSetting;
import net.ichigotake.colorfulsweets.lib.navigation.Drawer;
import net.ichigotake.colorfulsweets.lib.navigation.DummyDrawer;
import net.ichigotake.colorfulsweets.lib.navigation.NavigationDrawer;
import net.ichigotake.colorfulsweets.lib.view.inputmethod.SoftInput;

/**
 * API level 7
 * 
 * 
 */
public abstract class NavigationDrawerActivity extends ActionBarActivity {

    private Drawer mDrawer;
    
    /**
     * API level 1
     * 
     * The identifier for resource to {@link android.app.Activity#setContentView(int)} .
     * @return
     */
    abstract protected int getLayoutResource();
    
    /**
     * API level 4
     * 
     * Create {@link NavigationDrawer} .
     * @return
     */
    abstract protected Optional<Drawer> createNavigationDrawer();
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SoftInput.alwaysHidden(this);
        setContentView(getLayoutResource());

        final Optional<Drawer> drawer = createNavigationDrawer();
        mDrawer = drawer.or(new DummyDrawer());
        ActionBarSetting.withHomeUpAsEnabled(getSupportActionBar(), R.string.app_name);

    }
    
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawer.onPostCreate();
    }
    
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawer.onConfigurationChanged(newConfig);
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if (hasParentActivityIntent()) {
                    NavUtils.navigateUpFromSameTask(this);
                    finish();
                    return true;
                }
        }
        
        if (mDrawer.onOptionsItemSelected(item)) {
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
        mDrawer.close();
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


    protected boolean hasParentActivityIntent() {
        return null != getSupportParentActivityIntent();
    }

}
