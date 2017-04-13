package mhdr.ir.a062;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonAdd;
    Button buttonView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAdd= (Button) findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(buttonAdd_OnClickListener);

        buttonView= (Button) findViewById(R.id.buttonView);
        buttonView.setOnClickListener(buttonView_OnClickListener);
    }

    View.OnClickListener buttonAdd_OnClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(getBaseContext(),AddActivity.class);
            startActivity(intent);
        }
    };

    View.OnClickListener buttonView_OnClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(getBaseContext(),ViewActivity.class);
            startActivity(intent);
        }
    };
}
