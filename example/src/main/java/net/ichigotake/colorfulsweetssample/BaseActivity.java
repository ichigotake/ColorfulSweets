package net.ichigotake.colorfulsweetssample;

import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import net.ichigotake.colorfulsweets.lib.activity.ActivityTransit;
import net.ichigotake.colorfulsweets.lib.compat.activity.NavigationDrawerActivity;
import net.ichigotake.colorfulsweets.lib.menu.SimpleMenu;
import net.ichigotake.colorfulsweets.lib.menu.SimpleMenuListInitializer;
import net.ichigotake.colorfulsweets.lib.navigation.Drawer;
import net.ichigotake.colorfulsweets.lib.navigation.DummyDrawer;
import net.ichigotake.colorfulsweets.lib.navigation.NavigationDrawer;
import net.ichigotake.colorfulsweetssample.activity.ActivityTransitSampleActivity;
import net.ichigotake.colorfulsweetssample.fragment.viewpager.SimpleViewPagerFragmentSampleActivity;
import net.ichigotake.colorfulsweetssample.menu.SimpleMenuActivity;
import net.ichigotake.colorfulsweetssample.preference.PreferenceSampleActivity;
import net.ichigotake.colorfulsweetssample.view.paging.AutoPagingActivity;

public abstract class BaseActivity extends NavigationDrawerActivity {

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_navigation_drawer;
    }
    
    @Override
    protected Drawer createNavigationDrawer() {
        ListView menuListView = (ListView) findViewById(R.id.left_drawer);
        menuListView.setOnItemClickListener(new NavigationSampleOnClickListener(this));
        new SimpleMenuListInitializer(this).initialize(menuListView, NavigationSample.values());

        if (hasParentActivityIntent()) {
            return new DummyDrawer();
        } else {
            DrawerLayout mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
            return new NavigationDrawer(this, mDrawerLayout);
        }
    }
    
    /**
     * item list
     */
    private enum NavigationSample implements SimpleMenu {

        ACTIVITY_TRANSIT(R.string.sample_activity_transit_title),
        AUTO_PAGING(R.string.sample_menu_auto_paging),
        SIMPLE_MENU(R.string.sample_menu_simple_menu),
        SIMPLE_TAB_FRAGMENT_PAGER(R.string.sample_menu_tab_fragment_pager),
        PREFERENCE(R.string.sample_menu_preference),
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
    private class NavigationSampleOnClickListener implements AdapterView.OnItemClickListener {

        final private Context mContext;

        public NavigationSampleOnClickListener(Context context) {
            mContext = context;
        }

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            NavigationSample menu = NavigationSample.values()[position];
            switch (menu) {
                case ACTIVITY_TRANSIT:
                    ActivityTransit.from(mContext, ActivityTransitSampleActivity.class).toNext();
                    break;
                case AUTO_PAGING:
                    ActivityTransit.from(mContext, AutoPagingActivity.class).toNext();
                    break;
                case SIMPLE_MENU:
                    ActivityTransit.from(mContext, SimpleMenuActivity.class).toNext();
                    break;
                case SIMPLE_TAB_FRAGMENT_PAGER:
                    ActivityTransit.from(mContext, SimpleViewPagerFragmentSampleActivity.class).toNext();
                    break;
                case PREFERENCE:
                    ActivityTransit.from(mContext, PreferenceSampleActivity.class).toNext();
                    break;
            }
            
            NavigationDrawerActivity.closeNavigationDrawer(mContext);
        }
        
    }
    
}
