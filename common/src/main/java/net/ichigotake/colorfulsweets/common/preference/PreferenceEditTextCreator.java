package net.ichigotake.colorfulsweets.common.preference;

import android.content.SharedPreferences;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import net.ichigotake.colorfulsweets.common.os.Key;

public class PreferenceEditTextCreator implements PreferenceListener<EditText> {

    final private SharedPreferences mPref;

    public PreferenceEditTextCreator(SharedPreferences pref) {
        mPref = pref;
    }

    @Override
    public void setPreferenceCommitListener(EditText editText, Key key) {
        editText.addTextChangedListener(new CommitPreference(mPref, key));
    }

    public void setPreferenceCommitListener(EditText editText, Key key, TextWatcher listener) {
        editText.setText(mPref.getString(key.getKey(), ""));
        editText.addTextChangedListener(new CommitPreference(mPref, key, listener));
    }

    private static class CommitPreference implements TextWatcher {

        final private SharedPreferences mPref;
        final private Key mKey;
        final private TextWatcher mListener;

        CommitPreference(SharedPreferences pref, Key key) {
            this(pref, key, null);
        }

        CommitPreference(SharedPreferences pref, Key key, TextWatcher listener) {
            mPref = pref;
            mKey = key;
            mListener = listener;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            if (mListener != null) {
                mListener.beforeTextChanged(s, start, count, after);
            }
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (mListener != null) {
                mListener.onTextChanged(s, start, before, count);
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {
            SharedPreferences.Editor editor = mPref.edit();
            editor.putString(mKey.getKey(), editable.toString());
            editor.commit();

            if (mListener != null) {
                mListener.afterTextChanged(editable);
            }
        }
    }
}
