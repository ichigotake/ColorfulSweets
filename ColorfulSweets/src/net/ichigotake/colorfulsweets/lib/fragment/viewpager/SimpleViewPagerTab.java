package net.ichigotake.colorfulsweets.lib.fragment.viewpager;

import net.ichigotake.colorfulsweets.R;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * API level 4
 * 
 * Contain tab state on view pager for simply interface.
 */
public abstract class SimpleViewPagerTab implements ViewPagerTab {

	final private ViewPager mViewPager;
	
	final private PagerTabStrip mPagerTabStrip;
	
	public SimpleViewPagerTab(View view) {
		mViewPager = (ViewPager) view.findViewById(R.id.pager);
		mPagerTabStrip = (PagerTabStrip) view.findViewById(R.id.pager_title_strip);
	}
	
	/**
	 * API level 4
	 * 
	 * Return the {@link ViewPaer} .
	 */
	public ViewPager getViewPager() {
		return mViewPager;
	}
	
	/**
	 * API level 4
	 * 
	 * Return the {@link PagerTabStrip} .
	 */
	public PagerTabStrip getPagerTabStrip() {
		return mPagerTabStrip;
	}
	
	/**
	 * API level 4
	 * 
	 * Set {@link FragmentPagerAdapter} to contains {@link ViewPager} .
	 */
	@Override
	public void setFragmentPagerAdapter(FragmentPagerAdapter adapter) {
		mViewPager.setAdapter(adapter);
	}
	
}
