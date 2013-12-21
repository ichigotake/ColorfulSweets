package net.ichigotake.colorfulsweets.lib.menu;

import android.content.Context;
import android.widget.ListView;

import net.ichigotake.colorfulsweets.lib.view.ListItemOnClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * API level 1
 */
public class SimpleSimpleMenuListFactory implements SimpleMenuItemListFactory {

    final private SimpleMenu[] mMenu;
    
    final private ListItemOnClickListener mListener;
    
    /**
     * API level 1
     * 
     * @param menu
     * @param listener
     */
    public SimpleSimpleMenuListFactory(SimpleMenu[] menu, ListItemOnClickListener listener) {
        mMenu = menu;
        mListener = listener;
    }
    
    public SimpleSimpleMenuListFactory(SimpleMenu[] menu) {
        mMenu = menu;
        mListener = null;
    }
    
    /**
     * API level 1
     * 
     */
    @Override
    public List<SimpleMenuItem> create() {
        final List<SimpleMenuItem> menus = new ArrayList<SimpleMenuItem>();
        
        int length = mMenu.length;
        for (int i=0; i<length; i++) {
            SimpleMenuItem item = new SimpleMenuItem(mMenu[i]);
            item.setOnClickListener(mListener);
            menus.add(item);
        }
        
        return menus;
    }

    /**
     * API level 1
     * 
     * Show the menu.
     */
    @Override
    public void show(Context context, ListView listView) {
        SimpleMenuItemAdapter adapter = new SimpleMenuItemAdapter(context, create());
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
    

}
