package net.ichigotake.colorfulsweets.lib.fragment.viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * API level 4
 * 
 * The decorator of {@link FragmentPagerAdapter} .
 */
public class TabFragmentPagerAdapter extends FragmentPagerAdapter {
    
    final private ViewPagerTab mTab;
    
    /**
     * API level 4
     * 
     * Constructor
     * @param fragment
     * @param tab
     */
    private TabFragmentPagerAdapter(FragmentManager fragmentManager, ViewPagerTab tab) {
        super(fragmentManager);
        mTab = tab;
    }
    
    /**
     * API level 4
     * 
     * Factory method for initialize.
     * @param fragment
     * @param tab
     * @return
     */
    public static TabFragmentPagerAdapter initialize(FragmentManager fragmentManager, ViewPagerTab tab) {
        TabFragmentPagerAdapter adapter = new TabFragmentPagerAdapter(fragmentManager, tab);
        adapter.setupActionBar();
        return adapter;
    }
    
    /**
     * API level 4
     * 
     * Return the Fragment associated with a specified position.
     */
    @Override
    public Fragment getItem(int position) {
        return mTab.getItem(position);
    }

    /**
     * API level 4
     * 
     * Return the number of views available.
     * @return count the number of views available.
     */
    @Override
    public int getCount() {
        return mTab.getCount();
    }
    
    /**
     * API level 4
     * 
     * Return string to view pager tab title.
     * @param position the tab position
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return mTab.getTitle(position);
    }
    
    /**
     * API level 4
     * 
     * Action bar setting for view pager tab.
     */
    public void setupActionBar() {
        mTab.getViewPager().setAdapter(this);
        mTab.getPagerTabStrip().setDrawFullUnderline(true);
    }
    
}
