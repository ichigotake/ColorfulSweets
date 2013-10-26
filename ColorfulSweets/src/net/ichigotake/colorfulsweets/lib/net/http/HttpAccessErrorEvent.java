package net.ichigotake.colorfulsweets.lib.net.http;

/**
 * API level 1
 * 
 * Throw HTTP connection error event.
 */
public class HttpAccessErrorEvent implements ErrorEvent {

	final private HttpAccessResponse mResponse;
	
	/**
	 * API level 1
	 * 
	 * Constructor
	 * @param response
	 */
	public HttpAccessErrorEvent(HttpAccessResponse response) {
		mResponse = response;
	}
	
	/**
	 * API level 1
	 * 
	 * Return the {@link HttpAccessResponse}
	 * @return
	 */
	public HttpAccessResponse getResponse() {
		return mResponse;
	}
}
