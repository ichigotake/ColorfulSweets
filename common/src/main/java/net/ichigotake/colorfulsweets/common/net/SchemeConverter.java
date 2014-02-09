package net.ichigotake.colorfulsweets.common.net;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

import java.io.File;

/**
 * API level 1
 *
 * Uri scheme content converter.
 */
public class SchemeConverter {

    final private Context mContext;

    public SchemeConverter(Context context) {
        mContext = context;
    }

    public File toFile(Uri contentUri) {
        final File file;

        if (contentUri != null && "content".equals(contentUri.getScheme())) {
            file = resolve(contentUri);
        } else {
            file = new File(contentUri.getPath());
        }

        return file;

    }

    private File resolve(Uri uri) {
        final String path;

        Cursor cursor = mContext.getContentResolver().query(uri, new String[] { android.provider
                .MediaStore.Images.ImageColumns.DATA }, null, null, null);
        cursor.moveToFirst();
        path = cursor.getString(0);
        cursor.close();

        return new File(path);
    }
}
