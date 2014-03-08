package net.ichigotake.colorfulsweets.common.preference;

import android.content.Context;
import android.content.SharedPreferences;

public class Pref {

    public static SharedPreferences from(Context context, Object key) {
        return context.getSharedPreferences(key.toString(), Context.MODE_PRIVATE);
    }
}
