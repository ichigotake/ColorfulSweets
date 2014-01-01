package net.ichigotake.colorfulsweetssample;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.ListView;

import com.google.common.base.Optional;

import net.ichigotake.colorfulsweets.lib.context.ActivityTransit;
import net.ichigotake.colorfulsweets.lib.context.NavigationDrawerActivity;
import net.ichigotake.colorfulsweets.lib.fragment.FragmentTransit;
import net.ichigotake.colorfulsweets.lib.menu.SimpleMenu;
import net.ichigotake.colorfulsweets.lib.menu.SimpleMenuListFactory;
import net.ichigotake.colorfulsweets.lib.navigation.Drawer;
import net.ichigotake.colorfulsweets.lib.navigation.NavigationDrawer;
import net.ichigotake.colorfulsweets.lib.view.ListItemOnClickListener;
import net.ichigotake.colorfulsweetssample.context.ActivityTransitSampleActivity;
import net.ichigotake.colorfulsweetssample.fragment.viewpager.SimpleViewPagerFragmentSampleFragment;
import net.ichigotake.colorfulsweetssample.menu.SimpleMenuSampleFragment;

public abstract class BaseActivity extends NavigationDrawerActivity {

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_navigation_drawer;
    }
    
    @Override
    protected Optional<Drawer> createNavigationDrawer() {
        ListView menuListView = (ListView) findViewById(R.id.left_drawer);
        ListItemOnClickListener listener = new NavigationSampleOnClickListener(this);
        SimpleMenuListFactory menuFactory =
                new SimpleMenuListFactory(NavigationSample.values(), listener);
        menuFactory.show(this, menuListView);
        
        DrawerLayout mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        return Optional.of((Drawer)new NavigationDrawer(this, mDrawerLayout));
    }
    
    /**
     * item list
     */
    private enum NavigationSample implements SimpleMenu {

        ACTIVITY_TRANSIT(R.string.sample_activity_transit_title),
        SIMPLE_MENU(R.string.sample_menu_simple_menu),
        SIMPLE_TAB_FRAGMENT_PAGER(R.string.sample_menu_tab_fragment_pager),
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
    private class NavigationSampleOnClickListener implements ListItemOnClickListener {

        final private Context mContext;

        public NavigationSampleOnClickListener(Context context) {
            mContext = context;
        }

        @Override
        public void onClick(View view, int position) {
            NavigationSample menu = NavigationSample.values()[position];
            switch (menu) {
            case ACTIVITY_TRANSIT:
                ActivityTransit.from(mContext, ActivityTransitSampleActivity.class).toNext();
                break;
            case SIMPLE_MENU:
                transit(mContext, SimpleMenuSampleFragment.newInstance());
                break;
            case SIMPLE_TAB_FRAGMENT_PAGER:
                transit(mContext, SimpleViewPagerFragmentSampleFragment.newInstance());
                break;
            default:
                break;
            }
            
            NavigationDrawerActivity.closeNavigationDrawer(mContext);
        }
        
        private void transit(Context context, Fragment nextFragment) {
            FragmentTransit.from(mContext).toReplace(R.id.content, nextFragment);
        }
    }
    
}
