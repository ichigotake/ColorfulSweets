package net.ichigotake.colorfulsweets.ics.app;

import android.app.FragmentManager;

import net.ichigotake.colorfulsweets.common.app.PaneTripper;
import net.ichigotake.colorfulsweets.ics.fragment.FragmentTransit;

/**
 * 1つ前のフラグメントへバックする
 */
public class FragmentReturnTripper implements PaneTripper {

    private final FragmentManager fragmentManager;

    public FragmentReturnTripper(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    @Override
    public void go() {
        new FragmentTransit(fragmentManager).toPrev();
    }
}
