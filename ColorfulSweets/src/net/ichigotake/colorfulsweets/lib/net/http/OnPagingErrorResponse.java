package net.ichigotake.colorfulsweets.lib.net.http;

import com.android.volley.VolleyError;

import net.ichigotake.colorfulsweets.lib.ui.LoadingState;

/**
 * Created by ichigotake on 2013/12/05.
 */
class OnPagingErrorResponse implements ResponseErrorListener {

    final private LoadingState mState;

    OnPagingErrorResponse(LoadingState state) {
        mState = state;
    }

    @Override
    public void onError(VolleyError volleyError) {
        mState.complete();
    }
}

