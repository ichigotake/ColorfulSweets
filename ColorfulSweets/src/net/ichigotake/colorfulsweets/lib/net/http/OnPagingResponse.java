package net.ichigotake.colorfulsweets.lib.net.http;

import com.android.volley.VolleyError;

import net.ichigotake.colorfulsweets.lib.model.LoadingState;

/**
 * API level 1
 */
class OnPagingResponse<T> implements ResponseListener<T> {

    final private LoadingState mState;

    OnPagingResponse(LoadingState state) {
        mState = state;
    }

    @Override
    public void onResponse(AsyncResponseEvent<T> response) {
        mState.finish();
    }


    @Override
    public void onError(VolleyError volleyError) {
        mState.complete();
    }

    @Override
    public void afterResponse(AfterResponseEvent response) {
        // do nothing
    }
}

