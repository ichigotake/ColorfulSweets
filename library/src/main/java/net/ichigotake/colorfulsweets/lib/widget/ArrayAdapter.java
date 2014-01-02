package net.ichigotake.colorfulsweets.lib.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public abstract class ArrayAdapter<H extends ViewHolder, T> extends android.widget.ArrayAdapter<T> {

    final private LayoutInflater mInflater;
    final private ViewConnector<H, T> mConnector;

    public ArrayAdapter(Context context, ViewConnector<H, T> connector, List<T> objects) {
        super(context, android.R.layout.simple_list_item_1, objects);
        mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mConnector = connector;
    }

    public ArrayAdapter(Context context, ViewConnector<H, T> connector) {
        super(context, android.R.layout.simple_list_item_1);
        mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mConnector = connector;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final T item = getItem(position);
        final H holder;
        if (convertView == null) {
            convertView = mConnector.generateView(mInflater, position, item);
            holder = createViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (H)convertView.getTag();
        }

        mConnector.connectView(position, holder, item);

        return convertView;
    }

    abstract protected H createViewHolder(View convertView);
}
