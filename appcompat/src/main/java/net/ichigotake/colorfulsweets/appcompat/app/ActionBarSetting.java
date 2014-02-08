package net.ichigotake.colorfulsweets.appcompat.app;

import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;

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
    public ActionBarSetting(ActionBar actionBar) {
        mActionBar = actionBar;
    }

    public ActionBarSetting(ActionBarActivity activity) {
        this(activity.getSupportActionBar());
    }

    /**
     * API level 7
     *
     * Create {link {@link ActionBarSetting}} instance from {@link android.content.Context} contains {@link ActionBarActivity}.
     * @param context
     * @return
     */
    public static ActionBarSetting from(Context context) {
        if (context instanceof ActionBarActivity) {
            ActionBar actionBar = ((ActionBarActivity) context).getSupportActionBar();
            return new ActionBarSetting(actionBar);
        } else {
            throw new IllegalStateException("Context not instanceof ActionBarActivity");
        }
    }

    /**
     * API level 7
     *
     * Show the ActionBar if it is not currently showing.
     * @param actionBar
     * @param title
     */
    public static void show(ActionBar actionBar, int title) {
        ActionBarSetting setting = new ActionBarSetting(actionBar);
        setting.setTitle(title);
        setting.show();
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
    public static void setTilte(ActionBar actionBar, int title) {
        ActionBarSetting setting = new ActionBarSetting(actionBar);
        setting.setTitle(title);
    }

    /**
     * API level 7
     *
     * Set the action bar's title. This will only be displayed if {@link ActionBarSetting#show()} called.
     * @param title
     */
    public static void setTilte(ActionBar actionBar, String title) {
        ActionBarSetting setting = new ActionBarSetting(actionBar);
        setting.setTitle(title);
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
