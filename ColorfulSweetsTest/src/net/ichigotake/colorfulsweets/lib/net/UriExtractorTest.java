package net.ichigotake.colorfulsweets.lib.net;

import android.net.Uri;

import junit.framework.TestCase;

/**
 * Testing for {@link UriExtractor}
 */
public class UriExtractorTest extends TestCase {

    final private String mUrlString = "http://hachiojiom.org/";
    final private Uri mUri = Uri.parse(mUrlString);
    private UriExtractor mExtractor;

    @Override
    protected void setUp() {
        mExtractor = new UriExtractor();
    }

    public void testSimple() {
        Uri extractUri = mExtractor.extract(mUrlString).get(0);
        assertEquals(mUri, extractUri);
        assertEquals(mUrlString, extractUri.toString());
    }

    public void testExtractFromText() {
        final String text = "Hi, " + mUrlString + " is Hachioji.pm's official site!";
        final Uri extractUri = mExtractor.extract(text).get(0);
        assertEquals(mUri, extractUri);
        assertEquals(mUrlString, extractUri.toString());
    }

    public void testExtractFromTextWithWrappedParenthesisUrl() {
        final String text = "Hi, this is Hachioji.pm! (" + mUrlString + ")";
        final Uri extractUri = mExtractor.extract(text).get(0);
        assertEquals(mUri, extractUri);
        assertEquals(mUrlString, extractUri.toString());
    }

}
