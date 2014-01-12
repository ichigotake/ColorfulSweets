package net.ichigotake.colorfulsweets.lib.menu;

import android.content.Context;

/**
 * API level 1
 * 
 * A modifiable sequence of elements for use in creating objects.
 */
public class SimpleMenuItemBuilder {

    final private Context mContext;
    private int mIconResource;
    private String mLabel;

    public SimpleMenuItemBuilder(Context context) {
        mContext = context;
    }
    /**
     * API level 1
     * 
     * Returns the contents of builder
     * @return the object representation of the data in this builder.
     */
    public SimpleMenuItem build() {
        return new SimpleMenuItem(mContext, mIconResource, mLabel);
    }

    /**
     * API level 1
     *
     */
    public SimpleMenuItemBuilder setIcon(int iconResource) {
        mIconResource = iconResource;
        return this;
    }

    /**
     * API level 1
     *
     */
    public SimpleMenuItemBuilder setLabel(int labelResource) {
        mLabel = mContext.getString(labelResource);
        return this;
    }

    /**
     * API level 1
     *
     */
    public SimpleMenuItemBuilder setLabel(String label) {
        mLabel = label;
        return this;
    }
}
