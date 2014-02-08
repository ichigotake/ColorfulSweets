package net.ichigotake.colorfulsweets.sample;

import android.os.Bundle;

import net.ichigotake.colorfulsweets.appcompat.fragment.FragmentTransit;
import net.ichigotake.colorfulsweets.sample.R;

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
