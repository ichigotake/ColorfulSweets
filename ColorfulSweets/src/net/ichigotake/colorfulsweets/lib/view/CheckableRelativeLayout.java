package net.ichigotake.colorfulsweets.lib.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.RelativeLayout;

/**
 * API level 1
 *
 * Checkable {@link android.widget.RelativeLayout}.
 */
public class CheckableRelativeLayout extends RelativeLayout implements Checkable {

    private boolean mChecked;

    private static final int[] CHECKED_STATE_SET = {android.R.attr.state_checked};

    @SuppressWarnings("unused")
    public CheckableRelativeLayout(Context context) {
        super(context, null);
    }

    @SuppressWarnings("unused")
    public CheckableRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

    @SuppressWarnings("unused")
    public CheckableRelativeLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
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
