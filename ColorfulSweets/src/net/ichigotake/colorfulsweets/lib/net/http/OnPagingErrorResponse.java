package net.ichigotake.colorfulsweets.lib.net.http;

import com.android.volley.VolleyError;

import net.ichigotake.colorfulsweets.lib.ui.LoadingState;

class OnPagingErrorResponse implements ResponseErrorListener {

    final private LoadingState mState;

    OnPagingErrorResponse(LoadingState state) {
        mState = state;
    }

    @Override
    public void onResponse(VolleyError volleyError) {
        mState.complete();
    }
}

