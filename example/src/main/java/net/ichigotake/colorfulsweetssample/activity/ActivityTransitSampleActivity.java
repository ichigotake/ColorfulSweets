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
        setContentView(R.layout.activity_transit);
        ActionBarSetting.show(getSupportActionBar(), R.string.sample_activity_transit_title);
        
    }
}
