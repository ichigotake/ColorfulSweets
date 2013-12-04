package net.ichigotake.colorfulsweets.lib.net.http;

import com.google.common.base.Optional;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;

/**
 * API level 1
 * 
 * HTTP response object.
 */
public class HttpAccessResponse {

    final private HttpResponse mResponse;

    final private int mStatusCode;
    
    final private Optional<String> mContent;

    /**
     * API level 1
     * 
     * Constructor
     * @param response the response body.
     */
    public HttpAccessResponse(HttpResponse response) {
        mResponse = response;
        mContent = parseContent(mResponse);
        mStatusCode = mResponse.getStatusLine().getStatusCode();
    }

    /**
     * API level 1
     * 
     * Return true if response is success.
     *
     * @return true if response is success
     */
    public boolean isSuccess() {
        return HttpURLConnection.HTTP_OK == mStatusCode;
    }

    /**
     * API level 1
     * 
     * Return the {@link HttpResponse}.
     * @return the {@link org.apache.http.HttpResponse}
     */
    public HttpResponse getResponse() {
        return mResponse;
    }
    
    /**
     * API level 1
     * 
     * Return the response body.
     * @return the response body.
     */
    public Optional<String> getContent() {
        return mContent;
    }

    /**
     * API level 1
     *
     * Return the {@link JSONObject} from response body.
     *
     * @return response the {@link org.json.JSONObject} from response body.
     */
    public JSONObject getJSONObject() throws JSONException {
        Optional<String> body = getContent();
        final JSONObject json;
        if (body.isPresent()) {
            json = new JSONObject(body.get());
        } else {
            json = new JSONObject();
        }
        return json;
    }

    /**
     * API level 1
     *
     * Return the {@link org.json.JSONArray}
     *
     * @return
     */
    public JSONArray getJSONArray() throws JSONException {
        Optional<String> body = getContent();
        final JSONArray json;
        if (body.isPresent()) {
            json = new JSONArray(body.get());
        } else {
            json = new JSONArray();
        }
        return json;
    }
    
    private Optional<String> parseContent(HttpResponse response) {
        Optional<String> content;
        try {
            content = Optional.of(EntityUtils.toString(response.getEntity(), "UTF-8"));
        } catch (org.apache.http.ParseException e) {
            content = Optional.absent();
            e.printStackTrace();
        } catch (IOException e) {
            content = Optional.absent();
            e.printStackTrace();
        }
        return content;
    }
}