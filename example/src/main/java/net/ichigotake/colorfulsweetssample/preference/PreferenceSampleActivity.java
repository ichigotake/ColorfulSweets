package net.ichigotake.colorfulsweetssample.preference;

import android.os.Bundle;

import net.ichigotake.colorfulsweets.lib.fragment.FragmentTransit;
import net.ichigotake.colorfulsweetssample.BaseActivity;
import net.ichigotake.colorfulsweetssample.R;

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
