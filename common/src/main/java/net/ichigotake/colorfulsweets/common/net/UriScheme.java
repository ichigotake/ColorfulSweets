package net.ichigotake.colorfulsweets.common.net;

import android.content.Intent;
import android.net.Uri;

public class UriScheme {

    public static boolean isCallback(Intent intent, String except) {
        final boolean matched;
        if (intent != null) {
            Uri uri = intent.getData();
            matched = (uri != null) && uri.toString().startsWith(except);
        } else {
            matched = false;
        }
        return matched;
    }
}
