package net.ichigotake.colorfulsweets.lib.net.http;

/**
 * Created by ichigotake on 2013/12/04.
 */
public class AsyncResponse<T> {

    final private T mResponse;

    public AsyncResponse(T response) {
        mResponse = response;
    }

    public T getResponse() {
        return mResponse;
    }
}
