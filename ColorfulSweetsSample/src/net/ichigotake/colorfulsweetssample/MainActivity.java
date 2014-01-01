package net.ichigotake.colorfulsweetssample;

import android.os.Bundle;

import net.ichigotake.colorfulsweets.lib.fragment.FragmentTransit;
import net.ichigotake.colorfulsweetssample.menu.SimpleMenuSampleFragment;

public class MainActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // first display on app start.
        new FragmentTransit(this).toReplace(R.id.content, SimpleMenuSampleFragment.newInstance());
    }

}
