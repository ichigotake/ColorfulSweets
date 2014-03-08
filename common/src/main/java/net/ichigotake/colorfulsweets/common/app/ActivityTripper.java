package net.ichigotake.colorfulsweets.common.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.lang.ref.WeakReference;

/**
 * アクティビティの遷移をする
 */
public class ActivityTripper implements PaneTripper {

    private final String LOG_TAG = ActivityTripper.class.getSimpleName();
    private final WeakReference<Context> contextReference;
    private final ActivityFactory factory;

    public ActivityTripper(Context context, ActivityFactory factory) {
        this.contextReference = new WeakReference<Context>(context);
        this.factory = factory;
    }

    @Override
    public void go() {
        if (contextReference.enqueue()) {
            Log.d(LOG_TAG, "context has been enqueued in GC?");
            return ;
        }
        Context context = contextReference.get();
        if (context == null) {
            Log.d(LOG_TAG, "context is null.");
            return ;
        }
        Intent intent = factory.create(context);
        if (!(context instanceof Activity)) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        context.startActivity(intent);
    }
}
