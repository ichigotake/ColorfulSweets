package net.ichigotake.colorfulsweets.lib.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import net.ichigotake.colorfulsweets.lib.os.BundleSimple;
import net.ichigotake.colorfulsweets.lib.os.Key;
import net.ichigotake.colorfulsweets.lib.os.SaveInstanceStore;

import java.io.Serializable;

public class BaseFragment extends Fragment {

    private SaveInstanceStore mStore;

    protected void putSaveInstanceStore(String key, Serializable value) {
        mStore.put(key, value);
    }

    protected void putSaveInstanceStore(Key key, Serializable value) {
        putSaveInstanceStore(key.getKey(), value);
    }

    protected SaveInstanceStore getSaveInstanceStore() {
        return mStore;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mStore = new SaveInstanceStore(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        BundleSimple bundle = new BundleSimple(outState);
        super.onSaveInstanceState(bundle.toBundle());
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mStore.onActivityCreated(savedInstanceState);
    }

}
