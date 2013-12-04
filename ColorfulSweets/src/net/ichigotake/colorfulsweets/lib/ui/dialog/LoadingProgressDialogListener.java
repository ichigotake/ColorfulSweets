package net.ichigotake.colorfulsweets.lib.ui.dialog;

import android.content.Context;

import com.google.common.eventbus.Subscribe;

import net.ichigotake.colorfulsweets.lib.net.http.BeforeHttpRequestEvent;
import net.ichigotake.colorfulsweets.lib.net.http.HttpAccessErrorEvent;
import net.ichigotake.colorfulsweets.lib.net.http.HttpAccessEventListener;
import net.ichigotake.colorfulsweets.lib.net.http.HttpAccessResponse;

/**
 * API level 1
 * 
 * Show loading progress dialog.
 */
public class LoadingProgressDialogListener implements HttpAccessEventListener {

    final private LoadingProgressDialog mDialog;
    
    public LoadingProgressDialogListener(Context context) {
        mDialog = new LoadingProgressDialog(context);
    }
    
    @Subscribe
    public void before(BeforeHttpRequestEvent event) {
        mDialog.show();
    }
    
    @Subscribe
    public void onSuccess(HttpAccessResponse response) {
        mDialog.dismiss();
    }
    
    @Subscribe
    public void onError(HttpAccessErrorEvent event) {
        mDialog.dismiss();
    }
    
}
