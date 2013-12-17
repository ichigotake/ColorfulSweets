package net.ichigotake.colorfulsweets.lib.ui;

import android.os.Handler;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ArrayAdapter;

import net.ichigotake.colorfulsweets.lib.model.LoadingState;
import net.ichigotake.colorfulsweets.lib.model.PagingState;

/**
 * API level 1
 *
 * The abstract class for auto paging implements on scroll.
 * This class has a {@link android.widget.AbsListView.OnScrollListener} interface.
 *
 * @param <T> The for {@link android.widget.ArrayAdapter}.
 */
public abstract class AbstractAtoPagingListener<T> implements OnScrollListener {

    final private PagingState mPagingState;

    final private Handler mHandler;
    
    final private LoadingState mState;

    /**
     * API level 1
     *
     * Return the item count per page for auto paging.
     *
     * @return
     */
    abstract protected int getPerPage();
    
    abstract protected void onPaging();

    abstract protected ArrayAdapter<T> getAdapter();

    /**
     * API level 1
     *
     * Constructor
     */
    public AbstractAtoPagingListener() {
        mHandler = new Handler();
        mPagingState = new PagingState(getPerPage());
        mState = new LoadingState();
    }



    /**
     * API level 1
     *
     * Run the first loading before auto paging.
     */
    public void onFirstLoading() {
        setRequesting(true);
        onPaging();
    }

    /**
     * API level 1
     *
     * Return the {@link net.ichigotake.colorfulsweets.lib.ui.AutoPagingParameter} to current
     * page state.
     *
     * @return
     */
    protected PagingState getParameter() {
        return mPagingState;
    }

    /**
     * API level 1
     *
     * Return true if auto paging request is progress.
     *
     * @return
     */
    protected boolean isRequesting() {
        return mState.isLoading();
    }

    protected void complete() {
        mState.complete();
    }

    /**
     * API level 1
     *
     * Set the current state for auto paging request.
     *
     * @param requesting
     */
    protected void setRequesting(boolean requesting) {
        mState.setIsLoading(requesting);
    }

    /**
     * API level 1
     *
     * Update {@link net.ichigotake.colorfulsweets.lib.model.PagingState} with forward to next page.
     */
    protected void nextPage() {
        getParameter().nextPage();
    }
    
    @Override
    public void onScroll(AbsListView view, int firstVisibleItem,
            int visibleItemCount, int totalItemCount) {
        if (! mState.completed() && ! isRequesting()
                && (firstVisibleItem + visibleItemCount) == totalItemCount) {

            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    onPaging();
                }
            });
        }
    }

    @Override
    public void onScrollStateChanged(AbsListView arg0, int arg1) {
        
    }

}
