package net.ichigotake.colorfulsweets.lib.ui;

/**
 * API level 1
 */
public class LoadingState {

    private boolean mIsLoading;

    public void setIsLoading(boolean loading) {
        mIsLoading = loading;
    }

    public boolean isLoading() {
        return mIsLoading;
    }

    public void complete() {
        mIsLoading = false;
    }

    public void start() {
        mIsLoading = true;
    }
}
