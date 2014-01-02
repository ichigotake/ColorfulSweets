package net.ichigotake.colorfulsweets.lib.net.http;

import com.android.volley.VolleyError;
import com.google.common.eventbus.Subscribe;

public interface ResponseListener<T> {

    @Subscribe
    @SuppressWarnings("unused")
    public void onResponse(AsyncResponseEvent<T> event);

    @Subscribe
    @SuppressWarnings("unused")
    public void onError(VolleyError error);

    @Subscribe
    @SuppressWarnings("unused")
    public void afterResponse(AfterResponseEvent event);

}
