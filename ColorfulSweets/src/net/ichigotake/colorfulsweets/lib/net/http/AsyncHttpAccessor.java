package net.ichigotake.colorfulsweets.lib.net.http;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.AsyncTask;
import android.os.Handler;

import com.google.common.eventbus.EventBus;

/**
 * API level 1
 * 
 * Async HTTP accessor.
 */
public abstract class AsyncHttpAccessor extends AsyncTask<HttpRequestBase, Void, Void> {

	final private EventBus mEventBus = new EventBus();
	
	final private Handler mHandler = new Handler();

	public abstract HttpRequestBase createRequest();
	
	/**
	 * API level
	 * 
	 * Constructor
	 * @param listener
	 */
	public void registerListener(HttpAccessEventListener listener) {
		mEventBus.register(listener);
	}
	
	/**
	 * API level 1
	 * 
	 * Starting HTTP access.
	 */
	public void start() {
		execute(createRequest());
	}
	
	@Override
	protected Void doInBackground(HttpRequestBase... params) {
		for (HttpRequestBase request : params) {
			
			mHandler.post(new Runnable() {
				@Override
				public void run() {
					mEventBus.post(new BeforeHttpRequestEvent());
				}
			});
			
			try {
				HttpClient client = new DefaultHttpClient();
				final HttpAccessResponse response = new HttpAccessResponse(client.execute(request));
				if (response.isSuccess()) {
					mHandler.post(new Runnable() {
						
						@Override
						public void run() {
							mEventBus.post(response);
						}
					});
				} else {
					mHandler.post(new Runnable() {
						
						@Override
						public void run() {
							mEventBus.post(new HttpAccessErrorEvent(response));
						}
					});
				}
			} catch (ClientProtocolException e) {
				e.printStackTrace();
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						mEventBus.post(new BeforeRequestErrorEvent());
					}
				});
			} catch (IOException e) {
				e.printStackTrace();
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						mEventBus.post(new BeforeRequestErrorEvent());
					}
				});
			}
		}
		return null;
	}

}
