package net.ichigotake.colorfulsweetssample.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Toast;


class EditTextWatcher implements TextWatcher {

    final private Context mContext;
    final private SharedPreferences mPref;

    EditTextWatcher(Context context) {
        mContext = context;
        mPref = AppPref.from(context);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        String value = mPref.getString(PreferenceKey.EDIT_TEXT.getKey(), "");
        String message = "EditText: " + editable.toString() + ", Pref: " + value;
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
   }
}
