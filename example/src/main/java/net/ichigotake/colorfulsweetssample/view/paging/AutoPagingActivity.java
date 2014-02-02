package net.ichigotake.colorfulsweetssample.view.paging;

import android.os.Bundle;

import net.ichigotake.colorfulsweets.lib.fragment.FragmentTransit;
import net.ichigotake.colorfulsweetssample.BaseActivity;
import net.ichigotake.colorfulsweetssample.R;
import net.ichigotake.colorfulsweetssample.fragment.AutoPagingFragmentSampleFragment;

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
