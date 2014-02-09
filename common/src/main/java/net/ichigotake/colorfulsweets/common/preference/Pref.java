package net.ichigotake.colorfulsweets.common.preference;

import android.content.Context;
import android.content.SharedPreferences;

import net.ichigotake.colorfulsweets.common.os.Key;

public class Pref {

    public static SharedPreferences from(Context context, Key preferenceKey) {
        return context.getSharedPreferences(preferenceKey.getKey(), Context.MODE_PRIVATE);
    }
}
