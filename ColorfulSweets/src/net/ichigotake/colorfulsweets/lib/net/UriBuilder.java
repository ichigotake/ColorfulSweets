package net.ichigotake.colorfulsweets.lib.net;

import android.net.Uri;

/**
 * API level 1
 * 
 * Helper class for building or manipulation URI reference.
 */
public class UriBuilder {

    final private Uri.Builder mBulder;

    /**
     * API level 1
     * 
     * Constructs a new Builder.
     */
    public UriBuilder() {
        mBulder = new Uri.Builder();
    }

    /**
     * API level 1
     * 
     * Constructs a {@link Uri} with the current attributes.
     * @return
     */
    public Uri build() {
        return mBulder.build();
    }

    /**
     * API level 1
     * 
     * Encodes and sets the authority.
     * 
     * @param authority
     * @return
     */
    public UriBuilder setAuthrity(String authority) {
        mBulder.encodedAuthority(authority);
        return this;
    }

    /**
     * API level 1
     * 
     * Encodes the key and value and then appends the parameter to the query string.
     * 
     * @param key
     * @param value
     * @return
     */
    public UriBuilder appendQueryParameter(String key, String value) {
        mBulder.appendQueryParameter(key, value);
        return this;
    }

    /**
     * API level 1
     * 
     * Encodes the key and value and then appends the parameter to the query string.
     * 
     * @param key
     * @param value
     * @return
     */
    public UriBuilder appendQueryParameter(QueryParameterKey key, String value) {
        mBulder.appendQueryParameter(key.getKey(), value);
        return this;
    }

    /**
     * API level 1
     * 
     * Sets the path.
     * 
     * @param path
     * @return
     */
    public UriBuilder setPath(String path) {
        mBulder.encodedPath(path);
        return this;
    }
    
    /**
     * API level 1
     * 
     * Sets the scheme.
     * 
     * @param scheme
     * @return
     */
    public UriBuilder setScheme(String scheme) {
        mBulder.scheme(scheme);
        return this;
    }

}
