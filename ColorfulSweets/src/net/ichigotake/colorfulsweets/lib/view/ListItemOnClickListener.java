package net.ichigotake.colorfulsweets.lib.view;

import android.view.View;

/**
 * API level 1
 * 
 * Interface definition for a callback to be invoked when a listed view is clicked.
 */
public interface ListItemOnClickListener {

	/**
	 * API level 1
	 * 
	 * Called when a listed view has been clicked.
	 * @param view
	 * @param position
	 */
	public void onClick(View view, int position);
}
