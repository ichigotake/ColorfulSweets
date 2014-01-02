package net.ichigotake.colorfulsweets.lib.menu;

import com.google.common.base.Optional;

import net.ichigotake.colorfulsweets.lib.view.ListItemOnClickListener;

/**
 * API level 1
 * 
 * Provide item to {@link SimpleMenuList}
 */
public class SimpleMenuItem {

    final private int mDefaultIcon;
    
    final private int mDefaultLabelName;
    
    private Optional<String> mLabelName = Optional.absent();
    
    private ListItemOnClickListener mListener;
    
    /**
     * API level 1
     * 
     * @param defaultIcon The identifier for resource
     * @param defaultName The identifier for resource
     */
    public SimpleMenuItem(int defaultIcon, int defaultName) {
        mDefaultIcon = defaultIcon;
        mDefaultLabelName = defaultName;
    }
    
    /**
     * API level 1
     * 
     * Constructs a new instance of {@link SimpleMenuItem} containing the elements of the specified menu item.
     * @param the item of elements to set.
     */
    public SimpleMenuItem(SimpleMenu item) {
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
     * @return true if this {@link SimpleMenuItem} has LabelName is not null.
     */
    public boolean isLabelNamePresent() {
        return mLabelName.isPresent();
    }

    /**
     * API level1
     *
     * Sets the text that this {@link SimpleMenuItem} is to display.
     * @param
     */
    public void setLabelName(String name) {
        mLabelName = Optional.of(name);
    }

    /**
     * API level 1
     *
     * Return the text for list item label wrapped {@link com.google.common.base.Optional} object.
     * @return
     */
    public Optional<String> getLabelName() {
        return mLabelName;
    }

    /**
     * API level 1
     *
     * Return the listener for list item.
     * @return The listener for {@link android.view.View.OnClickListener}
     */
    public ListItemOnClickListener getOnClickListener() {
        return mListener;
    }

    /**
     * API level 1
     *
     * Sets the listener that this {@link SimpleMenuItem} is to set item view.
     * @param listener
     */
    public void setOnClickListener(ListItemOnClickListener listener) {
        mListener = listener;
    }

    @Override
    public String toString() {
        return mLabelName.or("");
    }
}
