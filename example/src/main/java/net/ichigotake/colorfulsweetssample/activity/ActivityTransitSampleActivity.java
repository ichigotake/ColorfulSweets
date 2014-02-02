package net.ichigotake.colorfulsweetssample.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.ichigotake.colorfulsweets.lib.activity.ActivityTransit;
import net.ichigotake.colorfulsweets.lib.compat.actionbar.ActionBarSetting;
import net.ichigotake.colorfulsweets.lib.fragment.BaseFragment;
import net.ichigotake.colorfulsweets.lib.fragment.FragmentTransit;
import net.ichigotake.colorfulsweetssample.BaseActivity;
import net.ichigotake.colorfulsweetssample.R;

/**
 * Sample for {@link ActivityTransit}
 */
public class ActivityTransitSampleActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new FragmentTransit(this)
                .setAddBackStack(false)
                .setNextFragment(R.id.content, ActivityTransitSampleFragment.newInstance());
    }

    public static class ActivityTransitSampleFragment extends BaseFragment {

        static ActivityTransitSampleFragment newInstance() {
            return new ActivityTransitSampleFragment();
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            ActionBarSetting.show(getSupportActionBar(), R.string.sample_activity_transit_title);
        }

        @Override
        public View onCreateView(LayoutInflater inflate, ViewGroup container,
                                 Bundle savedInstanceState) {
            return inflate.inflate(R.layout.activity_transit, null);
        }

    }
}
