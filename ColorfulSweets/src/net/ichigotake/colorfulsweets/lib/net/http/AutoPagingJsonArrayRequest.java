package net.ichigotake.colorfulsweets.lib.net.http;

import android.net.Uri;

import com.android.volley.Request;

import net.ichigotake.colorfulsweets.lib.model.PagingState;
import net.ichigotake.colorfulsweets.lib.ui.LoadingState;

import org.json.JSONArray;

/**
 * API level 8
 */
public abstract class AutoPagingJsonArrayRequest extends AsyncJsonArrayRequest {

    final private LoadingState mState;
    final private PagingState mPagingState;

    public AutoPagingJsonArrayRequest(PagingState parameter) {
        super();
        mState = new LoadingState();
        mPagingState = parameter;
    }

    public Request createRequest() {
        registerListener(new OnPagingResponse<JSONArray>(mState));
        return super.createRequest();
    }

    final public Uri getRequestUri() {
        return getRequestUri(mPagingState);
    }

    abstract protected Uri getRequestUri(PagingState parameter);

}
