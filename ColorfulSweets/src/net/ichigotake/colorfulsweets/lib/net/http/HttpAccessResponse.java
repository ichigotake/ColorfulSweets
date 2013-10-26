package net.ichigotake.colorfulsweets.lib.net.http;

import java.io.IOException;
import java.net.HttpURLConnection;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import android.net.ParseException;

import com.google.common.base.Optional;

/**
 * API level 1
 * 
 * HTTP response object.
 */
public class HttpAccessResponse {

	final private Optional<JSONObject> mJson;

	final private HttpResponse mResponse;

	final private int mStatusCode;
	
	final private Optional<String> mContent;

	/**
	 * API level 1
	 * 
	 * Constructor
	 * @param response
	 */
	public HttpAccessResponse(HttpResponse response) {
		mResponse = response;
		mContent = parseContent(mResponse);
		mJson = parseJson(mContent);
		mStatusCode = mResponse.getStatusLine().getStatusCode();
	}

	/**
	 * API level 1
	 * 
	 * Return true if response is success.
	 * @return
	 */
	public boolean isSuccess() {
		return HttpURLConnection.HTTP_OK == mStatusCode;
	}

	/**
	 * API level 1
	 * 
	 * Parsed response body to {@link JSONObject}.
	 * @return
	 */
	public Optional<JSONObject> getJSONObject() {
		return mJson;
	}

	/**
	 * API level 1
	 * 
	 * Return the {@link HttpResponse}.
	 * @return
	 */
	public HttpResponse getResponse() {
		return mResponse;
	}
	
	/**
	 * API level 1
	 * 
	 * Return the response body.
	 * @return
	 */
	public Optional<String> getContent() {
		return mContent;
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
	
	private Optional<JSONObject> parseJson(Optional<String> content) {
		try {
			if (content.isPresent()) {
				return Optional.of(new JSONObject(content.get()));
			} else {
				return Optional.absent();
			}
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return Optional.absent();
	}
}