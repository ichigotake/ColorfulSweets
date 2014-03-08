package net.ichigotake.colorfulsweets.sample;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;

public class ActionBar {

    public static android.support.v7.app.ActionBar get(Activity activity) {
        return ((ActionBarActivity)activity).getSupportActionBar();
    }
}
