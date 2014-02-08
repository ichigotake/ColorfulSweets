package net.ichigotake.colorfulsweets.sample.paging;

import android.os.Bundle;

import net.ichigotake.colorfulsweets.appcompat.fragment.FragmentTransit;
import net.ichigotake.colorfulsweets.sample.BaseActivity;
import net.ichigotake.colorfulsweets.sample.R;
import net.ichigotake.colorfulsweets.sample.fragment.AutoPagingFragmentSampleFragment;

public class AutoPagingActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new FragmentTransit(this)
                .setAddBackStack(false)
                .setNextFragment(R.id.content, AutoPagingFragmentSampleFragment.newInstance())
                .transition();
    }

}
