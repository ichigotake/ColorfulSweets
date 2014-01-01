package net.ichigotake.colorfulsweetssample.context;

import android.os.Bundle;

import net.ichigotake.colorfulsweets.lib.actionbar.ActionBarSetting;
import net.ichigotake.colorfulsweets.lib.context.ActivityTransit;
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
