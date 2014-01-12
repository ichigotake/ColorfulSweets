package net.ichigotake.colorfulsweetssample;

import android.os.Bundle;

import net.ichigotake.colorfulsweets.lib.activity.ActivityTransit;
import net.ichigotake.colorfulsweets.lib.compat.actionbar.ActionBarSetting;

/**
 * Sample for {@link ActivityTransit}
 */
public class ActivityTransitSampleActivity extends SampleAppBaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transit);
        ActionBarSetting.show(getSupportActionBar(), R.string.sample_activity_transit_title);
        
    }
}
