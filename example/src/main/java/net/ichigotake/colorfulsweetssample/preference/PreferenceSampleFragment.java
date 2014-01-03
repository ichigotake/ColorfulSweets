package net.ichigotake.colorfulsweetssample.preference;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;

import net.ichigotake.colorfulsweets.lib.preference.PreferenceEditTextCreator;
import net.ichigotake.colorfulsweetssample.R;

public class PreferenceSampleFragment extends Fragment {

    public static PreferenceSampleFragment newInstance() {
        return new PreferenceSampleFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.preferencfe, null);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        SharedPreferences pref = AppPref.from(getActivity());

        PreferenceEditTextCreator preferenceEditTextCreator = new PreferenceEditTextCreator(pref);
        EditText editText = (EditText)getView().findViewById(R.id.preferenceEditText);
        preferenceEditTextCreator
                .setPreferenceCommitListener(
                        editText, PreferenceKey.EDIT_TEXT, new EditTextWatcher(getActivity()));

        Spinner spinner = (Spinner)getView().findViewById(R.id.preferenceSpinner);
        new PreferenceSpinnerContainerImpl(getActivity(), PreferenceKey.SPINNER, spinner)
                .initialize();
    }

}
