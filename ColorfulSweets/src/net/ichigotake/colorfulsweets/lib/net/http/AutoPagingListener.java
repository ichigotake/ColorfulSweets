package net.ichigotake.colorfulsweets.lib.net.http;

import net.ichigotake.colorfulsweets.lib.model.PagingParameter;
import net.ichigotake.colorfulsweets.lib.ui.AbstractAtoPagingListener;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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
	extends AbstractAtoPagingListener<T>
	implements HttpAccessEventListener {

	public AutoPagingListener(Context context) {
		super(context);
	}

	abstract protected AsyncHttpAccessor createHttpAccessor(
			ArrayAdapter<T> adapter, PagingParameter parameter);
	
	@Subscribe
	public void onSuccess(HttpAccessResponse response) {
		setRequesting(false);
	}
	
	@Subscribe
	public void onError(ErrorEvent error) {
		setRequesting(false);
	}
	
	@Override
	protected void onPaging() {
		AsyncHttpAccessor accessor =
				createHttpAccessor(getAdapter(), getParameter());
		accessor.registerListener(this);
		accessor.start();
	}

}

