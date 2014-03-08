package net.ichigotake.colorfulsweets.appcompat.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import net.ichigotake.colorfulsweets.appcompat.R;
import net.ichigotake.colorfulsweets.common.widget.paging.LoadingState;
import net.ichigotake.colorfulsweets.common.widget.paging.PagingState;

/**
 * The Fragment for auto paging container.
 */
abstract public class AutoPagingFragment extends Fragment {

    private static BaseAdapter sAdapter;
    private static LoadingState sLoadingState;
    private static PagingState sPagingParameter;

    protected BaseAdapter getAdapter() {
        if (sAdapter == null) {
            sAdapter = createAdapter();
        }
        return sAdapter;
    }

    protected LoadingState getLoadingState() {
        if (sLoadingState == null) {
            sLoadingState = new LoadingState();
        }
        return sLoadingState;
    }

    protected PagingState getPagingState() {
        if (sPagingParameter == null) {
            sPagingParameter = new PagingState(getPerPage());
        }
        return sPagingParameter;
    }

    protected void onFirstLoading() {
        onPaging();
    }


    abstract protected void onPaging();

    abstract protected View createView(
            LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState);

    abstract protected ListView getListView(View view);

    abstract protected BaseAdapter createAdapter();

    abstract protected int getPerPage();

    protected void nextPage() {
        getPagingState().nextPage();
    }

    protected View getProgressBarViewGroup(View view) {
        return LayoutInflater.from(view.getContext())
                .inflate(R.layout.colorfulsweets_progress_bar, null);
    }

    protected View getProgressView(View view) {
        return view.findViewById(R.id.colorfullsweets_progressBar);
    }

    protected boolean isRequesting() {
        return sLoadingState.isLoading();
    }

    protected void finish() {
        nextPage();
        getLoadingState().finish();
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                getProgressView(getView()).setVisibility(View.GONE);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent,
                             Bundle savedInstanceState) {
        return createView(inflater, parent, savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ListView listView = getListView(getView());
        listView.addFooterView(getProgressBarViewGroup(getView()));
        listView.setAdapter(getAdapter());
        getAdapter().notifyDataSetChanged();

        getLoadingState().start();
        onFirstLoading();
        //must do after onFirstLoading()
        getListView(getView()).setOnScrollListener(new AutoPagingOnScrollListener());
    }


    private class AutoPagingOnScrollListener implements AbsListView.OnScrollListener {

        @Override
        public void onScrollStateChanged(AbsListView view, int scrollState) {

        }

        @Override
        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            if (! getLoadingState().completed() && ! isRequesting()
                    && (firstVisibleItem + visibleItemCount) == totalItemCount) {

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        getProgressView(getView()).setVisibility(View.VISIBLE);
                    }
                });
                getLoadingState().start();
                onPaging();
            }
        }
    }
}
