package com.crystalgems.gemhunt.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public abstract class DatabaseContentProvider {
    public SQLiteDatabase database;

    public DatabaseContentProvider(SQLiteDatabase database) {
        this.database = database;
    }

    /**
     * Convenience method for deleting rows in the database.
     * @param tableName  the table to delete from
     * @param selection  the optional WHERE clause to apply when deleting. Passing null will delete all rows.
     * @param selectionArgs ou may include ?s in the where clause, which will be replaced by the values from whereArgs. The values will be bound as Strings.
     * @return the number of rows affected if a whereClause is passed in, 0 otherwise. To remove all rows and get a count pass "1" as the whereClause.
     */
    public int delete(String tableName, String selection, String[] selectionArgs) {
        return database.delete(tableName, selection, selectionArgs);
    }

    /**
     * Convenience method for inserting a row into the database.
     * @param tableName the table to insert the row into
     * @param values  this map contains the initial column values for the row. The keys should be the column names and the values the column values
     * @return the row ID of the newly inserted row, or -1 if an error occurred.
     */
    public long insert(String tableName, ContentValues values) {
        return database.insert(tableName, null, values);
    }

    /**
     * Convenience method for updating rows in the database.
     * @param tableName  the table to update in
     * @param values a map from column names to new column values. null is a valid value that will be translated to NULL.
     * @param selection the optional WHERE clause to apply when updating. Passing null will update all rows.
     * @param selectionArgs You may include ?s in the where clause, which will be replaced by the values from whereArgs. The values will be bound as Strings.
     * @return the number of rows affected.
     */
    public int update(String tableName, ContentValues values,
                      String selection, String[] selectionArgs) {
        return database.update(tableName, values, selection,
                selectionArgs);
    }

    /**
     * Query the given URL, returning a Cursor over the result set.
     * @param tableName The table name to compile the query against.
     * @param columns A list of which columns to return. Passing null will return all columns, which is discouraged to prevent reading data from storage that isn't going to be used.
     * @param selection A filter declaring which rows to return, formatted as an SQL WHERE clause (excluding the WHERE itself). Passing null will return all rows for the given table.
     * @param selectionArgs  You may include ?s in selection, which will be replaced by the values from selectionArgs, in order that they appear in the selection. The values will be bound as Strings.
     * @param sortOrder How to order the rows, formatted as an SQL ORDER BY clause (excluding the ORDER BY itself). Passing null will use the default sort order, which may be unordered.
     * @return A Cursor object, which is positioned before the first entry. Note that Cursors are not synchronized, see the documentation for more details.
     */
    public Cursor query(String tableName, String[] columns,
                        String selection, String[] selectionArgs, String sortOrder) {

        final Cursor cursor = database.query(tableName, columns,
                selection, selectionArgs, null, null, sortOrder);

        return cursor;
    }

    /**
     * Runs the provided SQL and returns a Cursor over the result set.
     * @param sql the SQL query. The SQL string must not be ; terminated
     * @param selectionArgs  You may include ?s in where clause in the query, which will be replaced by the values from selectionArgs. The values will be bound as Strings.
     * @return A Cursor object, which is positioned before the first entry. Note that Cursors are not synchronized, see the documentation for more details.
     */
    public Cursor rawQuery(String sql, String[] selectionArgs) {
        return database.rawQuery(sql, selectionArgs);
    }

    protected abstract <T> T cursorToEntity(Cursor cursor);
}
