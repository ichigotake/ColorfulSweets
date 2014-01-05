package net.ichigotake.colorfulsweets.lib.preference;

import android.content.SharedPreferences;
import android.widget.Spinner;

import com.google.common.base.Optional;

import net.ichigotake.colorfulsweets.lib.os.Key;
import net.ichigotake.colorfulsweets.lib.widget.SpinnerContainer;
import net.ichigotake.colorfulsweets.lib.widget.SpinnerSelectedEvent;
import net.ichigotake.colorfulsweets.lib.widget.SpinnerSelectedEventImpl;
import net.ichigotake.colorfulsweets.lib.widget.SpinnerSelectedListener;

public abstract class PreferenceSpinnerContainer extends SpinnerContainer<Object> {

    final private SharedPreferences mPref;
    final private Key mPreferenceKey;

    public PreferenceSpinnerContainer(SharedPreferences pref, Key preferenceKey) {
        super(new PreferenceListener(pref, preferenceKey,
                Optional.<SpinnerSelectedListener<SpinnerSelectedEvent<Object>>>absent()));
        mPref = pref;
        mPreferenceKey = preferenceKey;
    }

    public PreferenceSpinnerContainer(SharedPreferences pref, Key preferenceKey,
                                      SpinnerSelectedListener<SpinnerSelectedEvent<Object>> listener) {
        super(new PreferenceListener(pref, preferenceKey, Optional.of(listener)));
        mPref = pref;
        mPreferenceKey = preferenceKey;
    }

    @Override
    public void initialize() {
        super.initialize();
        String value = mPref.getString(mPreferenceKey.getKey(), "");
        getSpinner().setSelection(getIndex(value));
    }

    @Override
    protected SpinnerSelectedEvent<Object> createEvent(Object item, boolean itemChanged) {
        return new SpinnerSelectedEventImpl<Object>(item, itemChanged);
    }

    protected int getIndex(String value) {
        int index = 0;
        Spinner spinner = getSpinner();
        for (int i=0,count=spinner.getCount(); i<count; i++){
            if (spinner.getItemAtPosition(i).equals(value)){
                index = i;
                break;
            }
        }
        return index;
    }

    private static class PreferenceListener implements SpinnerSelectedListener<SpinnerSelectedEvent<Object>> {

        final private SharedPreferences mPref;
        final private Key mKey;
        final private Optional<SpinnerSelectedListener<SpinnerSelectedEvent<Object>>> mListener;

        PreferenceListener(SharedPreferences pref, Key key,
                           Optional<SpinnerSelectedListener<SpinnerSelectedEvent<Object>>> listener) {
            mPref = pref;
            mKey = key;
            mListener = listener;
        }

        @Override
        public void onItemSelected(SpinnerSelectedEvent<Object> event) {
            SharedPreferences.Editor editor = mPref.edit();
            editor.putString(mKey.getKey(), event.getItem().toString());
            editor.commit();

            if (mListener.isPresent()) {
                mListener.get().onItemSelected(event);
            }
        }
    }

}
