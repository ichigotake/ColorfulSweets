package net.ichigotake.colorfulsweets.lib.net.http;

import android.net.Uri;

import com.android.volley.Request;

import net.ichigotake.colorfulsweets.lib.model.PagingState;
import net.ichigotake.colorfulsweets.lib.ui.LoadingState;

/**
 * Created by ichigotake on 2013/12/04.
 */
public abstract class AutoPagingJsonObjectRequest extends AsyncJsonObjectRequest {

    final private LoadingState mState;
    final private PagingState mPagingState;

    public AutoPagingJsonObjectRequest(PagingState parameter) {
        super();
        mState = new LoadingState();
        mPagingState = parameter;
    }

    public Request createRequest() {
        registerListener(new OnPagingResponse(mState));
        registerListener(new OnPagingErrorResponse(mState));
        return super.createRequest();
    }

    final public Uri getRequestUri() {
        return getRequestUri(mPagingState);
    }

    abstract protected Uri getRequestUri(PagingState parameter);

}