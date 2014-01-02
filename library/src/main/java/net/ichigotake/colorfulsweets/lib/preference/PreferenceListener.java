package net.ichigotake.colorfulsweets.lib.preference;

import android.view.View;

import net.ichigotake.colorfulsweets.lib.os.Key;

public interface PreferenceListener<V extends View> {

    void setPreferenceCommitListener(V view, Key key);
}
