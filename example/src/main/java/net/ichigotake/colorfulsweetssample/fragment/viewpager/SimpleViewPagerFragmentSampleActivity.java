package net.ichigotake.colorfulsweetssample.fragment.viewpager;

import android.os.Bundle;

import net.ichigotake.colorfulsweets.lib.fragment.FragmentTransit;
import net.ichigotake.colorfulsweetssample.BaseActivity;
import net.ichigotake.colorfulsweetssample.R;

public class SimpleViewPagerFragmentSampleActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new FragmentTransit(this)
                .setAddBackStack(false)
                .toReplace(R.id.content, SimpleViewPagerFragmentSampleFragment.newInstance());
    }
}
