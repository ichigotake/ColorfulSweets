package net.ichigotake.colorfulsweets.lib.model;

/**
 * API level 1
 */
public class LoadingState {

    private boolean mIsLoading;
    private boolean mCompleted;

    public void setIsLoading(boolean loading) {
        mIsLoading = loading;
    }

    public boolean isLoading() {
        return mIsLoading;
    }

    public void complete() {
        mCompleted = true;
    }

    public boolean completed() {
        return mCompleted;
    }

    public void start() {
        mIsLoading = true;
    }

    public void finish() {
        mIsLoading = false;
    }
}
