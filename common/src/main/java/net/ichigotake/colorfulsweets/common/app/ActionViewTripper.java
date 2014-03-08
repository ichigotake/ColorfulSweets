package net.ichigotake.colorfulsweets.common.app;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/**
 * intent filter の {@link android.content.Intent#ACTION_VIEW} を起動する
 */
public class ActionViewTripper implements Tripper {

    private final Context context;
    private final Uri uri;

    public ActionViewTripper(Context context, Uri uri) {
        this.context = context;
        this.uri = uri;
    }

    @Override
    public void go() {
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        context.startActivity(intent);
    }
}
