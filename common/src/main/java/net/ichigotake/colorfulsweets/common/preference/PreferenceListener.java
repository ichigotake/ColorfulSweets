package net.ichigotake.colorfulsweets.common.preference;

import android.view.View;

import net.ichigotake.colorfulsweets.common.os.Key;

public interface PreferenceListener<V extends View> {

    void setPreferenceCommitListener(V view, Key key);
}
