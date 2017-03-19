package iterator.ir.a051;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonProgress1;
    Button buttonProgress2;
    Button buttonProgress3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonProgress1 = (Button) findViewById(R.id.buttonProgress1);
        buttonProgress2 = (Button) findViewById(R.id.buttonProgress2);
        buttonProgress3 = (Button) findViewById(R.id.buttonProgress3);

        buttonProgress1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("Progress 1 ...");
                progressDialog.setMax(100);
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.setProgress(0);
                progressDialog.show();

                final Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {

                        synchronized (this) {
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


        buttonProgress2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("Progress 2 ...");
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.setIndeterminate(true);
                progressDialog.setMax(100);
                progressDialog.setProgress(0);
                progressDialog.show();

                final Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {

                        synchronized (this) {
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


        buttonProgress3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("Progress 3 ...");
                //progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressDialog.setMax(100);
                progressDialog.setProgress(0);
                progressDialog.show();

                final Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {

                        synchronized (this) {
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
