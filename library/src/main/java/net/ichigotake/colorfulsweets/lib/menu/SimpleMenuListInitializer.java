package net.ichigotake.colorfulsweets.lib.menu;

import android.content.Context;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * API level 1
 */
public class SimpleMenuListInitializer {

    final private SimpleMenu[] mMenu;
    
    /**
     * API level 1
     */
    public SimpleMenuListInitializer(SimpleMenu[] menu) {
        mMenu = menu;
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
            menus.add(new SimpleMenuItem(mMenu[i]));
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
