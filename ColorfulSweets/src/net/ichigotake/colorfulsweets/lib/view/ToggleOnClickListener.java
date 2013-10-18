package net.ichigotake.colorfulsweets.lib.view;

import android.view.View;
import android.view.View.OnClickListener;

/**
 * クリックでビューの表示・非表示を切り替える
 */
public class ToggleOnClickListener implements OnClickListener {

	final private static int sDefaultInvisibleMode = View.GONE;
	
	final private int mInvisibleMode;
	
	private View mTargetView;
	
	public ToggleOnClickListener() {
		this(sDefaultInvisibleMode, null);
	}
	
	public ToggleOnClickListener(View targetView) {
		this(sDefaultInvisibleMode, targetView);
	}
	
	public ToggleOnClickListener(int invisibleMode) {
		this(invisibleMode, null);
	}
	
	public ToggleOnClickListener(int invisibleMode, View targetView) {
		mInvisibleMode = invisibleMode;
		mTargetView = targetView;
	}
	
	@Override
	public void onClick(View view) {
		final View targetView = (null == mTargetView) ? mTargetView : view;
		ToggleView.toggle(targetView, mInvisibleMode);
	}

}
