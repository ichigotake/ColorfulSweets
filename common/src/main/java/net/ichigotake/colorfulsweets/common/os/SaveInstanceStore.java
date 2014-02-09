package net.ichigotake.colorfulsweets.common.os;

import android.os.Bundle;

import java.io.Serializable;

public class SaveInstanceStore {

    final private BundleSimple mStore;

    public SaveInstanceStore() {
        mStore = new BundleSimple();
    }

    public SaveInstanceStore(Bundle savedInstanceState) {
        mStore = new BundleSimple();
    }

    public Bundle toBundle() {
        return mStore.toBundle();
    }

    public BundleSimple toBundleSimple() {
        return mStore;
    }

    public void put(String key, Serializable value) {
        mStore.put(key, value);
    }

    public BundleSimple get() {
        return mStore;
    }

    public Bundle onSaveInstanceState(Bundle outState) {
        BundleSimple bundle = new BundleSimple(outState);
        for (String key : mStore.keySet()) {
            bundle.put(key, mStore.getSerializable(key));
        }
        return bundle.toBundle();
    }

    public void putAll(Bundle bundle) {
        if (bundle != null) {
            mStore.putAll(bundle);
        }
    }
}
