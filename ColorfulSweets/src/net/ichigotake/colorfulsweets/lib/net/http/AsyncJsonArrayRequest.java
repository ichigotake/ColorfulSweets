package net.ichigotake.colorfulsweets.lib.net.http;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;

/**
 * API level 8
 */
public abstract class AsyncJsonArrayRequest extends AsyncRequest<JSONArray> {

    public Request createRequest() {
        registerListeners();
        return new JsonArrayRequest(
                getRequestUri().toString(),
                new OnResponse(),
                new OnErrorResponse());
    }

    @Override
    final protected int getMethod() {
        // do nothing
        return 0;
    }

    @Override
    final protected JSONArray createRequestBody() {
        // do nothing
        return null;
    }
}
