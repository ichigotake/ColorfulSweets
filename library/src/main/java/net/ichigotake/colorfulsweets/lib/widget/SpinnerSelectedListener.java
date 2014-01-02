package net.ichigotake.colorfulsweets.lib.widget;

public interface SpinnerSelectedListener<T extends SpinnerSelectedEvent> {

    public void onItemSelected(T event);
}
