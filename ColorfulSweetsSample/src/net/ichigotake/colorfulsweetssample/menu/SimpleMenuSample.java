package net.ichigotake.colorfulsweetssample.menu;

import net.ichigotake.colorfulsweets.lib.menu.Menu;
import net.ichigotake.colorfulsweetssample.R;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

/**
 * item list
 */
public enum SimpleMenuSample implements Menu {

	SMAPLE1(R.string.simple_menu_item_sample1),
	SMAPLE2(R.string.simple_menu_item_sample2),
	SMAPLE3(R.string.simple_menu_item_sample3),
	SMAPLE4(R.string.simple_menu_item_sample4),
	SMAPLE5(R.string.simple_menu_item_sample5),
	SMAPLE6(R.string.simple_menu_item_sample6),
	;

	final private int mTitle;
	
	private SimpleMenuSample(int title) {
		mTitle = title;
	}
	
	@Override
	public int getLabelName() {
		return mTitle;
	}

	@Override
	public int getIconResource() {
		return 0; // non icon
	}

	/**
	 * item on click listener
	 */
	public static class SimpleMenuSampleOnClickListener implements OnClickListener {

		final private Context mContext;
		
		public SimpleMenuSampleOnClickListener(Context context) {
			mContext = context;
		}
		@Override
		public void onClick(View view) {
			TextView itemView = (TextView) view;
			String message = new StringBuilder()
				.append("clicked item: ")
				.append(itemView.getText().toString())
				.toString();
			Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
		}
		
	}
}
