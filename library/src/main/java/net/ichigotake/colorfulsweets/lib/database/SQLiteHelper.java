package net.ichigotake.colorfulsweets.lib.database;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.SparseArray;

import com.google.common.base.Optional;

/**
 * API level 1
 * 
 * The decorator of {@link android.database.sqlite.SQLiteOpenHelper}.
 *
 * TODO document for method.
 * @param <T>
 */
public abstract class SQLiteHelper<T> extends SQLiteOpenHelper {

    final private SparseArray<T> mCaches = new SparseArray<T>();
    
    protected abstract String getTableName();
    
    public SQLiteHelper(Context context, DatabaseStorage database) {
        this(context, database.getName(), database.getVersion());
    }
    
    public SQLiteHelper(Context context, String name, int version) {
        super(context, name, null, version);
    }

    protected void putCache(int key, T data) {
        mCaches.put(key, data);
    }
    
    protected Optional<T> getCache(int key) {
        return Optional.fromNullable(mCaches.get(key));
    }

    protected SQLiteMakerSelect newSelect() {
        return new SQLiteMakerSelect(getReadableDatabase(), getTableName());
    }

}
