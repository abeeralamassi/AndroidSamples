package mhdr.ir.a062;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

    public static class Schema_DB {
        private static int DATABASE_VERSION = 5;
        private static String DATABASE_NAME = "062";
    }

    public DatabaseHandler(Context context) {
        super(context, Schema_DB.DATABASE_NAME, null, Schema_DB.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Schema_Contacts.QUERY_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion) {
            db.execSQL(Schema_Contacts.QUERY_DROP_TABLE);
            db.execSQL(Schema_Contacts.QUERY_CREATE_TABLE);
        }
    }


    public static class Schema_Contacts {
        public static final String TABLE_NAME = "contacts";
        public static final String COL1_ID = "_id";
        public static final String COL2_NAME = "name";
        public static final String COL3_PHONE_NUMBER = "phone_number";
        public static final String COL4_EMAIL_ADDRESS = "email_address";
        public static final String QUERY_CREATE_TABLE =String.format("CREATE TABLE \"%s\" (\n" +
                "\"%s\"  INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n" +
                "\"%s\"  TEXT NOT NULL,\n" +
                "\"%s\"  TEXT,\n" +
                "\"%s\"  TEXT\n" +
                ");",TABLE_NAME,COL1_ID,COL2_NAME,COL3_PHONE_NUMBER,COL4_EMAIL_ADDRESS);

        public static final String QUERY_DROP_TABLE =String.format("DROP TABLE IF EXISTS \"%s\";",TABLE_NAME);
    }
}
