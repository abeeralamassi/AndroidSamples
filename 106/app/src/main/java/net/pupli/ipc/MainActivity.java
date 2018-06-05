package net.pupli.ipc;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private final int JOB1 = 1;
    private final int JOB1Response = 2;
    private final int JOB2 = 3;
    private final int JOB2Response = 4;
    Messenger messenger = null;
    boolean isBound = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, MyService.class);
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }


    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            messenger = new Messenger(service);
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            messenger = null;
            isBound = false;
        }
    };

    // JOB1
    private void sendMessage1() {
        try {
            Message msg = Message.obtain(null, JOB1);
            msg.replyTo = new Messenger(new MainActivityHandler());
            messenger.send(msg);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    // JOB2
    private void sendMessage2() {
        try {
            Message msg = Message.obtain(null, JOB2);
            msg.replyTo = new Messenger(new MainActivityHandler());
            messenger.send(msg);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void LogMessage1(String msg)
    {
        Log.d("MSG",msg);
    }

    @Override
    protected void onStop() {

        unbindService(serviceConnection);
        isBound = false;
        messenger = null;

        super.onStop();
    }

    class MainActivityHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {

            String message;

            switch (msg.what) {
                case JOB1Response:
                    message = msg.getData().getString("responseMessage");

                    // do something here

                    LogMessage1(message);

                    break;
                case JOB2Response:
                    message = msg.getData().getString("responseMessage");

                    // do something here
                    break;
                default:
                    super.handleMessage(msg);
            }


        }
    }
}
