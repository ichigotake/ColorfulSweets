package net.ichigotake.colorfulsweets.common.widget;

public interface SpinnerSelectedEvent<T> {

    public boolean isItemChanged();

    public T getItem();
}
