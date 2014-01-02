package net.ichigotake.colorfulsweets.lib.net.http;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;

public abstract class AsyncStringRequest extends AsyncRequest<String> {

    public Request createRequest() {
        registerListeners();
        return new StringRequest(
                getMethod(),
                getRequestUri().toString(),
                new OnResponse(),
                new OnErrorResponse());
    }

    @Override
    final protected String createRequestBody() {
        // do nothing
        return null;
    }

}
