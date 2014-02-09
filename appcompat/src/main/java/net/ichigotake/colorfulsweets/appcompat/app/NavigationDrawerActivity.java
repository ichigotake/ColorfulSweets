package net.ichigotake.colorfulsweets.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;

import net.ichigotake.colorfulsweets.appcompat.R;
import net.ichigotake.colorfulsweets.appcompat.navigation.Drawer;
import net.ichigotake.colorfulsweets.appcompat.navigation.DummyDrawer;
import net.ichigotake.colorfulsweets.common.view.inputmethod.SoftInput;

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
    abstract protected Drawer createNavigationDrawer();

    private Drawer getDrawer() {
        if (mDrawer == null) {
            mDrawer = createNavigationDrawer();
            if (mDrawer == null) {
                mDrawer = new DummyDrawer();
            }
        }
        return mDrawer;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SoftInput.alwaysHidden(this);
        setContentView(getLayoutResource());

        ActionBarSetting.withHomeUpAsEnabled(getSupportActionBar(), R.string.app_name);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        getDrawer().onPostCreate();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        getDrawer().onConfigurationChanged(newConfig);
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

        if (getDrawer().onOptionsItemSelected(item)) {
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
        getDrawer().close();
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
