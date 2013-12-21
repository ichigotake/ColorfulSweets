package net.ichigotake.colorfulsweets.lib.menu;

import android.view.View.OnClickListener;

import com.google.common.base.Optional;

import net.ichigotake.colorfulsweets.lib.view.ListItemOnClickListener;

/**
 * API level 1
 * 
 * A modifiable sequence of elements for use in creating objects.
 */
public class SimpleMenuItemBuilder {

    private int mDefaultIcon;

    private int mDefaultLabelName;
    
    private Optional<String> mLabelName = Optional.absent();
    
    private ListItemOnClickListener mListener;
    
    /**
     * API level 1
     * 
     * Returns the contents of builder
     * @return the object representation of the data in this builder.
     */
    public SimpleMenuItem create() {
        final SimpleMenuItem item = new SimpleMenuItem(mDefaultIcon, mDefaultLabelName);
        if (mLabelName.isPresent()) {
            item.setLabelName(mLabelName.get());
        }
        item.setOnClickListener(mListener);
        return item;
    }
    
    /**
     * API level 1
     * 
     * Sets the default icon to a given resource.
     * @param icon the identifier for resource.
     * @return this builder.
     */
    public SimpleMenuItemBuilder setDefaultIcon(int icon) {
        mDefaultIcon = icon;
        return this;
    }
    
    /**
     * API level 1
     * 
     * Sets the default label name to a given resource.
     * @param name the identifier for resource.
     * @return this builder.
     */
    public SimpleMenuItemBuilder setDefaultLabelName(int name) {
        mDefaultLabelName = name;
        return this;
    }
    
    /**
     * API level 1
     * 
     * Sets the label name to given string.
     * @param name the identifier for string
     * @return this builder
     */
    public SimpleMenuItemBuilder setLabelName(String name) {
        mLabelName = Optional.of(name);
        return this;
    }
    
    /**
     * API level 1
     * 
     * Sets the listener to given {@link OnClickListener} .
     * @param listener
     * @return this builder
     */
    public SimpleMenuItemBuilder setOnClickListener(ListItemOnClickListener listener) {
        mListener = listener;
        return this;
    }
}
