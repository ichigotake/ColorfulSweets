package net.ichigotake.colorfulsweets.lib.widget.paging;

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

    /**
     * API level 3
     *
     * Set the auto paging listener to initialize {@link android.widget.ListView}.
     *
     * @param listView
     */
    public void initialize(ListView listView, RunnableAutoPagingListener<T> pagiableListener) {
        ArrayAdapter<T> adapter = pagiableListener.getAdapter();

        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        pagiableListener.onFirstLoading();

        listView.setOnScrollListener(pagiableListener);
    }
    
}
