package net.ichigotake.colorfulsweets.lib.net.http;

import android.content.Context;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import net.ichigotake.colorfulsweets.lib.model.PagingParameter;
import net.ichigotake.colorfulsweets.lib.ui.AbstractAtoPagingListener;

/**
 * API level 8
 * 
 * Auto paging when scroll bottom for {@link ListView}.
 *
 * TODO add document for method.
 * @param <T> For {@link android.widget.ArrayAdapter}
 * @param <R> Request parameter
 */
public abstract class AutoPagingListener<T, R>
	extends AbstractAtoPagingListener<T>
	implements HttpAccessEventListener {

    final private AsyncRequest<R> mRequest;
    final private RequestQueue mQueue;

	public AutoPagingListener(Context context) {
		super();
        mRequest = createRequest(getParameter());
        mQueue = Volley.newRequestQueue(context);
	}

    abstract protected AsyncRequest<R> createRequest(PagingParameter parameter);

	@Override
	protected void onPaging() {
        mQueue.add(mRequest.createRequest());
	}

}

