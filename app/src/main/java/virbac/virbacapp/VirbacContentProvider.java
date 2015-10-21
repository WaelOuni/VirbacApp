package virbac.virbacapp;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;

import java.util.Arrays;
import java.util.HashSet;

import virbac.virbacapp.tables.Users;

/**
 * Created by imen on 21/03/15.
 */
public class VirbacContentProvider extends android.content.ContentProvider {


    private static final String AUTHORITY = "virbac.virbacapp.provider";
    public static final Uri USER_CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + Users.CONTENT_PATH);

    private static final int USER = 100;
    private static final int USER_ID = 101;

    private static final UriMatcher PROVIDER_URI_MATCHER;

    static {
        PROVIDER_URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);

        PROVIDER_URI_MATCHER.addURI(AUTHORITY, Users.CONTENT_PATH, USER);
        PROVIDER_URI_MATCHER.addURI(AUTHORITY, Users.CONTENT_PATH + "/#", USER_ID);


    }

    // database
    private DatabaseHelper mOpenHelper;

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        SQLiteDatabase sqlDB = mOpenHelper.getWritableDatabase();
        int rowsDeleted = 0;
        String id;
        switch (PROVIDER_URI_MATCHER.match(uri)) {
            case USER:
                rowsDeleted = sqlDB.delete(Users.TABLE_USER, selection, selectionArgs);
                break;
            case USER_ID:
                id = uri.getLastPathSegment();
                if (TextUtils.isEmpty(selection)) {
                    rowsDeleted = sqlDB.delete(Users.TABLE_USER, Users._ID + "=" + id, null);
                } else {
                    rowsDeleted = sqlDB.delete(Users.TABLE_USER,
                            Users._ID + "=" + id + " and " + selection, selectionArgs);
                }
                break;


            default:
                throw new IllegalArgumentException("Unsupported URI: " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return rowsDeleted;
    }

    @Override
    public String getType(Uri uri) {
        switch (PROVIDER_URI_MATCHER.match(uri)) {
            case USER:
                return Users.CONTENT_TYPE;
            case USER_ID:
                return Users.CONTENT_ITEM_TYPE;


            default:
                throw new IllegalArgumentException("Unsupported URI: " + uri);
        }
    }


    @Override
    public Uri insert(Uri uri, ContentValues values) {
        SQLiteDatabase database = mOpenHelper.getWritableDatabase();
        Uri itemUri = null;

        long id = 0;


        switch (PROVIDER_URI_MATCHER.match(uri)) {
            case USER:

                id = database.insert(Users.TABLE_USER, null, values);
                if (id > 0) {
                    // notify all listeners of changes and return itemUri:
                    itemUri = ContentUris.withAppendedId(uri, id);
                } else {
                    // something went wrong:
                    throw new SQLException("Problem while inserting into "
                            + Users.TABLE_USER + ", uri: " + uri);
                }
                break;


            default:
                throw new IllegalArgumentException("Unsupported URI: " + uri);
        }

        getContext().getContentResolver().notifyChange(itemUri, null);

        return itemUri;
    }


    @Override
    public boolean onCreate() {
        mOpenHelper = new DatabaseHelper(getContext());
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        // Using SQLiteQueryBuilder instead of query() method
        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();

        switch (PROVIDER_URI_MATCHER.match(uri)) {
            case USER:
                // Check if the caller has requested a column which does not
                // exists
                checkCarTableColumns(projection);
                // Set the table
                queryBuilder.setTables(Users.TABLE_USER);
                break;
            case USER_ID:
                // Check if the caller has requested a column which does not
                // exists
                checkCarTableColumns(projection);
                // Set the table
                queryBuilder.setTables(Users.TABLE_USER);
                // Adding the ID to the original query
                queryBuilder.appendWhere(Users._ID + "="
                        + uri.getLastPathSegment());
                break;

            default:
                throw new IllegalArgumentException("Unsupported URI: " + uri);
        }

        SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        Cursor cursor = queryBuilder.query(db, projection, selection,
                selectionArgs, null, null, sortOrder);
        // Make sure that potential listeners are getting notified
        cursor.setNotificationUri(getContext().getContentResolver(), uri);

        return cursor;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        SQLiteDatabase database = mOpenHelper.getWritableDatabase();
        int rowsUpdated = 0;
        String id;
        switch (PROVIDER_URI_MATCHER.match(uri)) {
            case USER:

                id = uri.getLastPathSegment();
                if (TextUtils.isEmpty(selection)) {
                    rowsUpdated = database.update(Users.TABLE_USER,
                            values, null, null);
                } else {
                    rowsUpdated = database.update(Users.TABLE_USER,
                            values, selection, selectionArgs);
                }
                break;


            default:
                throw new IllegalArgumentException("Unsupported URI: " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return rowsUpdated;
    }

    private void checkCarTableColumns(String[] projection) {

        if (projection != null) {
            HashSet<String> requestedColumns = new HashSet<String>(
                    Arrays.asList(projection));
            HashSet<String> availableColumns = new HashSet<String>(
                    Arrays.asList(Users.PROJECTION_ALL));
            // Check if all columns which are requested are available
            if (!availableColumns.containsAll(requestedColumns)) {
                throw new IllegalArgumentException(
                        "Unknown columns in projection");
            }
        }
    }


}
