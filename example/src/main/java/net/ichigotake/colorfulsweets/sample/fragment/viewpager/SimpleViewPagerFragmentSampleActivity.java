package net.ichigotake.colorfulsweets.sample.fragment.viewpager;

import android.os.Bundle;

import net.ichigotake.colorfulsweets.appcompat.fragment.FragmentTransit;
import net.ichigotake.colorfulsweets.sample.BaseActivity;
import net.ichigotake.colorfulsweets.sample.R;

public class SimpleViewPagerFragmentSampleActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new FragmentTransit(this)
                .setAddBackStack(false)
                .setNextFragment(R.id.content, SimpleViewPagerFragmentSampleFragment.newInstance())
                .transition();
    }
}
