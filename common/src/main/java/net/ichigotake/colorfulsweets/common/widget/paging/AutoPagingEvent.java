package net.ichigotake.colorfulsweets.common.widget.paging;

import android.widget.ArrayAdapter;

public class AutoPagingEvent<T> {
    
    final private ArrayAdapter<T> mAdapter;
    
    final private int mTotalItemCount;
    
    public AutoPagingEvent(ArrayAdapter<T> adapter, int totalItemCount) {
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
