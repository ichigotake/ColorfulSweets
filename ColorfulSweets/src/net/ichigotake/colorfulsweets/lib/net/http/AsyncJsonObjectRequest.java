package net.ichigotake.colorfulsweets.lib.net.http;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

/**
 *
 */
public abstract class AsyncJsonObjectRequest extends AsyncRequest<JSONObject> {

    public Request createRequest() {
        registerListeners();
        return new JsonObjectRequest(
                getMethod(),
                getRequestUri().toString(),
                createRequestBody(),
                new OnResponse(),
                new OnErrorResponse());
    }

}
