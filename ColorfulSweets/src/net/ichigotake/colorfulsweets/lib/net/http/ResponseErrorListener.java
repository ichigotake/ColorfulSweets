package net.ichigotake.colorfulsweets.lib.net.http;

import com.android.volley.VolleyError;
import com.google.common.eventbus.Subscribe;

/**
 * API level 8
 */
public interface ResponseErrorListener {

    @Subscribe
    public void onResponse(VolleyError response);

}
