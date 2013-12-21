package net.ichigotake.colorfulsweets.lib.net.http;

import android.content.Context;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.google.common.eventbus.Subscribe;

import net.ichigotake.colorfulsweets.lib.model.PagingState;
import net.ichigotake.colorfulsweets.lib.widget.AbstractAtoPagingListener;

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

    abstract protected AsyncRequest<R> createRequest(PagingState parameter);

    @Override
    protected void onPaging() {
        setRequesting(true);
        AsyncRequest<R> mRequest = createRequest(getParameter());
        mRequest.registerListener(new OnPagingListener());
        mRequest.eventPost(new BeforeRequestEvent());
        mQueue.add(mRequest.createRequest());
    }

    private class OnPagingListener implements ResponseListener<R> {

        @Override
        public void onResponse(R response) {
            // do nothing
        }

        @Override
        public void onError(VolleyError error) {
            finish();
            complete();
        }

        @Subscribe
        public void afterResponse(AfterResponse response) {
            finish();
            nextPage();
        }
    }

}

