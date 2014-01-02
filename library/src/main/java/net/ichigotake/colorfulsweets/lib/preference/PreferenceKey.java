package net.ichigotake.colorfulsweets.lib.preference;

import net.ichigotake.colorfulsweets.lib.os.Key;

public enum PreferenceKey implements Key {
    MODE_PRIVATE("pref_colorfulsweets_private"),
    ;

    final private String mKey;

    private PreferenceKey(String key) {
        mKey = key;
    }

    @Override
    public String getKey() {
        return mKey;
    }

    @Override
    public String toString() {
        return mKey;
    }
}
