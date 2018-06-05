package net.pupli.ipc;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.support.annotation.Nullable;

public class MyService extends Service {

    private final int JOB1 = 1;
    private final int JOB1Response = 2;
    private final int JOB2 = 3;
    private final int JOB2Response = 4;
    Messenger messenger = new Messenger(new MyServiceHandler());

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return messenger.getBinder();
    }


    class MyServiceHandler extends Handler {

        Message MSG;
        String message;
        Bundle bundle = new Bundle();

        @Override
        public void handleMessage(Message msg) {

            try {

                switch (msg.what) {
                    case JOB1:

                        message = "This is the first message from service";
                        MSG = Message.obtain(null, JOB1Response);
                        bundle.putString("responseMessage", message);
                        MSG.setData(bundle);
                        msg.replyTo.send(MSG);

                        break;

                    case JOB2:

                        message = "This is the second message from service";
                        MSG = Message.obtain(null, JOB2Response);
                        bundle.putString("responseMessage", message);
                        MSG.setData(bundle);
                        msg.replyTo.send(MSG);

                        break;

                    default:
                        super.handleMessage(msg);
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }
}
