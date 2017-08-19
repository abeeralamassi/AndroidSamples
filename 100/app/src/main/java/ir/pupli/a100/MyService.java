package ir.pupli.a100;

import android.app.IntentService;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.widget.Toast;


public class MyService extends IntentService {

    int counter = 0;

    public MyService() {
        super("MyServiceThread");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        counter++;
        Handler handler = new Handler(getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MyService.this, "Service Stared: " + counter, Toast.LENGTH_SHORT).show();
            }
        });

        for (int i = 0; i < 10; i++) {
            try {
                wait(1500);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void onDestroy() {
        Toast.makeText(MyService.this, "Service Stopped", Toast.LENGTH_SHORT).show();
    }
}
