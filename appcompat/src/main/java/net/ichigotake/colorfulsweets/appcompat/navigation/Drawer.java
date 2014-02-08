package net.ichigotake.colorfulsweets.appcompat.navigation;

import android.content.res.Configuration;
import android.view.MenuItem;

public interface Drawer {
    void close();

    void onPostCreate();

    void onConfigurationChanged(Configuration newConfig);

    boolean onOptionsItemSelected(MenuItem item);
}
