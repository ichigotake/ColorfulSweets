package net.ichigotake.colorfulsweets.lib.net.http;

import com.google.common.eventbus.Subscribe;

public interface ResponseListener<T> {

    @Subscribe
    public void onResponse(T response);
}
