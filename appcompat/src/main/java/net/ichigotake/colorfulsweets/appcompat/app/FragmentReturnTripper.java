package net.ichigotake.colorfulsweets.appcompat.app;

import android.support.v4.app.FragmentManager;

import net.ichigotake.colorfulsweets.appcompat.fragment.FragmentTransit;
import net.ichigotake.colorfulsweets.common.app.PaneTripper;


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
