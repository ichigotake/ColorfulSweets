package net.ichigotake.colorfulsweets.lib.navigation;

import android.content.res.Configuration;
import android.view.MenuItem;

public class DummyDrawer implements Drawer {

    @Override
    public void close() {

    }

    @Override
    public void onPostCreate() {

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return false;
    }
}
