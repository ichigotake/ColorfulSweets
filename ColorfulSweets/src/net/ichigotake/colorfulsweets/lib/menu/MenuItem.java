package net.ichigotake.colorfulsweets.lib.menu;

import android.view.View.OnClickListener;

import com.google.common.base.Optional;

/**
 * API level 1
 * 
 * Provide item to {@link MenuList}
 */
public class MenuItem {

	final private int mDefaultIcon;
	
	final private int mDefaultLabelName;
	
	private Optional<String> mLabelName = Optional.absent();
	
	private OnClickListener mListener;
	
	/**
	 * API level 1
	 * 
	 * @param defaultIcon The identifier for resource
	 * @param defaultName The identifier for resource
	 */
	public MenuItem(int defaultIcon, int defaultName) {
		mDefaultIcon = defaultIcon;
		mDefaultLabelName = defaultName;
	}
	
	/**
	 * API level 1
	 * 
	 * Constructs a new instance of {@link MenuItem} containing the elements of the specified menu item.
	 * @param the item of elements to set.
	 */
	public MenuItem(Menu item) {
		mDefaultIcon = item.getIconResource();
		mDefaultLabelName = item.getLabelName();
	}
	
	/**
	 * API level 1
	 * 
	 * Return the default label name to a given resource.
	 * @return The identifier for resource.
	 */
	public int getDefaultLabelName() {
		return mDefaultLabelName;
	}

	/**
	 * API level 1
	 * 
	 * Return the default label icon to a given resource.
	 * @return The identifier for resource.
	 */
	public int getDefaultIcon() {
		return mDefaultIcon;
	}
	
	/**
	 * API level 1
	 * 
	 * Returns if this LabelName contains is not null.
	 * @return true if this {@link MenuItem} has LabelName is not null.
	 */
	public boolean isLabelNamePresent() {
		return mLabelName.isPresent();
	}
	
	/**
	 * API level1
	 * 
	 * Sets the text that this {@link MenuItem} is to display.
	 * @param 
	 */
	public void setLabelName(String name) {
		mLabelName = Optional.of(name);
	}
	
	/**
	 * API level 1
	 * 
	 * Return the text for list item label wrapped {@link Optional} object.
	 * @return 
	 */
	public Optional<String> getLabelName() {
		return mLabelName;
	}
	
	/**
	 * API level 1
	 * 
	 * Return the listener for list item.
	 * @return The listener for {@link OnClickListener}
	 */
	public OnClickListener getOnClickListener() {
		return mListener;
	}
	
	/**
	 * API level 1
	 * 
	 * Sets the listener that this {@link MenuItem} is to set item view.
	 * @param listener
	 */
	public void setOnClickListener(OnClickListener listener) {
		mListener = listener;
	}
	
}
