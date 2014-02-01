package net.ichigotake.colorfulsweets.lib.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ListView;

import net.ichigotake.colorfulsweets.R;

import java.util.List;


/**
 * API Level 1
 * Shown menu list.
 */
public class SimpleMenuList {

    final private Context mContext;
    
    private ListView mListView;

    /**
     * API level 1
     * @param context
     */
    public SimpleMenuList(Context context) {
        mContext = context;
    }
    
    /**
     * API level 1
     * Set the {@link android.widget.ListView} to display.
     * @param listView
     */
    public void setListView(ListView listView) {
        mListView = listView;
    }

    /**
     * API level 1
     * Shown menu list
     * @param Menu item list
     * @param anchor base {@link android.widget.ListView}
     * @param listItemLayout List item resource for {@link SimpleMenuItemAdapter}
     */
    public void show(List<SimpleMenuItem> menus, ListView anchor, int listItemLayout) {
        ListView listView = getListView();
        SimpleMenuItemAdapter adapter = new SimpleMenuItemAdapter(mContext, R.layout.menu_item, menus);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
    
    /**
     * API level 1
     * @return
     */
    private ListView getListView() {
        final ListView listView;
        if (mListView == null) {
            listView = mListView;
        } else {
            listView = (ListView) LayoutInflater.from(mContext).inflate(R.layout.menu_list, null);
        }
        return listView;
    }
    
}
