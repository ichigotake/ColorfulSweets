package net.ichigotake.colorfulsweets.lib.menu;

import android.content.Context;

/**
 * API level 1
 * 
 */
public class SimpleMenuItem {

    final private Context mContext;
    final private int mIcon;
    private String mLabel;

    /**
     * API level 1
     */
    public SimpleMenuItem(Context context, int defaultIcon, int defaultName) {
        mContext = context;
        mIcon = defaultIcon;
        mLabel = context.getString(defaultName);
    }

    /**
     * API level 1
     */
    public SimpleMenuItem(Context context, int defaultIcon, String label) {
        mContext = context;
        mIcon = defaultIcon;
        mLabel = label;
    }

    /**
     * API level 1
     * 
     * Constructs a new instance of {@link SimpleMenuItem} containing the elements of the specified menu item.
     * @param the item of elements to set.
     */
    public SimpleMenuItem(Context context, SimpleMenu item) {
        mContext = context;
        mIcon = item.getIconResource();
        mLabel = context.getString(item.getLabelName());
    }

    /**
     * API level 1
     *
     * Return the default label icon to a given resource.
     * @return The identifier for resource.
     */
    public int getIconResource() {
        return mIcon;
    }

    /**
     * API level1
     *
     */
    public void setLabelName(String name) {
        mLabel = name;
    }

    /**
     * API level 1
     *
     */
    public String getLabelName() {
        return mLabel;
    }

    @Override
    public String toString() {
        return mLabel;
    }
}
