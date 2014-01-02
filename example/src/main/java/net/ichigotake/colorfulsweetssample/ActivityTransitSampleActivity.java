package net.ichigotake.colorfulsweetssample;

import net.ichigotake.colorfulsweets.lib.actionbar.ActionBarSetting;
import net.ichigotake.colorfulsweets.lib.context.ActivityTransit;
import android.os.Bundle;

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
