package net.ichigotake.colorfulsweets.lib.ui.dialog;

import net.ichigotake.colorfulsweets.lib.net.http.HttpAccessErrorEvent;
import net.ichigotake.colorfulsweets.lib.net.http.HttpAccessEventListener;
import android.content.Context;

import com.google.common.eventbus.Subscribe;

/**
 * API level 1
 * 
 * Show connection error message with dialog.
 */
public class ShowConnectionErrorDialogListener implements HttpAccessEventListener {

	final private MessageDialogBuilder mBuilder;
	
	public ShowConnectionErrorDialogListener(Context context) {
		mBuilder = new MessageDialogBuilder(context)
				.setDefaultPositiveText()
				.setMessage(android.R.string.httpErrorBadUrl);
		
	}
	
	@Subscribe
	public void onError(HttpAccessErrorEvent event) {
		mBuilder.show();
	}
}
