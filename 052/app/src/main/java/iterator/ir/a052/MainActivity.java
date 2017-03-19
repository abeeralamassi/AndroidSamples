package iterator.ir.a052;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonProgress= (Button) findViewById(R.id.buttonProgress);

        buttonProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("Progress ...");
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.setMax(100);
                progressDialog.setProgress(0);
                progressDialog.show();

                final Thread thread=new Thread(new Runnable() {
                    @Override
                    public void run() {

                        synchronized (this)
                        {
                            int i = 0;

                            while (i < 101) {

                                progressDialog.setProgress(i);

                                try {
                                    wait(100);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }

                                i++;
                            }

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    progressDialog.hide();
                                }
                            });
                        }
                    }
                });

                thread.start();
            }
        });
    }
}
