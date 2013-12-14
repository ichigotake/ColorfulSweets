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

    final private Context mContext;
    final private Intent mIntent;

    public ActivityTransit(Context context, Class<? extends Activity> nextClazz) {
        mContext = context;
        mIntent = new Intent(context, nextClazz);
    }

    
    /**
     * API level 1
     * 
     * Create {@link ActivityTransit} instance from {@link Context}.
     * If {@link Context} not instanceof {@link Activity},
     * when {@link #toNext} create new task with {@link Intent#FLAG_ACTIVITY_NEW_TASK}
     * 
     * @param context
     * @return
     * @throws IllegalStateException if context not instanceof {@link Activity}.
     */
    public static ActivityTransit from(Context context, Class<? extends Activity> nextClazz) {
        ActivityTransit transit = new ActivityTransit(context, nextClazz);
        transit.setNewTask();
        return transit;
    }
    
    /**
     * API level 1
     * 
     * {@link Intent#addFlags(int)} to {@link Intent#FLAG_ACTIVITY_CLEAR_TOP}
     * and {@link Intent#FLAG_ACTIVITY_NEW_TASK).
     * 
     * @return ActivityTransit myself
     */
    public ActivityTransit clearTop() {
        mIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        return this;
    }

    public ActivityTransit setNewTask() {
        mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        return this;
    }

    /**
     * API level 1
     * 
     * Execute activity transition.
     */
    public void toNext() {
        mContext.startActivity(mIntent);
    }

    /**
     * API level 1
     *
     * Execute {@link Activity} transition with finish to current {@link Activity}.
     */
    public void toNextWithFinish() throws IllegalStateException {
        toNext();
        if (mContext instanceof Activity) {
            ((Activity)mContext).finish();
        } else {
            throw new IllegalStateException("Context not instance of Activity.");
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
        mIntent.putExtras(extras);
        return this;
    }

}
