package net.ichigotake.colorfulsweets.lib.net.http;

import net.ichigotake.colorfulsweets.lib.model.PagingParameter;
import net.ichigotake.colorfulsweets.lib.net.http.AsyncHttpAccessor;
import net.ichigotake.colorfulsweets.lib.net.http.ErrorEvent;
import net.ichigotake.colorfulsweets.lib.net.http.HttpAccessEventListener;
import net.ichigotake.colorfulsweets.lib.net.http.HttpAccessResponse;
import android.content.Context;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ArrayAdapter;

import com.google.common.eventbus.Subscribe;

/**
 * API level 1
 * 
 * Auto paging when scroll bottom for {@link ListView}.
 *
 * TODO add document for method.
 * @param <T>
 */
public abstract class AutoPagingListener<T>
	implements OnScrollListener, HttpAccessEventListener {

	final private ArrayAdapter<T> mAdapter;
	
	final private PagingParameter mPagingParameter;
	
	private boolean mRequesting;
	
	abstract protected int getPerPage();
	
	abstract protected ArrayAdapter<T> createArrayAdapter(Context context);
	
	abstract protected AsyncHttpAccessor createHttpAccessor(
			ArrayAdapter<T> adapter, PagingParameter parameter);
	
	public AutoPagingListener(Context context) {
		mAdapter = createArrayAdapter(context);
		mPagingParameter = new PagingParameter(getPerPage());
	}
	
	public ArrayAdapter<T> getAdapter() {
		return mAdapter;
	}
	
	@Subscribe
	public void onSuccess(HttpAccessResponse response) {
		mRequesting = false;
	}
	
	@Subscribe
	public void onError(ErrorEvent error) {
		mRequesting = false;
	}
	
	@Override
	public void onScroll(AbsListView view, int firstVisibleItem,
			int visibleItemCount, int totalItemCount) {
		if (! mRequesting
				&& (firstVisibleItem + visibleItemCount) == totalItemCount) {
			
			AsyncHttpAccessor accessor =
					createHttpAccessor(mAdapter, mPagingParameter);
			accessor.registerListener(this);
			accessor.start();
			mPagingParameter.nextPage();
		}
	}

	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
		// do nothing
	}
	
}

