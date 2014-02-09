package net.ichigotake.colorfulsweets.common.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * API level 1
 *
 * SQLite query builder.
 */
public class SQLiteMakerSelect {

    final private SQLiteDatabase mDatabase;
    
    final private String mTableName;
    
    final private List<String> mSelects = new ArrayList<String>();
    
    final private List<String> mWheres = new ArrayList<String>();
    
    private int mLimit;
    
    private int mOffset;
    private String orderBy;

    /**
     * API level 1
     * 
     * Constructs from {@link android.database.sqlite.SQLiteDatabase}.
     * 
     * @param db
     * @param tableName
     */
    public SQLiteMakerSelect(SQLiteDatabase db, String tableName) {
        mDatabase = db;
        mTableName = tableName;
    }
    
    /**
     * API level 1
     * 
     * Execute query with current state.
     * 
     * @return
     */
    public CursorSimple execute() {
        return new CursorSimple(executeQuery());
    }

    public Cursor executeQuery() {
        return mDatabase.query(
                mTableName,
                buildSelect(),
                buildWhere(),
                null,
                null,
                null,
                orderBy,
                buildLimit());
    }
    
    public SQLiteMakerSelect addSelect(String field) {
        mSelects.add(field);
        return this;
    }
    
    /**
     * API level 1
     * 
     * Set limit for "LIMIT" operand.
     * 
     * @param limit
     * @return
     */
    public SQLiteMakerSelect setLimit(int limit) {
        mLimit = limit;
        return this;
    }
    
    /**
     * API level 1
     * 
     * Set offset for "LIMIT" operand.
     * 
     * @param offset
     * @return
     */
    public SQLiteMakerSelect setOffset(int offset) {
        mOffset = offset;
        return this;
    }

    public SQLiteMakerSelect setOrder(String field, Order order) {
        this.orderBy = field + " " + order.name();
        return this;
    }

    /**
     * API level 1
     * 
     * Add "WHERE" query.
     * 
     * TODO support for "OR" operand.
     * @param field
     * @param condition e.g. ">", "<=", "=="
     * @param value
     * @return
     */
    public SQLiteMakerSelect addWhere(String field, String condition, String value) {
        mWheres.add(field + " " + condition + " \"" + value + "\"");
        return this;
    }
    
    /**
     * API level 1
     * 
     * Add "WHERE" query.
     * 
     * TODO support for "OR" operand.
     * @param field
     * @param condition e.g. ">", "<=", "=="
     * @param value
     * @return
     */
    public SQLiteMakerSelect addWhere(String field, String condition, int value) {
        mWheres.add(field + " " + condition + " " + value);
        return this;
    }
    
    private String[] buildSelect() {
        int length = mSelects.size();
        String[] selects = new String[length];
        
        if (mSelects.isEmpty()) {
            selects = null;
        } else {
            for (int i=0; i<length; i++) {
                selects[i] = mSelects.get(i);
            }
        }
        return selects;
    }
    
    private String buildWhere() {
        final String where;
        if (mWheres.isEmpty()) {
            where = null;
        } else {
            where = "(" + TextUtils.join(") AND (", mWheres) + ")";
        }
        return where;
    }
    
    private String buildLimit() {
        final String limit;
        if (mLimit > 0 && mOffset > 0) {
            limit = mOffset + ", " + mLimit;
        } else if (mLimit > 0) {
            limit = String.valueOf(mLimit);
        } else {
            limit = null;
        }
        return limit;
    }

}
