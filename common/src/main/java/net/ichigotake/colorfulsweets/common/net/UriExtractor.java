package net.ichigotake.colorfulsweets.common.net;

import android.net.Uri;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * API level 1
 *
 * Extract url from text.
 */
public class UriExtractor {

    /**
     * API level 1
     *
     * Extract url list from text.
     *
     * @param text the maybe including url text.
     * @return list of url
     */
    public List<Uri> extract(String text) {
        List<Uri> list = new ArrayList<Uri>();

        String regex = "\\(?\\b(https?://|www[.])[-A-Za-z0-9+&@#/%?=~_()|!:,.;]*[-A-Za-z0-9+&@#/%=~_()|]";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(text);
        while (m.find()) {
            String url = m.group();
            if (url.startsWith("(") && url.endsWith(")")) {
                url = url.substring(1, url.length() - 1);
            }
            list.add(Uri.parse(url));
        }
        return list;
    }
}
