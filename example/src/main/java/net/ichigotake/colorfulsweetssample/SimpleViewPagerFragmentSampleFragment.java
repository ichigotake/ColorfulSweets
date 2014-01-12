package net.ichigotake.colorfulsweetssample;

import net.ichigotake.colorfulsweets.lib.fragment.viewpager.SimpleViewPagerFragment;
import net.ichigotake.colorfulsweets.lib.fragment.viewpager.SimpleViewPagerTab;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;

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
