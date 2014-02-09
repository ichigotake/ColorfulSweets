package net.ichigotake.colorfulsweets.common.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import net.ichigotake.colorfulsweets.common.R;

import java.util.List;

/**
 * API level 1
 * 
 * Shown menu list with {@link android.widget.ArrayAdapter}
 * TODO replacement extends class {@link android.widget.ArrayAdapter} to {@link android.widget.BaseAdapter} ?
 */
public class SimpleMenuItemAdapter extends ArrayAdapter<SimpleMenuItem> {

    final private LayoutInflater mInflater;

    final private int mItemLayoutRes;

    /**
     * API level 1
     *
     * Constructor
     * @param context The current context.
     * @param menus The shown menu list.
     */
    public SimpleMenuItemAdapter(Context context, List<SimpleMenuItem> menus) {
        this(context, R.layout.menu_item, menus);
    }

    /**
     * API level 1
     *
     * Constructor
     * @param context The current context.
     * The resource ID for a layout file containing a TextView to use when instantiating views.
     * @param itemLayoutRes The resource ID for a layout file containing a {@link android.widget.TextView} to use when instantiating views.
     * @param menus The shown menu list from {@link SimpleMenuItem}
     */
    public SimpleMenuItemAdapter(Context context, int itemLayoutRes, List<SimpleMenuItem> menus) {
        super(context, itemLayoutRes, menus);
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mItemLayoutRes = itemLayoutRes;
    }
    
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mInflater.inflate(mItemLayoutRes, null);
        }
        
        SimpleMenuItem item = getItem(position);
        
        TextView itemText = (TextView) convertView;
        itemText.setText(item.getLabelName());
        itemText.setCompoundDrawablesWithIntrinsicBounds(item.getIconResource(), 0, 0, 0);

        return convertView;
    }
    
}
