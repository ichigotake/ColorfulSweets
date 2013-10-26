package net.ichigotake.colorfulsweets.lib.net.http;

import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPost;

import android.net.Uri;

/**
 * API level 1
 * 
 * Create HTTP request object based {@link HttpBase}.
 */
public class HttpAccessRequest {

	/**
	 * API level 1
	 * 
	 * Return the {@link HttpHead} from {@link Uri}.
	 * @param uri
	 * @return
	 */
	public HttpHead createHeadRequest(Uri uri) {
		return new HttpHead(uri.toString());
	}

	/**
	 * API level 1
	 * 
	 * Return the {@link HttpGet} from {@link Uri}.
	 * @param uri
	 * @return
	 */
	public HttpGet createGetRequest(Uri uri) {
		return new HttpGet(uri.toString());
	}

	/**
	 * API level 1
	 * 
	 * Return the {@link HttpPost} from {@link Uri}.
	 * @param uri
	 * @return
	 */
	public HttpPost createPostRequest(Uri uri) {
		return new HttpPost(uri.toString());
	}

	/**
	 * API level 1
	 * 
	 * Return the {@link HttpDelete} from {@link Uri}.
	 * @param uri
	 * @return
	 */
	public HttpDelete createDeleteRequest(Uri uri) {
		return new HttpDelete(uri.toString());
	}
}