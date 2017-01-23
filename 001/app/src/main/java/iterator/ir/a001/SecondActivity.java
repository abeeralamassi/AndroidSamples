package iterator.ir.a001;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView textViewMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent=this.getIntent();
        String message=intent.getStringExtra("msg");

        textViewMessage= (TextView) findViewById(R.id.textViewMessage);
        textViewMessage.setText(message);
    }
}
