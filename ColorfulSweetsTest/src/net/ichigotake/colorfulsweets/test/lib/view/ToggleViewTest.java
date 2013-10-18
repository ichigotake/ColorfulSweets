package net.ichigotake.colorfulsweets.test.lib.view;

import net.ichigotake.colorfulsweets.lib.view.ToggleView;
import android.test.AndroidTestCase;
import android.view.View;
import android.widget.TextView;

public class ToggleViewTest extends AndroidTestCase {

	public void testToggleToVisible() {
		View targetView = getView();
		targetView.setVisibility(View.GONE);
		
		ToggleView.toggle(targetView);
		
		assertEquals(View.VISIBLE, targetView.getVisibility());
	}
	
	public void testToggleToGone() {
		View targetView = getView();
		targetView.setVisibility(View.VISIBLE);
		
		ToggleView.toggle(targetView, View.GONE);
		
		assertEquals(View.GONE, targetView.getVisibility());
	}
	
	public void testToggleToInvisible() {
		View targetView = getView();
		targetView.setVisibility(View.VISIBLE);
		
		ToggleView.toggle(targetView, View.INVISIBLE);
		
		assertEquals(View.INVISIBLE, targetView.getVisibility());
	}
	
	private View getView() {
		return new TextView(getContext());
	}
}
