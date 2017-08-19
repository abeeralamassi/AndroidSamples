package ir.pupli.a101;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;


public class MyService extends Service {

    Binder mBinder = new LocalService();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }


    public class LocalService extends Binder {

        MyService getService() {
            return MyService.this;
        }

    }

    public String getFirstMessage() {
        return "Message 1";
    }

    public String getSecondMessage() {
        return "Message 2";
    }
}
