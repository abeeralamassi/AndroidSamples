package ir.pupli.a101;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MyService myService = null;

    Button buttonMessage1;
    Button buttonMessage2;
    TextView textViewOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(MainActivity.this, MyService.class);
        bindService(intent, serviceConnection, BIND_AUTO_CREATE);

        buttonMessage1 = (Button) findViewById(R.id.buttonMessage1);
        buttonMessage2 = (Button) findViewById(R.id.buttonMessage2);
        textViewOutput = (TextView) findViewById(R.id.textViewOutput);

        buttonMessage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (myService != null) {
                    textViewOutput.setText(myService.getFirstMessage());
                }
            }
        });

        buttonMessage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (myService != null) {
                    textViewOutput.setText(myService.getSecondMessage());
                }
            }
        });
    }

    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MyService.LocalService localService = (MyService.LocalService) iBinder;
            myService = localService.getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            myService = null;
        }
    };

    @Override
    protected void onStop() {
        super.onStop();

        unbindService(serviceConnection);
        myService = null;
    }
}
