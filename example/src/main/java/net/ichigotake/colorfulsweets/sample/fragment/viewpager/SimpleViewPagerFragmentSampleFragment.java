package net.ichigotake.colorfulsweets.sample.fragment.viewpager;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;

import net.ichigotake.colorfulsweets.appcompat.fragment.viewpager.SimpleViewPagerFragment;
import net.ichigotake.colorfulsweets.appcompat.fragment.viewpager.SimpleViewPagerTab;
import net.ichigotake.colorfulsweets.sample.R;


public class SimpleViewPagerFragmentSampleFragment extends SimpleViewPagerFragment {

    public static SimpleViewPagerFragmentSampleFragment newInstance() {
        return new SimpleViewPagerFragmentSampleFragment();
    }

    @Override
    public SimpleViewPagerTab createSimpleViewPagerTab(View view) {
        return new SimpleViewPagerTabSample(view);
    }
    
    /**
     * Sample for {@link SimpleViewPagerTab}
     */
    private class SimpleViewPagerTabSample extends SimpleViewPagerTab {

        final private Context mContext;
        
        SimpleViewPagerTabSample(View view) {
            super(view);
            mContext = view.getContext();
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public String getTitle(int position) {
            return mContext.getString(R.string.sample_menu_tab_fragment_pager_item, position);
        }

        @Override
        public Fragment getItem(int position) {
            return SimplePagerPageFragment.newInstance(position);
        }

    }
}
