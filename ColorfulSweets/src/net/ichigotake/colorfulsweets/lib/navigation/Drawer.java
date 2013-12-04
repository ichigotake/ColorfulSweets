package net.ichigotake.colorfulsweets.lib.navigation;

import android.content.res.Configuration;
import android.view.MenuItem;

/**
 * Created by ichigotake on 2013/12/05.
 */
public interface Drawer {
    void close();

    void onPostCreate();

    void onConfigurationChanged(Configuration newConfig);

    boolean onOptionsItemSelected(MenuItem item);
}
