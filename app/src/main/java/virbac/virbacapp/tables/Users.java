package virbac.virbacapp.tables;

/**
 * Created by fali on 15/03/15.
 */

import android.content.ContentResolver;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class Users implements BaseColumns {

    // Records database table
    public static final String TABLE_USER = "user";


    // table records fields
    public static final String EMAIL = "email";
    public static final String MOTDEPASSE = "motdepasse" ;
    public static final String CONTENT_PATH = "User";

    /*                +  " FOREIGN KEY ("+EXPENSEID+") REFERENCES "+ConsommationTable.TABLE_EXPENSE+" ("+ConsommationTable._ID+")"
                    +  " FOREIGN KEY ("+PHOTOID+") REFERENCES "+PhotoTable.TABLE_PHOTO+" ("+ PhotoTable._ID+")"
                    + " FOREIGN KEY ("+REMINDERID+") REFERENCES "+ReminderTable.TABLE_REMINDER+" ("+ReminderTable._ID+"));";
*/

    // info for content provider
    public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE
            + "/vnd.testprovider.cars";
    public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE
            + "/vnd.testprovider.car";
    public static final String[] PROJECTION_ALL = { _ID, EMAIL,MOTDEPASSE};
    // records table creation statement
    private static final String CREATE_CAR_TABLE =
            " CREATE TABLE " + TABLE_USER +
                    " (" + Users._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    " " + Users.EMAIL + " TEXT NOT NULL, " +
                    " " + Users.MOTDEPASSE + " TEXT NOT NULL);";

    /**
     * create records table
     *
     * @param database
     */
    public static void onCreate(SQLiteDatabase database) {
        database.execSQL(CREATE_CAR_TABLE);
    }
    /**
     * upgrade the records table
     *
     * @param database
     * @param oldVersion
     * @param newVersion
     */


    public static void onUpgrade(SQLiteDatabase database, int oldVersion,
                                 int newVersion) {
// TODO
        database.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        onCreate(database);
    }
}
