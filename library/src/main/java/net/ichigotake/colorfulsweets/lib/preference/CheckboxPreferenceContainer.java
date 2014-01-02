package net.ichigotake.colorfulsweets.lib.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import net.ichigotake.colorfulsweets.lib.os.Key;

public class CheckboxPreferenceContainer implements PreferenceListener<CheckBox> {

    final private SharedPreferences mPref;

    public CheckboxPreferenceContainer(Context context) {
        mPref = context.getSharedPreferences(PreferenceKey.MODE_PRIVATE.getKey(), Context.MODE_PRIVATE);
    }

    @Override
    public void setPreferenceCommitListener(CheckBox view, Key key) {
        view.setOnCheckedChangeListener(new PreferenceCommitListener(mPref, key));
    }

    private static class PreferenceCommitListener implements CompoundButton.OnCheckedChangeListener {

        final private SharedPreferences mPref;
        final private Key mKey;

        public PreferenceCommitListener(SharedPreferences pref, Key key) {
            mPref = pref;
            mKey = key;
        }

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
            SharedPreferences.Editor editor = mPref.edit();
            editor.putBoolean(mKey.getKey(), checked);
            editor.commit();
        }
    }
}
