package net.ichigotake.colorfulsweets.lib.context;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * API level 1
 * 
 * Activity transition.
 */
public class ActivityTransit {

    final private Activity mCurrentActivity;

    private Bundle mExtras;
    
    private boolean mClearTop;
    
    /**
     * API level 1
     * 
     * Constructor
     * 
     * @param the current activity.
     */
    public ActivityTransit(Activity activity) {
        mCurrentActivity = activity;
    }
    
    /**
     * API level 1
     * 
     * Create {@link ActivityTransit} instance from {@link Context} instanceof {@link Activity}.
     * 
     * @param context
     * @return
     * @throws IllegalStateException if context not instanceof {@link Activity}.
     */
    public static ActivityTransit from(Context context) throws IllegalStateException {
        final ActivityTransit transit;
        if (context instanceof Activity) {
            transit = new ActivityTransit((Activity)context);
        } else {
            throw new IllegalStateException("Context has not instanceof Activity.");
        }
        return transit;
    }
    
    /**
     * API level 1
     * 
     * Set for "intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK)"
     * 
     * TODO more meta description.
     * @return
     */
    public ActivityTransit clearTop() {
        mClearTop = true;
        return this;
    }

    /**
     * API level 1
     * 
     * Execute activity transition.
     * 
     * @param nextActivity the class.
     */
    public void toNext(Class<? extends Activity> nextActivity) {
        Intent intent = new Intent(mCurrentActivity, nextActivity);
        if (null != mExtras) {
            intent.putExtras(mExtras);
        }

        if (mClearTop) {
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        mCurrentActivity.startActivity(intent);
        if (mClearTop) {
            mCurrentActivity.finish();
        }
    }

    /**
     * API level 1
     *
     * Set of extended data to the intent.
     *
     * @param extras The {@link Bundle} of extras to add this intent.
     * @return
     */
    public ActivityTransit putExtras(Bundle extras) {
        mExtras = extras;
        return this;
    }
}
