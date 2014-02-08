package net.ichigotake.colorfulsweets.sample.preference;

import android.os.Bundle;

import net.ichigotake.colorfulsweets.appcompat.fragment.FragmentTransit;
import net.ichigotake.colorfulsweets.sample.BaseActivity;
import net.ichigotake.colorfulsweets.sample.R;

public class PreferenceSampleActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new FragmentTransit(this)
                .setAddBackStack(false)
                .setNextFragment(R.id.content, PreferenceSampleFragment.newInstance())
                .transition();
    }
}
