package net.ichigotake.colorfulsweets.lib.ui;

import android.app.Activity;
import android.util.DisplayMetrics;

/**
 * API level 1
 * 
 * Display utilities.
 */
public class Display {

    /**
     * API level 1
     * 
     * TODO Add description
     * @param activity
     * @param pixel
     * @return
     */
    public static float calcDensity(Activity activity, int pixel) {
        DisplayMetrics metrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        return pixel * metrics.density;
    }
}
