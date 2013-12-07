package net.ichigotake.colorfulsweets.lib.ui.dialog;

import android.content.Context;

import com.android.volley.VolleyError;
import com.google.common.eventbus.Subscribe;

import net.ichigotake.colorfulsweets.lib.net.http.BeforeRequestEvent;
import net.ichigotake.colorfulsweets.lib.net.http.RequestListener;

/**
 * API level 1
 * 
 * Show loading progress dialog.
 */
public class LoadingProgressDialogListener implements RequestListener {

    final private LoadingProgressDialog mDialog;
    
    public LoadingProgressDialogListener(Context context) {
        mDialog = new LoadingProgressDialog(context);
    }
    
    @Subscribe
    public void before(BeforeRequestEvent event) {
        mDialog.show();
    }
    
    @Subscribe
    public void onResponse(Object response) {
        mDialog.dismiss();
    }

    @Subscribe
    public void onError(VolleyError error) {
        mDialog.dismiss();
    }
}
