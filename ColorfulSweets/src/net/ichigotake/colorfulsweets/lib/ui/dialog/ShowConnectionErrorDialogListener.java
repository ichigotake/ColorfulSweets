package net.ichigotake.colorfulsweets.lib.ui.dialog;

import android.content.Context;

import com.android.volley.VolleyError;

import net.ichigotake.colorfulsweets.lib.net.http.ResponseListener;

/**
 * API level 1
 * 
 * Show connection error message with dialog.
 */
public class ShowConnectionErrorDialogListener<T> implements ResponseListener<T> {

    final private MessageDialogBuilder mBuilder;
    
    public ShowConnectionErrorDialogListener(Context context) {
        mBuilder = new MessageDialogBuilder(context)
                .setDefaultPositiveText()
                .setMessage(android.R.string.httpErrorBadUrl);
        
    }

    @Override
    public void onResponse(T response) {
        // do nothing
    }

    @Override
    public void onError(VolleyError response) {
        mBuilder.show();
    }
}
