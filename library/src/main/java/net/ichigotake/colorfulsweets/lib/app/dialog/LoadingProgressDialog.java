package net.ichigotake.colorfulsweets.lib.app.dialog;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * API level 1
 * 
 * Show loading progress dialog.
 */
public class LoadingProgressDialog {

    final private ProgressDialog mDialog;
    
    /**
     * API level 1
     * 
     * Constructor
     * @param context
     */
    public LoadingProgressDialog(Context context) {
        mDialog = new ProgressDialog(context);
    }
    
    /**
     * API level 1
     * 
     * Show loading progress dialog.
     */
    public void show() {
        mDialog.show();
    }
    
    /**
     * API level 1
     * 
     * Hide loading progress dialog.
     */
    public void dismiss() {
        mDialog.dismiss();
    }
    
}
