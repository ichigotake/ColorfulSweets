package net.ichigotake.colorfulsweets.lib.widget;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Spinner;

public abstract class SpinnerContainer<I> {

    final private SpinnerSelectedListener<SpinnerSelectedEvent<I>> mListener;
    final private Activity mActivity;

    public SpinnerContainer(Activity activity,
                            SpinnerSelectedListener<SpinnerSelectedEvent<I>> listener) {
        mActivity = activity;
        mListener = listener;
    }

    abstract protected Spinner getSpinner();

    public void initialize() {
        BaseAdapter adapter = createAdapter();

        Spinner selectorView = getSpinner();
        selectorView.setAdapter(adapter);
        selectorView.setOnItemSelectedListener(new InnerListener());

        adapter.notifyDataSetChanged();
    }

    protected Activity getActivity() {
        return mActivity;
    }

    protected I getItem(AdapterView<?> adapterView) {
        return (I)adapterView.getSelectedItem();
    }

    abstract protected BaseAdapter createAdapter();

    abstract protected SpinnerSelectedEvent<I> createEvent(I item, boolean itemChanged);

    private class InnerListener implements AdapterView.OnItemSelectedListener {

        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            mListener.onItemSelected(createInnerEvent(adapterView, true));
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {
            mListener.onItemSelected(createInnerEvent(adapterView, false));
        }

        private SpinnerSelectedEvent<I> createInnerEvent(AdapterView<?> adapterView, boolean itemChanged) {
            I item = getItem(adapterView);
            return createEvent(item, itemChanged);
        }
    }
}
