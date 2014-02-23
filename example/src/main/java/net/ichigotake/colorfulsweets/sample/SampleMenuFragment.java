package net.ichigotake.colorfulsweets.sample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import net.ichigotake.colorfulsweets.common.activity.ActivityTransit;
import net.ichigotake.colorfulsweets.common.menu.SimpleMenu;
import net.ichigotake.colorfulsweets.common.menu.SimpleMenuListInitializer;
import net.ichigotake.colorfulsweets.sample.activity.ActivityTransitSampleActivity;
import net.ichigotake.colorfulsweets.sample.fragment.viewpager.SimpleViewPagerFragmentSampleActivity;
import net.ichigotake.colorfulsweets.sample.menu.SimpleMenuActivity;
import net.ichigotake.colorfulsweets.sample.paging.AutoPagingActivity;
import net.ichigotake.colorfulsweets.sample.preference.PreferenceSampleActivity;

public class SampleMenuFragment extends Fragment {
    
    public static SampleMenuFragment newInstance() {
        return new SampleMenuFragment();
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle bundle) {
        View view = inflater.inflate(R.layout.simple_menu_list, null);
        
        ListView menuListView = (ListView) view.findViewById(R.id.menu_list);
        menuListView.setOnItemClickListener(new SampleMenuOnClickListener());
        new SimpleMenuListInitializer(getActivity()).initialize(menuListView, SampleMenu.values());

        return view;
    }
    
    /**
     * item list
     */
    private enum SampleMenu implements SimpleMenu {

        ACTIVITY_TRANSIT(R.string.sample_activity_transit_title),
        AUTO_PAGING(R.string.sample_menu_auto_paging),
        SIMPLE_MENU(R.string.sample_menu_simple_menu),
        SIMPLE_TAB_FRAGMENT_PAGER(R.string.sample_menu_tab_fragment_pager),
        PREFERENCE(R.string.sample_menu_preference),
        ;

        final private int mTitle;

        private SampleMenu(int title) {
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
    private class SampleMenuOnClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            SampleMenu menu = SampleMenu.values()[position];
            switch (menu) {
                case ACTIVITY_TRANSIT:
                    new ActivityTransit(getActivity(), ActivityTransitSampleActivity.class).transition();
                    break;
                case AUTO_PAGING:
                    new ActivityTransit(getActivity(), AutoPagingActivity.class).transition();
                    break;
                case SIMPLE_MENU:
                    new ActivityTransit(getActivity(), SimpleMenuActivity.class).transition();
                    break;
                case SIMPLE_TAB_FRAGMENT_PAGER:
                    new ActivityTransit(getActivity(), SimpleViewPagerFragmentSampleActivity.class).transition();
                break;
                case PREFERENCE:
                    new ActivityTransit(getActivity(), PreferenceSampleActivity.class).transition();
                break;
            }
            
        }

    }
}
