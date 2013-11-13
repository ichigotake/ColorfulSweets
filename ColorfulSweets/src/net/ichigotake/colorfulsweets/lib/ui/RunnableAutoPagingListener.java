package net.ichigotake.colorfulsweets.lib.ui;

import android.content.Context;

/**
 * API level 3
 *
 * Run the auto paging task in background.
 *
 * @param <T> The {@link android.widget.ArrayAdapter} item for auto paging view.
 */
public abstract class RunnableAutoPagingListener<T>
	extends AbstractAtoPagingListener<T> {

    final private AutoPagingListener mListener;

    /**
     * API level 1
     *
     * Constructor.
     *
     * @param context
     */
	public RunnableAutoPagingListener(Context context) {
		super(context);
        mListener = new AutoPagingListener(this);
	}

    /**
     * API level 3
     *
     * Run the auto paging.
     */
	@Override
	protected void onPaging() {
        if (! isRequesting()) {
            AsyncRunnableTask task = new AsyncRunnableTask();
            task.execute(mListener, onPagingListener());
        } else {
            setRequesting(false);
        }
    }

    /**
     * API level 1
     *
     * Run the task in background.
     *
     * @return
     */
    abstract protected Runnable onPagingListener();


    private static class AutoPagingListener implements Runnable {

        final private RunnableAutoPagingListener mListener;

        public AutoPagingListener(RunnableAutoPagingListener listener) {
            mListener = listener;
        }

        @Override
        public void run() {
            mListener.onPaging();
            mListener.setRequesting(false);
        }
    }
}
