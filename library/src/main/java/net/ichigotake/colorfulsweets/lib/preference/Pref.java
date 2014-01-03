package net.ichigotake.colorfulsweets.lib.preference;

import android.content.Context;
import android.content.SharedPreferences;

import net.ichigotake.colorfulsweets.lib.os.Key;

public class Pref {

    public static SharedPreferences from(Context context, Key preferenceKey) {
        return context.getSharedPreferences(preferenceKey.getKey(), Context.MODE_PRIVATE);
    }
}
