package net.ichigotake.colorfulsweetssample.view.paging;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import net.ichigotake.colorfulsweets.lib.widget.paging.RunnableAutoPagingContainer;
import net.ichigotake.colorfulsweets.lib.widget.paging.RunnableAutoPagingListener;
import net.ichigotake.colorfulsweetssample.BaseActivity;
import net.ichigotake.colorfulsweetssample.R;

public class AutoPagingActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_menu_list);

        ListView listView = (ListView) findViewById(R.id.menu_list);
        new RunnableAutoPagingContainer<String>()
                .initialize(listView, new AutoPagingDemoListener(this));
    }

    private class AutoPagingDemoListener extends RunnableAutoPagingListener<String> {

        final private Context mContext;
        final private ArrayAdapter<String> mAdapter;

        AutoPagingDemoListener(Context context) {
            mContext = context;
            mAdapter = new ArrayAdapter<String>(mContext, R.layout.menu_item);
        }

        @Override
        protected Runnable onPagingListener() {
            return new Runnable() {
                @Override
                public void run() {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            final int size = getAdapter().getCount();
                            for (int i = 0; i < 20; i++) {
                                getAdapter().add("item " + (size + i));
                            }
                            getAdapter().notifyDataSetChanged();
                            finish();
                        }
                    });
                }
            };
        }

        @Override
        protected int getPerPage() {
            return 20;
        }

        @Override
        protected ArrayAdapter<String> getAdapter() {
            return mAdapter;
        }
    }

}
