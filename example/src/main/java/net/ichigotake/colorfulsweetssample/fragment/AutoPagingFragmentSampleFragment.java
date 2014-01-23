package net.ichigotake.colorfulsweetssample.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

import net.ichigotake.colorfulsweets.lib.fragment.AutoPagingFragment;
import net.ichigotake.colorfulsweetssample.R;

import java.util.ArrayList;

/**
 * Sample for {@link AutoPagingFragment}
 */
public class AutoPagingFragmentSampleFragment extends AutoPagingFragment {

    public static AutoPagingFragmentSampleFragment newInstance() {
        return new AutoPagingFragmentSampleFragment();
    }

    @Override
    protected void onPaging() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        int size = getAdapter().getCount();
                        for (int i=0, count=getPerPage(); i<count; i++) {
                            ((ArrayAdapter<String>)getAdapter()).add("item " + (size+i));
                        }
                        finish();
                    }
                });
            }
        }, 2000);
    }

    @Override
    protected View createView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_auto_paging, null);
    }

    @Override
    protected ListView getListView(View view) {
        return (ListView) view.findViewById(R.id.listView);
    }

    @Override
    protected BaseAdapter createAdapter() {
        return new ArrayAdapter<String>(
                getActivity(), android.R.layout.simple_list_item_1, new ArrayList<String>());
    }

    @Override
    protected int getPerPage() {
        return 50;
    }
}
