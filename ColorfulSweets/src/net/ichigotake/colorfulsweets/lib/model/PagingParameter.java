package net.ichigotake.colorfulsweets.lib.model;

/**
 * API level 1
 * 
 * Contains parameters for paging.
 * 
 * TODO document for method.
 */
public class PagingParameter {

	final private int mPerPage;
	
	private int mOffset;
	
	private int mCurrentPage = 1;
	
	public PagingParameter(int perPage) {
		mPerPage = perPage;
	}
	
	public void nextPage() {
		mCurrentPage++;
		mOffset += mPerPage;
	}
	
	public int getPerPage() {
		return mPerPage;
	}
	
	public int getCurrentPage() {
		return mCurrentPage;
	}
	
	public int getLimit() {
		return mPerPage;
	}
	
	public int getOffset() {
		return mOffset;
	}
}
