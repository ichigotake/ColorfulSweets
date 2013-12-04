package net.ichigotake.colorfulsweets.lib.net.http;

import android.net.Uri;

import com.android.volley.Request;

import net.ichigotake.colorfulsweets.lib.model.PagingParameter;
import net.ichigotake.colorfulsweets.lib.ui.LoadingState;

import org.json.JSONArray;

/**
 * API level 8
 */
public abstract class AutoPagingJsonArrayRequest extends AsyncJsonArrayRequest {

    final private LoadingState mState;
    final private PagingParameter mPagingParameter;

    public AutoPagingJsonArrayRequest(PagingParameter parameter) {
        super();
        mState = new LoadingState();
        mPagingParameter = parameter;
    }

    public Request createRequest() {
        registerListener(new OnPagingResponse<JSONArray>(mState));
        registerListener(new OnPagingErrorResponse(mState));
        return super.createRequest();
    }

    final public Uri getRequestUri() {
        return getRequestUri(mPagingParameter);
    }

    abstract protected Uri getRequestUri(PagingParameter parameter);

}
