package net.ichigotake.colorfulsweets.lib.preference;

import android.content.SharedPreferences;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.google.common.base.Optional;

import net.ichigotake.colorfulsweets.lib.os.Key;

public class PreferenceEditTextCreator implements PreferenceListener<EditText> {

    final private SharedPreferences mPref;

    public PreferenceEditTextCreator(SharedPreferences pref) {
        mPref = pref;
    }

    @Override
    public void setPreferenceCommitListener(EditText editText, Key key) {
        editText.addTextChangedListener(
                new CommitPreference(mPref, key, Optional.<TextWatcher>absent()));
    }

    public void setPreferenceCommitListener(EditText editText, Key key, TextWatcher listener) {
        editText.setText(mPref.getString(key.getKey(), ""));
        editText.addTextChangedListener(new CommitPreference(mPref, key, Optional.of(listener)));
    }

    private static class CommitPreference implements TextWatcher {

        final private SharedPreferences mPref;
        final private Key mKey;
        final private Optional<TextWatcher> mListener;

        CommitPreference(SharedPreferences pref, Key key, Optional<TextWatcher> listener) {
            mPref = pref;
            mKey = key;
            mListener = listener;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            if (mListener.isPresent()) {
                mListener.get().beforeTextChanged(s, start, count, after);
            }
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (mListener.isPresent()) {
                mListener.get().onTextChanged(s, start, before, count);
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {
            SharedPreferences.Editor editor = mPref.edit();
            editor.putString(mKey.getKey(), editable.toString());
            editor.commit();

            if (mListener.isPresent()) {
                mListener.get().afterTextChanged(editable);
            }
        }
    }
}