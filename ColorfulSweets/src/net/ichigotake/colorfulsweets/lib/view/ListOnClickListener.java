package net.ichigotake.colorfulsweets.lib.view;

import android.view.View;
import android.view.View.OnClickListener;

import com.google.common.base.Optional;

/**
 * API level 1
 * 
 * Callback on click event on a item in list.
 */
public class ListOnClickListener implements OnClickListener {

    final private int mPosition;
    
    final private Optional<ListItemOnClickListener> mListener;
    
    /**
     * API level 1
     * 
     * Constructor
     * @param listener
     * @param position
     */
    public ListOnClickListener(int position, ListItemOnClickListener listener) {
        mListener = Optional.fromNullable(listener);
        mPosition = position;
    }
    
    /**
     * API level 1
     * 
     * Calling {@link ListItemOnClickListener#onClick(View, int)} from listed view.
     * @param view the on clicked view own.
     */
    @Override
    public void onClick(View view) {
        if (mListener.isPresent()) {
            mListener.get().onClick(view, mPosition);
        }
    }

}
