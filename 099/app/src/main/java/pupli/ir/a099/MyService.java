package pupli.ir.a099;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.widget.Toast;


public class MyService extends Service {

    Thread workerThread = null;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MyService.this, "Service Started", Toast.LENGTH_SHORT).show();

                for (int i = 0; i < 10; i++) {
                    try {
                        wait(1500);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        if (workerThread != null) {
            workerThread = new Thread(runnable);
            workerThread.start();
        }

        return Service.START_STICKY;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();

        if (workerThread != null) {
            workerThread.interrupt();
            workerThread = null;
            Toast.makeText(MyService.this, "Service Stopped", Toast.LENGTH_SHORT).show();
        }

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
