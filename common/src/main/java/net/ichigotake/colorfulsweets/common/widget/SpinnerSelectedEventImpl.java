package net.ichigotake.colorfulsweets.common.widget;

public class SpinnerSelectedEventImpl<I> implements SpinnerSelectedEvent<I> {

    final private I mItem;
    final private boolean mIsItemChanged;

    public SpinnerSelectedEventImpl(I item, boolean isChanged) {
        mItem = item;
        mIsItemChanged = isChanged;
    }

    @Override
    public boolean isItemChanged() {
        return mIsItemChanged;
    }

    @Override
    public I getItem() {
        return mItem;
    }
}
