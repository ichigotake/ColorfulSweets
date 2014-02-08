package net.ichigotake.colorfulsweets.ics.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Handler;

import net.ichigotake.colorfulsweets.ics.R;
import net.ichigotake.colorfulsweets.lib.widget.Transition;

/**
 * API level 4
 * 
 * Fragment transition.
 */
public class FragmentTransit implements Transition {

    final private FragmentManager mFragmentManager;
    
    private boolean mAddBackStack = true;
    private boolean mIsAnimation = true;
    private Fragment mNextFragment;
    private int mTargetViewId;
    
    /**
     * APi level 11
     * 
     * Constructor
     * @param fragmentManager
     */
    public FragmentTransit(FragmentManager fragmentManager) {
        mFragmentManager = fragmentManager;
    }
    
    public static FragmentTransit from(Context context) {
        final FragmentTransit transit;
        if (context instanceof Activity) {
            Activity activity = (Activity)context;
            transit = new FragmentTransit(activity.getFragmentManager());
        } else {
            throw new IllegalStateException(
                    "Context not contain Activity");
        }
        return transit;
    }

    public FragmentTransit setNextFragment(int targetViewId, Fragment nextFragment) {
        mTargetViewId = targetViewId;
        mNextFragment = nextFragment;
        return this;
    }
    /**
     * API level 4
     * 
     * If true add current fragment to back stack when fragment transition.
     * @param flag
     * @return
     */
    public FragmentTransit setAddBackStack(boolean flag) {
        mAddBackStack = flag;
        return this;
    }
    
    /**
     * API level 4
     * 
     * Replace to current fragment.
     */
    @Override
    public void transition() {
        final int targetViewId = mTargetViewId;
        final Fragment nextFragment = mNextFragment;
        
        Runnable runnable = new Runnable() {
            
            @Override
            public void run() {
                FragmentTransaction transaction = mFragmentManager.beginTransaction();
                if (mIsAnimation) {
                    transaction.setCustomAnimations(
                            R.anim.fade_in,
                            R.anim.fade_out,
                            R.anim.fade_in,
                            R.anim.fade_out);
                }
                transaction.replace(targetViewId, nextFragment);
                if (mAddBackStack) {
                    transaction.addToBackStack(null);
                }
                transaction.commit();
            }
            
        };
        
        new Handler().post(runnable);
    }
    
    /**
     * API level 4
     * 
     * Preview to fragment back stack.
     */
    public void toPrev() {
        FragmentManager fragmentManager = mFragmentManager;
        fragmentManager.popBackStack();
    }

    public FragmentTransit setNoAnimation() {
        mIsAnimation = false;
        return this;
    }
}
