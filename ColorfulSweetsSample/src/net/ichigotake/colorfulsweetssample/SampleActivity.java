package net.ichigotake.colorfulsweetssample;

import net.ichigotake.colorfulsweets.lib.fragment.FragmentTransit;
import android.os.Bundle;

public class SampleActivity extends SampleAppBaseActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// first display on app start.
		new FragmentTransit(this).toReplace(R.id.content, SampleMenuFragment.newInstance());
	}

}
