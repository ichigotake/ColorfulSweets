package net.ichigotake.colorfulsweets.lib.widget;

import android.view.LayoutInflater;
import android.view.View;

/**
 * ビューとデータの仲介役
 */
public interface ViewConnector<T extends ViewHolder, E> {

    public View generateView(LayoutInflater inflater, int position, E item);

    public void connectView(int position, T holder, E item);
}
