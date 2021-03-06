package net.ichigotake.colorfulsweets.common.widget.paging;

/**
 * API level 1
 * 
 * Contains parameters for paging.
 * 
 * TODO document for method.
 */
public class PagingState {

    final private int mPerPage;
    
    private int mOffset;
    
    private int mCurrentPage = 1;
    
    public PagingState(int perPage) {
        mPerPage = perPage;
    }
    
    public void nextPage() {
        mCurrentPage++;
        mOffset += mPerPage;
    }

    public void reset() {
        mCurrentPage = 1;
        mOffset = 0;
    }

    public int getPerPage() {
        return mPerPage;
    }
    
    public int getCurrentPage() {
        return mCurrentPage;
    }
    
    public int getOffset() {
        return mOffset;
    }
}
