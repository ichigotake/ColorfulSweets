package net.ichigotake.colorfulsweets.lib.ui.dialog;

import android.content.Context;
import android.os.Handler;

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
    final private Handler mHandler;
    
    public LoadingProgressDialogListener(Context context) {
        mDialog = new LoadingProgressDialog(context);
        mHandler = new Handler();
    }
    
    @Subscribe
    public void before(BeforeRequestEvent event) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                mDialog.show();
            }
        });
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
