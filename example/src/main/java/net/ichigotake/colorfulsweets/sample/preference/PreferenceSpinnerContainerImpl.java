package net.ichigotake.colorfulsweets.sample.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import net.ichigotake.colorfulsweets.lib.os.Key;
import net.ichigotake.colorfulsweets.lib.preference.PreferenceSpinnerContainer;
import net.ichigotake.colorfulsweets.lib.widget.SpinnerSelectedEvent;
import net.ichigotake.colorfulsweets.lib.widget.SpinnerSelectedListener;
import net.ichigotake.colorfulsweets.sample.R;

class PreferenceSpinnerContainerImpl extends PreferenceSpinnerContainer {

    final private Context mContext;
    final private Spinner mSpinner;

    PreferenceSpinnerContainerImpl(Context context, Key preferenceKey, Spinner spinner) {
        super(AppPref.from(context), preferenceKey, new SpinnerChangedListener(context, preferenceKey));
        mContext = context;
        mSpinner = spinner;
    }

    @Override
    protected Spinner getSpinner() {
        return mSpinner;
    }

    @Override
    protected BaseAdapter createAdapter() {
        CharSequence[] orders = mContext.getResources().getTextArray(R.array.preferenceSpinner);
        return new AdapterImpl(mContext, android.R.layout.simple_list_item_1, orders);
    }

    private static class SpinnerChangedListener implements
            SpinnerSelectedListener<SpinnerSelectedEvent<Object>> {

        final private Context mContext;
        final private SharedPreferences mPref;
        final private Key mPreferenceKey;

        public SpinnerChangedListener(Context context, Key preferenceKey) {
            mContext = context;
            mPref = AppPref.from(context);
            mPreferenceKey = preferenceKey;
        }

        @Override
        public void onItemSelected(SpinnerSelectedEvent<Object> event) {
            String value = mPref.getString(mPreferenceKey.getKey().toString(), "");
            String message = "selected: " + event.getItem().toString() + ", " + "pref: " + value;
            Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
        }
    }

    private static class AdapterImpl extends ArrayAdapter {

        public AdapterImpl(Context context, int resource, Object[] objects) {
            super(context, resource, objects);
        }
    }
}
