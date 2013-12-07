package net.ichigotake.colorfulsweets.lib.net.http;

import android.net.Uri;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.common.eventbus.EventBus;

/**
 * API level 8
 */
public abstract class AsyncRequest<T> {

    final private EventBus mEventBus;

    public AsyncRequest() {
        mEventBus = new EventBus();
    }

    public void registerListener(RequestListener listener) {
        mEventBus.register(listener);
    }

    public void registerListener(ResponseListener<T> listener) {
        mEventBus.register(listener);
    }

    public void registerListener(ResponseErrorListener listener) {
        mEventBus.register(listener);
    }

    public void eventPost(RequestEvent event) {
        mEventBus.post(event);
    }

    public void eventPost(T event) {
        mEventBus.post(event);
    }

    public void eventPost(VolleyError event) {
        mEventBus.post(event);
    }

    protected void registerListeners() {
        ResponseErrorListener errorListener = createErrorResponse();
        if (errorListener != null) {
            registerListener(errorListener);
        }

        ResponseListener<T> responseListener = createResponse();
        if (responseListener != null) {
            registerListener(responseListener);
        }
    }

    abstract public Request createRequest();

    abstract protected Uri getRequestUri();

    abstract protected int getMethod();

    abstract protected T createRequestBody();

    abstract protected ResponseListener<T> createResponse();

    abstract protected ResponseErrorListener createErrorResponse();


    protected class OnResponse implements Response.Listener<T> {

        @Override
        public void onResponse(T response) {
            eventPost(response);
        }
    }

    protected class OnErrorResponse implements Response.ErrorListener {

        @Override
        public void onErrorResponse(VolleyError error) {
            eventPost(error);
        }
    }

}
