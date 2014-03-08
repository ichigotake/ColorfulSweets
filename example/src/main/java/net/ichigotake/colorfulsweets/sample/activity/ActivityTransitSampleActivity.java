package net.ichigotake.colorfulsweets.sample.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.ichigotake.colorfulsweets.appcompat.fragment.FragmentTransit;
import net.ichigotake.colorfulsweets.sample.ActionBar;
import net.ichigotake.colorfulsweets.sample.BaseActivity;
import net.ichigotake.colorfulsweets.sample.R;

/**
 * Sample for {@link ActivityTransit}
 */
public class ActivityTransitSampleActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new FragmentTransit(this)
                .setAddBackStack(false)
                .setNextFragment(R.id.content, ActivityTransitSampleFragment.newInstance())
                .transition();
    }

    public static class ActivityTransitSampleFragment extends Fragment {

        static ActivityTransitSampleFragment newInstance() {
            return new ActivityTransitSampleFragment();
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            ActionBar.get(getActivity()).setTitle(R.string.sample_activity_transit_title);
        }

        @Override
        public View onCreateView(LayoutInflater inflate, ViewGroup container,
                                 Bundle savedInstanceState) {
            return inflate.inflate(R.layout.activity_transit, null);
        }

    }
}
