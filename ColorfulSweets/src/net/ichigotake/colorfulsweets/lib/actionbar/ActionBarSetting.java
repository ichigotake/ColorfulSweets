package net.ichigotake.colorfulsweets.lib.actionbar;

import android.support.v7.app.ActionBar;

/**
 * API level 7
 * 
 * Setting utility for action bar.
 */
public class ActionBarSetting {

	final private ActionBar mActionBar;
	
	/**
	 * API level 7
	 * 
	 * Constructor
	 * @param actionBar
	 */
	private ActionBarSetting(ActionBar actionBar) {
		mActionBar = actionBar;
	}
	
	/**
	 * API level 7
	 * 
	 * 
	 * @param actionBar
	 * @param title
	 */
	public static void withHomeUpAsEnabled(ActionBar actionBar, int title) {
		ActionBarSetting setting = new ActionBarSetting(actionBar);
		setting.setHomeAuUpEnabled(true);
		setting.show();
	}
	
	/**
	 * API level 7
	 * 
	 * Set the action bar's title. This will only be displayed if {@link ActionBarSetting#show()} called.
	 * @param title
	 */
	public void setTitle(int title) {
		mActionBar.setTitle(title);
	}
	
	/**
	 * API level 7
	 * 
	 * Set the action bar's title. This will only be displayed if {@link ActionBarSetting#show()} called.
	 * @param title
	 */
	public void setTitle(String title) {
		mActionBar.setTitle(title);
	}
	
	/**
	 * API level 7
	 * 
	 * Set whether home should be displayed as an "up" affordance.
	 * @param flag
	 */
	public void setHomeAuUpEnabled(boolean flag) {
		mActionBar.setDisplayShowHomeEnabled(flag);
		mActionBar.setDisplayHomeAsUpEnabled(flag);
	}
	
	/**
	 * API level 7
	 * 
	 * Show the ActionBar if it is not currently showing. 
	 */
	public void show() {
		mActionBar.show();
	}
	
	/**
	 * API level 7
	 * 
	 * Hide the ActionBar if it is currently showing.
	 */
	public void hide() {
		mActionBar.hide();
	}
}
