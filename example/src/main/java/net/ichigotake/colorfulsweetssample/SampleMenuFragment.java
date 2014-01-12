package net.ichigotake.colorfulsweetssample;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import net.ichigotake.colorfulsweets.lib.activity.ActivityTransit;
import net.ichigotake.colorfulsweets.lib.fragment.FragmentTransit;
import net.ichigotake.colorfulsweets.lib.menu.SimpleMenu;
import net.ichigotake.colorfulsweets.lib.menu.SimpleMenuListInitializer;
import net.ichigotake.colorfulsweetssample.preference.PreferenceSampleFragment;

public class SampleMenuFragment extends Fragment {
    
    public static SampleMenuFragment newInstance() {
        return new SampleMenuFragment();
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle bundle) {
        View view = inflater.inflate(R.layout.simple_menu_list, null);
        
        ListView menuListView = (ListView) view.findViewById(R.id.menu_list);
        menuListView.setOnItemClickListener(new SampleMenuOnClickListener(getActivity()));
        new SimpleMenuListInitializer(getActivity()).initialize(menuListView, SampleMenu.values());

        return view;
    }
    
    /**
     * item list
     */
    private enum SampleMenu implements SimpleMenu {

        ACTIVITY_TRANSIT(R.string.sample_activity_transit_title),
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

        final private Context mContext;

        public SampleMenuOnClickListener(Context context) {
            mContext = context;
        }

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            SampleMenu menu = SampleMenu.values()[position];
            switch (menu) {
            case ACTIVITY_TRANSIT:
                new ActivityTransit(getActivity(), ActivityTransitSampleActivity.class).toNext();
                break;
            case SIMPLE_MENU:
                final Fragment nextFragment = SimpleMenuFragment.newInstance();
                transit(nextFragment);
                break;
            case SIMPLE_TAB_FRAGMENT_PAGER:
                transit(SimpleViewPagerFragmentSampleFragment.newInstance());
            break;
                case PREFERENCE:
                transit(PreferenceSampleFragment.newInstance());
                break;
            }
            
        }
        
        private void transit(Fragment nextFragment) {
            FragmentTransit.from(mContext).toReplace(R.id.content, nextFragment);
        }

    }
}
