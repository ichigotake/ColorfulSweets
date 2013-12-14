package net.ichigotake.colorfulsweets.lib.net.http;

import com.android.volley.VolleyError;
import com.google.common.eventbus.Subscribe;

public interface ResponseListener<T> {

    @Subscribe
    @SuppressWarnings("unused")
    public void onResponse(T response);

    @Subscribe
    @SuppressWarnings("unused")
    public void onError(VolleyError error);
}
