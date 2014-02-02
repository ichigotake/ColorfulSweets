package net.ichigotake.colorfulsweetssample;

import android.os.Bundle;

import net.ichigotake.colorfulsweets.lib.fragment.FragmentTransit;

public class SampleActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // first display on app start.
        new FragmentTransit(this)
                .setAddBackStack(false)
                .setNextFragment(R.id.content, SampleMenuFragment.newInstance())
                .transition();
    }

}
