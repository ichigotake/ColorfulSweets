package net.ichigotake.colorfulsweets.common.view;

import android.view.View;

/**
 * API Level 1
 * Toggle view visible state.
 */
public class ToggleView {

    /**
     * API Level 1
     * Toggle view visible state.
     * @param targetView
     */
    public static void toggle(View targetView) {
        toggle(targetView, View.GONE);
    }
    
    /**
     * API Level 1
     * Toggle view visible state.
     * @param targetView
     * @param invisibleMode View.GONE or View.INVISIBLE
     */
    public static void toggle(View targetView, int invisibleMode) {
        switch (targetView.getVisibility()) {
        case View.VISIBLE:
            targetView.setVisibility(invisibleMode);
            break;
        case View.GONE:
        case View.INVISIBLE:
            targetView.setVisibility(View.VISIBLE);
            break;
        }
    }
}
