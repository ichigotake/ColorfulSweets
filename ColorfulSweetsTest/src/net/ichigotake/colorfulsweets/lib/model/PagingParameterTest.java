package net.ichigotake.colorfulsweets.lib.model;

import junit.framework.TestCase;

/**
 * Testing for {@link PagingParameter}
 */
public class PagingParameterTest extends TestCase {

    final private int mPerPage = 10;

    private PagingParameter mParameter;

    @Override
    protected void setUp() {
        mParameter = new PagingParameter(mPerPage);
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
}
