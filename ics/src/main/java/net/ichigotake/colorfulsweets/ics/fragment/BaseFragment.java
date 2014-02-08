package net.ichigotake.colorfulsweets.ics.fragment;

import android.app.Fragment;
import android.os.Bundle;

import net.ichigotake.colorfulsweets.lib.os.BundleSimple;
import net.ichigotake.colorfulsweets.lib.os.Key;
import net.ichigotake.colorfulsweets.lib.os.SaveInstanceStore;

import java.io.Serializable;

public class BaseFragment extends Fragment {

    private static SaveInstanceStore mStore;

    protected void putSaveInstanceStore(Bundle args) {
        getSaveInstanceStore().putAll(args);
    }

    protected void putSaveInstanceStore(String key, Serializable value) {
        getSaveInstanceStore().put(key, value);
    }

    protected void putSaveInstanceStore(Key key, Serializable value) {
        putSaveInstanceStore(key.getKey(), value);
    }

    protected static SaveInstanceStore getSaveInstanceStore() {
        if (mStore == null) {
            mStore = new SaveInstanceStore();
        }
        return mStore;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mStore = new SaveInstanceStore(savedInstanceState);
        mStore.putAll(getArguments());
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        BundleSimple store = new BundleSimple(outState);
        store.putAll(getSaveInstanceStore().toBundle());
        super.onSaveInstanceState(store.toBundle());
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mStore.putAll(savedInstanceState);
    }

}
