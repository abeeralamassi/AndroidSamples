package ir.mhdr.a097;

import android.app.Application;

import org.greenrobot.greendao.database.Database;


public class App extends Application {

    public static final boolean ENCRYPTED = false;

    @Override
    public void onCreate() {
        super.onCreate();

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, ENCRYPTED ? "notes-db-encrypted" : "notes-db");
        Database db = ENCRYPTED ? helper.getEncryptedWritableDb("super-secret") : helper.getWritableDb();
        Statics.daoSession = new DaoMaster(db).newSession();
    }
}
