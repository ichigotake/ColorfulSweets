package net.ichigotake.colorfulsweets.lib.widget;

/**
 * API level 3
 *
 * Run the auto paging task in background.
 *
 * @param <T> The {@link android.widget.ArrayAdapter} item for auto paging view.
 */
public abstract class RunnableAutoPagingListener<T>
    extends AbstractAtoPagingListener<T> {

    /**
     * API level 1
     *
     * Constructor.
     */
    public RunnableAutoPagingListener() {
        super();
    }

    /**
     * API level 3
     *
     * Run the auto paging.
     */
    @Override
    protected void onPaging() {
        if (! isRequesting()) {
            setRequesting(true);
            new AsyncRunnableTask().execute(onPagingListener());
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


}
