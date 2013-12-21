package net.ichigotake.colorfulsweets.lib.widget;

import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * API level 3
 *
 * Run the auto paging task in background.
 *
 * @param <T> The {@link android.widget.ArrayAdapter} item for auto paging view.
 */
public class RunnableAutoPagingContainer<T> {

    final private RunnableAutoPagingListener<T> mPagiableListener;
    
    private ArrayAdapter<T> mAdapter;

    /**
     * API level 3
     *
     * Constructor.
     *
     * @param pagiableListener
     */
    public RunnableAutoPagingContainer(RunnableAutoPagingListener<T> pagiableListener) {
        mPagiableListener = pagiableListener;
    }

    /**
     * API level 3
     *
     * Set the auto paging listener to initialize {@link android.widget.ListView}.
     *
     * @param listView
     */
    public void initialize(ListView listView) {
        mAdapter = mPagiableListener.getAdapter();

        listView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

        mPagiableListener.onFirstLoading();

        listView.setOnScrollListener(mPagiableListener);
    }
    
}
