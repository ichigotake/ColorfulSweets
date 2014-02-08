package net.ichigotake.colorfulsweets.sample.preference;

import net.ichigotake.colorfulsweets.lib.os.Key;

enum PreferenceKey implements Key {

    MODE_PRIVATE("mode_private"),
    EDIT_TEXT("edit_text"),
    SPINNER("spinner"),
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
