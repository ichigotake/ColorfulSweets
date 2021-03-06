package net.ichigotake.colorfulsweets.common.widget.paging;

import junit.framework.TestCase;

/**
 * Testing for {@link PagingState}
 */
public class PagingParameterTest extends TestCase {

    final private int mPerPage = 10;

    private PagingState mParameter;

    @Override
    protected void setUp() {
        mParameter = new PagingState(mPerPage);
    }

    public void testForDefaultParameters() {
        assertEquals(mPerPage, mParameter.getPerPage());
        assertEquals(1, mParameter.getCurrentPage());
        assertEquals(0, mParameter.getOffset());
        assertEquals(mPerPage, mParameter.getLimit());
    }

    public void testOncePaging() {
        mParameter.nextPage();

        assertEquals(mPerPage, mParameter.getPerPage());
        assertEquals(2, mParameter.getCurrentPage());
        assertEquals(mPerPage, mParameter.getOffset());
        assertEquals(mPerPage, mParameter.getLimit());
    }

    public void testSeveralPaging() {
        for (int page=2, count=100; page<count; page++) {
            mParameter.nextPage();
            final int offset = (mPerPage*page) - mPerPage;

            assertEquals(mPerPage, mParameter.getPerPage());
            assertEquals(page, mParameter.getCurrentPage());
            assertEquals(offset, mParameter.getOffset());
            assertEquals(mPerPage, mParameter.getLimit());
        }
    }

    public void testReset() {
        mParameter.nextPage();
        assertEquals(mParameter.getCurrentPage(), 2);
        mParameter.reset();

        assertEquals(mPerPage, mParameter.getPerPage());
        assertEquals(1, mParameter.getCurrentPage());
        assertEquals(0, mParameter.getOffset());
        assertEquals(mPerPage, mParameter.getLimit());
    }
}
