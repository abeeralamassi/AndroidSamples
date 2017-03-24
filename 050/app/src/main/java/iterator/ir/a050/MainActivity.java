package iterator.ir.a050;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textViewDownload;
    Button buttonDownload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewDownload= (TextView) findViewById(R.id.textViewDownload);
        buttonDownload= (Button) findViewById(R.id.buttonDownload);

        buttonDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyTask myTask=new MyTask(MainActivity.this);
                myTask.setButtonDownload(buttonDownload);
                myTask.setTextViewDownload(textViewDownload);
                myTask.execute();
            }
        });
    }
}
