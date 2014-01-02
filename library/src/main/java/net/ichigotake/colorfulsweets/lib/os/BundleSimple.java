package net.ichigotake.colorfulsweets.lib.os;

import android.os.Bundle;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

/**
 * TODO un-implements methods.
 */
public class BundleSimple {

    final private Bundle mBundle;

    public BundleSimple() {
        mBundle = new Bundle();
    }

    public BundleSimple(Bundle bundle) {
        mBundle = bundle == null ? new Bundle() : bundle;
    }

    public Bundle toBundle() {
        return mBundle;
    }

    public void containsKey(String key) {
        mBundle.containsKey(key);
    }

    public int size() {
        return mBundle.size();
    }

    public void clear() {
        mBundle.clear();
    }

    public void remove(String key) {
        mBundle.remove(key);
    }

    public boolean isEmpty() {
        return mBundle.isEmpty();
    }

    public Set<String> keySet() {
        return mBundle.keySet();
    }

    public void putAll(Bundle bundle) {
        mBundle.putAll(bundle);
    }

    public Object get(String key) {
        return mBundle.get(key);
    }

    public void put(String key, String string) {
        mBundle.putString(key, string);
    }

    public String getString(String key) {
        return mBundle.getString(key);
    }

    public String getString(String key, String defaultValue) {
        return mBundle.getString(key, defaultValue);
    }

    public void put(String key, String[] string) {
        mBundle.putStringArray(key, string);
    }

    public String[] getStringArray(String key) {
        return mBundle.getStringArray(key);
    }

    public void putStringArrayList(String key, ArrayList<String> string) {
        mBundle.putStringArrayList(key, string);
    }

    public ArrayList<String> getStringArrayList(String key) {
        return mBundle.getStringArrayList(key);
    }

    public void put(String key, int integer) {
        mBundle.putInt(key, integer);
    }

    public int getInt(String key) {
        return mBundle.getInt(key);
    }

    public void put(String key, int[] integer) {
        mBundle.putIntArray(key, integer);
    }

    public int[] getIntArray(String key) {
        return mBundle.getIntArray(key);
    }

    public int[] getIntArray(String key, int defaultValue) {
        return mBundle.getIntArray(key);
    }

    public void putIntegerArrayList(String key, ArrayList<Integer> integers) {
        mBundle.putIntegerArrayList(key, integers);
    }

    public ArrayList<Integer> getIntegerArrayList(String key) {
        return mBundle.getIntegerArrayList(key);
    }

    public void put(String key, Serializable serializable) {
        mBundle.putSerializable(key, serializable);
    }

    public Serializable getSerializable(String key) {
        return mBundle.getSerializable(key);
    }

    public void put(String key, Parcelable parcelable) {
        mBundle.putParcelable(key, parcelable);
    }

    public Parcelable getParcelable(String key) {
        return mBundle.getParcelable(key);
    }

    public void put(String key, boolean bool) {
        mBundle.putBoolean(key, bool);
    }

    public boolean getBoolean(String key) {
        return mBundle.getBoolean(key);
    }

    public boolean getBoolean(String key, boolean defaultBoolean) {
        return mBundle.getBoolean(key, defaultBoolean);
    }

    public void put(String key, boolean[] bools) {
        mBundle.putBooleanArray(key, bools);
    }

    public boolean[] getBooleanArray(String key) {
        return mBundle.getBooleanArray(key);
    }

    public void put(String key, byte value) {
        mBundle.putByte(key, value);
    }

    public byte getByte(String key) {
        return mBundle.getByte(key);
    }

    public byte getByte(String key, byte defaultValue) {
        return mBundle.getByte(key, defaultValue);
    }

    public void put(String key, byte[] bytes) {
        mBundle.putByteArray(key, bytes);
    }

    public byte[] getByteArray(String key) {
        return mBundle.getByteArray(key);
    }

}
