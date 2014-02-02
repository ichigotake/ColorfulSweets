package net.ichigotake.colorfulsweets.lib.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import net.ichigotake.colorfulsweets.lib.widget.Transition;

/**
 * API level 1
 * 
 * Activity transition.
 */
public class ActivityTransit implements Transition {

    final private Context mContext;
    final private Intent mIntent;
    private boolean mWithFinish;

    public ActivityTransit(Context context, Class<? extends Activity> nextClazz) {
        mContext = context;
        mIntent = new Intent(context, nextClazz);
    }

    
    /**
     * API level 1
     * 
     * Create {@link ActivityTransit} instance from {@link android.content.Context}.
     * If {@link android.content.Context} not instanceof {@link android.app.Activity},
     * when {@link #transition} create new task with {@link android.content.Intent#FLAG_ACTIVITY_NEW_TASK}
     *
     * @param context
     * @return
     * @throws IllegalStateException if context not instanceof {@link android.app.Activity}.
     */
    public static ActivityTransit from(Context context, Class<? extends Activity> nextClazz) {
        ActivityTransit transit = new ActivityTransit(context, nextClazz);
        transit.setNewTask();
        return transit;
    }

    /**
     * API level 1
     *
     * {@link android.content.Intent#addFlags(int)} to {@link android.content.Intent#FLAG_ACTIVITY_CLEAR_TOP}
     * and {@link android.content.Intent#FLAG_ACTIVITY_NEW_TASK).
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
    @Override
    public void transition() {
        mContext.startActivity(mIntent);
        if (mWithFinish && mContext instanceof Activity) {
            ((Activity)mContext).finish();
        }
    }

    /**
     * API level 1
     *
     * Execute {@link android.app.Activity} transition with finish to current {@link android.app.Activity}.
     */
    public ActivityTransit setWithFinish() {
        mWithFinish = true;
        return this;
    }

    /**
     * API level 1
     *
     * Set of extended data to the intent.
     *
     * @param extras The {@link android.os.Bundle} of extras to add this intent.
     * @return
     */
    public ActivityTransit putExtras(Bundle extras) {
        mIntent.putExtras(extras);
        return this;
    }

}
