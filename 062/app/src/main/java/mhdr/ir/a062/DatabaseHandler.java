package mhdr.ir.a062;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {


    public static class DB{
        private static int DATABASE_VERSION = 1;
        private static String DATABASE_NAME = "062";
    }

    public static class Contact{
        private static String TABLE_NAME="contacts";
        private static String COL1_NAME="name";
        private static String COL2_PHONE="phone";
        private static String COL3_EMAIL="email";
    }

    public DatabaseHandler(Context context) {
        super(context, DB.DATABASE_NAME, null, DB.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
