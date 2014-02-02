package net.ichigotake.colorfulsweets.lib.fragment;

import android.content.Context;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;

import net.ichigotake.colorfulsweets.R;
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
     * API level 4
     * 
     * Constructor
     * @param activity
     */
    public FragmentTransit(ActionBarActivity activity) {
        mFragmentManager = activity.getSupportFragmentManager();
    }
    
    /**
     * API level 4
     * 
     * Constructor
     * @param activity
     */
    public FragmentTransit(FragmentActivity activity) {
        mFragmentManager = activity.getSupportFragmentManager();
    }
    
    /**
     * APi level 4
     * 
     * Constructor
     * @param fragmentManager
     */
    public FragmentTransit(FragmentManager fragmentManager) {
        mFragmentManager = fragmentManager;
    }
    
    public static FragmentTransit from(Context context) {
        final FragmentTransit transit;
        if (context instanceof ActionBarActivity) {
            ActionBarActivity activity = (ActionBarActivity) context;
            transit = new FragmentTransit(activity);
        } else if (context instanceof FragmentActivity) {
            FragmentActivity activity = (FragmentActivity) context;
            transit = new FragmentTransit(activity);
        } else {
            throw new IllegalStateException(
                    "Context not contain ActionBarActivity or FragmentActivity");
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
