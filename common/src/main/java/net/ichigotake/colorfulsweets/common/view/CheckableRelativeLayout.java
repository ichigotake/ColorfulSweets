package net.ichigotake.colorfulsweets.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.RelativeLayout;

import net.ichigotake.colorfulsweets.common.R;

/**
 * API level 1
 *
 * Checkable {@link android.widget.RelativeLayout}.
 */
public class CheckableRelativeLayout extends RelativeLayout implements Checkable {

    final private int mDefaultBackgroundResId = R.drawable.colorfulsweets_list_selector_checked;
    private boolean mChecked;

    private static final int[] CHECKED_STATE_SET = {android.R.attr.state_checked};

    @SuppressWarnings("unused")
    public CheckableRelativeLayout(Context context) {
        super(context, null);
        initialize();
    }

    @SuppressWarnings("unused")
    public CheckableRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
        initialize();
    }

    @SuppressWarnings("unused")
    public CheckableRelativeLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initialize();
    }

    private void initialize() {
        if (null == getBackground()) {
            setBackgroundResource(mDefaultBackgroundResId);
        }
    }

    @Override
    public void setChecked(boolean checked) {
        if (mChecked != checked) {
            mChecked = checked;
            refreshDrawableState();
        }
    }

    @Override
    public boolean isChecked() {
        return mChecked;
    }

    @Override
    public void toggle() {
        setChecked(! mChecked);
    }

    @Override
    protected int[] onCreateDrawableState(int extraSpace) {
        final int[] drawableState = super.onCreateDrawableState(extraSpace + CHECKED_STATE_SET.length);
        if (isChecked()) {
            mergeDrawableStates(drawableState, CHECKED_STATE_SET);
        }
        return drawableState;
    }
}
