package net.ichigotake.colorfulsweets.lib.ui;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.IBinder;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.inputmethod.InputMethodManager;


/**
 * API level 1
 *
 * Handle soft input.
 */
public class SoftInput {

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
     * API level 4
     *
     * Hide on screen keyboard.
     *
     * @param fragment The target fragment
     */
	public static void hide(Fragment fragment) {
		try {
			List<Fragment> fragments = fragment.getFragmentManager().getFragments();
			hide(fragments.get(0).getView());
		} catch (Exception e) {
			e.printStackTrace();
			// do nothing
		}
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
