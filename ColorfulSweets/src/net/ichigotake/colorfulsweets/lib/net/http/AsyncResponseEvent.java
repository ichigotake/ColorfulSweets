package net.ichigotake.colorfulsweets.lib.net.http;


public class AsyncResponseEvent<T> {

    final private T mResponse;

    public AsyncResponseEvent(T response) {
        mResponse = response;
    }

    public T getResponse() {
        return mResponse;
    }

}
