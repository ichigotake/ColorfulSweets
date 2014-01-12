package net.ichigotake.colorfulsweets.lib.widget.paging;

import android.widget.ArrayAdapter;

public class AutoPagingParameter<T> {
    
    final private ArrayAdapter<T> mAdapter;
    
    final private int mTotalItemCount;
    
    public AutoPagingParameter(ArrayAdapter<T> adapter, int totalItemCount) {
        mAdapter = adapter;
        mTotalItemCount = totalItemCount;
    }
    
    public int getTotalItemCount() {
        return mTotalItemCount;
    }
    
    public ArrayAdapter<T> getAdapter() {
        return mAdapter;
    }
    
}
