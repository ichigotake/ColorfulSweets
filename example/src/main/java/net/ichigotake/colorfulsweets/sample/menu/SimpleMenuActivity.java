package net.ichigotake.colorfulsweets.sample.menu;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import net.ichigotake.colorfulsweets.common.menu.SimpleMenu;
import net.ichigotake.colorfulsweets.common.menu.SimpleMenuListInitializer;
import net.ichigotake.colorfulsweets.sample.BaseActivity;
import net.ichigotake.colorfulsweets.sample.R;

public class SimpleMenuActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_menu_list);
        
        ListView menuListView = (ListView) findViewById(R.id.menu_list);
        menuListView.setOnItemClickListener(new SimpleMenuSampleOnClickListener(this));
        new SimpleMenuListInitializer(this)
                .initialize(menuListView, SimpleMenuSample.values());

    }

    /**
     * item list
     */
    private enum SimpleMenuSample implements SimpleMenu {

        SMAPLE1(R.string.simple_menu_item_sample1, R.drawable.abc_ic_ab_back_holo_light),
        SMAPLE2(R.string.simple_menu_item_sample2, R.drawable.abc_ic_cab_done_holo_light),
        SMAPLE3(R.string.simple_menu_item_sample3, R.drawable.abc_ic_search),
        SMAPLE4(R.string.simple_menu_item_sample4, R.drawable.abc_ic_commit_search_api_holo_light),
        SMAPLE5(R.string.simple_menu_item_sample5, R.drawable.abc_ic_go),
        SMAPLE6(R.string.simple_menu_item_sample6, R.drawable.abc_ic_clear),
        ;

        final private int mTitle;
        
        final private int mIcon;
        
        private SimpleMenuSample(int title, int icon) {
            mTitle = title;
            mIcon = icon;
        }
        
        @Override
        public int getLabelName() {
            return mTitle;
        }

        @Override
        public int getIconResource() {
            return mIcon;
        }

    }

    /**
     * item on click listener
     */
    private class SimpleMenuSampleOnClickListener implements AdapterView.OnItemClickListener {

        final private Context mContext;

        public SimpleMenuSampleOnClickListener(Context context) {
            mContext = context;
        }

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            TextView itemView = (TextView) view;
            String message = new StringBuilder().append("clicked item: ")
                    .append(itemView.getText().toString()).toString();
            Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
        }

    }
}
