package net.ichigotake.colorfulsweets.lib.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.EditText;

import net.ichigotake.colorfulsweets.lib.os.Key;

public class EditTextPreferenceContainer implements PreferenceListener<EditText> {

    final private SharedPreferences mPref;

    public EditTextPreferenceContainer(Context context) {
        mPref = context.getSharedPreferences(PreferenceKey.MODE_PRIVATE.toString(), Context.MODE_PRIVATE);
    }

    @Override
    public void setPreferenceCommitListener(EditText editText, Key key) {
        editText.setOnFocusChangeListener(new CommitPreference(mPref, key));
    }

    private static class CommitPreference implements View.OnFocusChangeListener {

        final private SharedPreferences mPref;
        final private Key mKey;

        CommitPreference(SharedPreferences pref, Key key) {
            mPref = pref;
            mKey = key;
        }

        @Override
        public void onFocusChange(View view, boolean hasFocus) {
            if (! hasFocus) {
                String value = ((EditText)view).getText().toString();
                SharedPreferences.Editor editor = mPref.edit();
                editor.putString(mKey.getKey(), value);
                editor.commit();
            }
        }
    }
}
