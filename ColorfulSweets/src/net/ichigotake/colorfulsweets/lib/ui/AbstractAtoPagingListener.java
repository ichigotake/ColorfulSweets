package net.ichigotake.colorfulsweets.lib.ui;

import net.ichigotake.colorfulsweets.lib.model.PagingParameter;
import android.content.Context;
import android.os.Handler;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.AbsListView.OnScrollListener;

/**
 * API level 1
 *
 * The abstract class for auto paging implements on scroll.
 * This class has a {@link android.widget.AbsListView.OnScrollListener} interface.
 *
 * @param <T> The for {@link android.widget.ArrayAdapter}.
 */
public abstract class AbstractAtoPagingListener<T> implements OnScrollListener {

	final private ArrayAdapter<T> mAdapter;
	
	final private PagingParameter mPagingParameter;

    final private Handler mHandler;
	
	private boolean mRequesting;

    /**
     * API level 1
     *
     * Return the item count per page for auto paging.
     *
     * @return
     */
	abstract protected int getPerPage();
	
	abstract protected void onPaging();

    /**
     * API level 1
     *
     * Create {@link ArrayAdapter} for auto paging view.
     *
     * @param context
     * @return
     */
	abstract protected ArrayAdapter<T> createArrayAdapter(Context context);

    /**
     * API level 1
     *
     * Constructor
     *
     * @param context
     */
	public AbstractAtoPagingListener(Context context) {
        mHandler = new Handler();
		mAdapter = createArrayAdapter(context);
		mPagingParameter = new PagingParameter(getPerPage());
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
    protected PagingParameter getParameter() {
		return mPagingParameter;
	}

    /**
     * API level 1
     *
     * Return true if auto paging request is progress.
     *
     * @return
     */
	protected boolean isRequesting() {
		return mRequesting;
	}

    /**
     * API level 1
     *
     * Set the current state for auto paging request.
     *
     * @param requesting
     */
	protected void setRequesting(boolean requesting) {
		mRequesting = requesting;
	}

    /**
     * API level 1
     *
     * Return the {@link ArrayAdapter} for auto paging view.
     *
     * @return
     */
	public ArrayAdapter<T> getAdapter() {
		return mAdapter;
	}

    /**
     * API level 1
     *
     * Update {@link net.ichigotake.colorfulsweets.lib.model.PagingParameter} with forward to next page.
     */
    protected void nextPage() {
        getParameter().nextPage();
    }
	
	@Override
	public void onScroll(AbsListView view, int firstVisibleItem,
			int visibleItemCount, int totalItemCount) {
		if (! isRequesting()
				&& (firstVisibleItem + visibleItemCount) == totalItemCount) {

            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    onPaging();
                    nextPage();
                }
            });
		}
	}

	@Override
	public void onScrollStateChanged(AbsListView arg0, int arg1) {
		
	}

}
