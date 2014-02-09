package net.ichigotake.colorfulsweets.common.widget;

public interface SpinnerSelectedListener<T extends SpinnerSelectedEvent> {

    public void onItemSelected(T event);
}
