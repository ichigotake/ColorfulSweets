package net.ichigotake.colorfulsweets.lib.net.http;

import net.ichigotake.colorfulsweets.lib.ui.LoadingState;

/**
 * API level 1
 */
class OnPagingResponse<T> implements ResponseListener<T> {

    final private LoadingState mState;

    OnPagingResponse(LoadingState state) {
        mState = state;
    }

    @Override
    public void onResponse(T response) {
        mState.complete();
    }
}

