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
public abstract class AutoPagingRequestListener<T, R>
    extends AbstractAtoPagingListener<T> {

    final private RequestQueue mQueue;

    public AutoPagingRequestListener(Context context) {
        super();
        mQueue = Volley.newRequestQueue(context);
    }

    abstract protected AsyncRequest<R> createRequest(PagingParameter parameter);

    @Override
    protected void onPaging() {
        AsyncRequest<R> mRequest = createRequest(getParameter());
        mRequest.registerListener(new OnPagingListener());
        mRequest.eventPost(new BeforeRequestEvent());
        mQueue.add(mRequest.createRequest());
    }

    private class OnPagingListener implements ResponseListener<R> {

        @Override
        public void onResponse(R response) {
            nextPage();
        }
    }

}

