package net.ichigotake.colorfulsweets.lib.menu;

import android.content.Context;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * API level 1
 */
public class SimpleMenuListInitializer {

    final private Context mContext;
    
    /**
     * API level 1
     */
    public SimpleMenuListInitializer(Context context) {
        mContext = context;
    }
    
    /**
     * API level 1
     */
    public void initialize(ListView listView, SimpleMenu[] menu) {
        final List<SimpleMenuItem> menus = new ArrayList<SimpleMenuItem>();
        
        int length = menu.length;
        for (int i=0; i<length; i++) {
            menus.add(new SimpleMenuItem(mContext, menu[i]));
        }

        initialize(listView, menus);
    }

    /**
     * API level 1
     */
    public void initialize(ListView listView, List<SimpleMenuItem> menu) {
        SimpleMenuItemAdapter adapter = new SimpleMenuItemAdapter(mContext, menu);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

}
