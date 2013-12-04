package net.ichigotake.colorfulsweets.lib.fragment.viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;

/**
 * API level 4
 * 
 * Contain tab state on view pager.
 */
public interface ViewPagerTab {

    public PagerTabStrip getPagerTabStrip();
    
    public String getTitle(int position);
    
    public ViewPager getViewPager();
    
    public void setFragmentPagerAdapter(FragmentPagerAdapter adapter);
    
    public int getCount();
    
    public Fragment getItem(int position);
}
