package net.ichigotake.colorfulsweets.appcompat.fragment.viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.ichigotake.colorfulsweets.appcompat.R;

/**
 * API level 7
 * 
 */
public abstract class SimpleViewPagerFragment extends Fragment {

    public abstract SimpleViewPagerTab createSimpleViewPagerTab(View view);
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_pager, null);
        
        ViewPagerTab tab = createSimpleViewPagerTab(view);
        TabFragmentPagerAdapter.initialize(getChildFragmentManager(), tab);
        
        return view;
    }
    
}
