package net.ichigotake.colorfulsweets.lib.net.http;

import com.android.volley.Response;

/**
 * Created by ichigotake on 2013/12/04.
 */
public class AsyncResponseListener<T> implements Response.Listener<T> {

    final private ResponseListener<T> mListener;

    public AsyncResponseListener(ResponseListener<T> listener) {
        mListener = listener;
    }

    @Override
    public void onResponse(T response) {
        mListener.onResponse(response);
    }
}
