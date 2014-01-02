package net.ichigotake.colorfulsweets.lib.widget;

public interface SpinnerSelectedEvent<T> {

    public boolean isItemChanged();

    public T getItem();
}
