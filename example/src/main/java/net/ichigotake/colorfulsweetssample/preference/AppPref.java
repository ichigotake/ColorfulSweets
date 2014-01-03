package net.ichigotake.colorfulsweetssample.preference;

import android.content.Context;
import android.content.SharedPreferences;

import net.ichigotake.colorfulsweets.lib.preference.Pref;

class AppPref {

    static SharedPreferences from(Context context) {
        return Pref.from(context, PreferenceKey.MODE_PRIVATE);
    }
}
