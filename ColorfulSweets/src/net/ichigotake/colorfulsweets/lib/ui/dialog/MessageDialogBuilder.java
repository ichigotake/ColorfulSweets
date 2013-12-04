package net.ichigotake.colorfulsweets.lib.ui.dialog;

import android.app.AlertDialog;
import android.content.Context;

/**
 * API level 1
 * 
 * Builder for {@link MessageDialog} .
 */
public class MessageDialogBuilder {

    final private AlertDialog.Builder mBuilder;
    
    public MessageDialogBuilder(Context context) {
        mBuilder = new AlertDialog.Builder(context);
    }
    
    public MessageDialog show() {
        return new MessageDialog(mBuilder.show());
    }
    
    /**
     * API level 1
     * 
     * Dialog for shown message.
     */
    public class MessageDialog {
        
        final private AlertDialog mDialog;
        
        MessageDialog(AlertDialog dialog) {
            mDialog = dialog;
        }
        
        /**
         * API level 1
         * 
         * Show message dialog.
         */
        public void show() {
            mDialog.show();
        }
        
        /**
         * API level 1
         * 
         * Hide message dialog.
         */
        public void dismiss() {
            mDialog.dismiss();
        }
        
    }
    
    /**
     * API level 1
     * 
     * Set the message for dialog.
     * @param message
     * @return
     */
    public MessageDialogBuilder setMessage(int message) {
        mBuilder.setMessage(message);
        return this;
    }
    
    /**
     * API level 1
     * 
     * Set the default positive text to positive button.
     * @return
     */
    public MessageDialogBuilder setDefaultPositiveText() {
        mBuilder.setPositiveButton(android.R.string.ok, null);
        return this;
    }
    
}
