package net.ichigotake.colorfulsweets.lib.view.inputmethod;

import android.app.Activity;
import android.content.Context;
import android.os.IBinder;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;


/**
 * API level 1
 *
 * Handle soft input.
 */
public class SoftInput {

    public static void alwaysHidden(Activity activity) {
        activity.getWindow().setSoftInputMode(WindowManager.LayoutParams
                .SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }
    /**
     * API level 1
     *
     * Hide on screen keyboard.
     *
     * @param activity The target activity
     */
    public static void hide(Activity activity) {
        InputMethodManager imManager =
                (InputMethodManager)activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        View view = activity.findViewById(android.R.id.content);
        imManager.hideSoftInputFromInputMethod(view.getWindowToken(), 0);
    }

    /**
     * API level 1
     *
     * Hide on screen keyboard.
     *
     * @param view The target view
     */
    public static void hide(View view) {
        try {
            InputMethodManager inputMethodManager =
                    (InputMethodManager)view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            IBinder windowToken = view.getWindowToken();
            inputMethodManager.hideSoftInputFromWindow(windowToken, InputMethodManager.HIDE_NOT_ALWAYS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
