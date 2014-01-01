package net.ichigotake.colorfulsweetssample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SimplePagerPageFragment extends Fragment {

    final private static String KEY_POSITION = "key_position";
    
    final private static int DEFAULT_POSITION = 1;
    
    public static SimplePagerPageFragment newInstance(int position) {
        Bundle args = new Bundle(1);
        args.putInt(KEY_POSITION, position);
        
        SimplePagerPageFragment fragment = new SimplePagerPageFragment();
        fragment.setArguments(args);
        return fragment;
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceStace) {
        View view = inflater.inflate(R.layout.simple_pager_page, null);
        
        final int currentPosition;
        Bundle args = getArguments();
        if (args != null && args.containsKey(KEY_POSITION)) {
            currentPosition = args.getInt(KEY_POSITION);
        } else {
            currentPosition = DEFAULT_POSITION;
        }
        
        TextView headTitle = (TextView) view.findViewById(R.id.head_title);
        headTitle.setText("page no: " + currentPosition);
        
        return view;
    }
}
