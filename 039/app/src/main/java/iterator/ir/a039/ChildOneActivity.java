package iterator.ir.a039;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChildOneActivity extends AppCompatActivity {

    Button buttonOpenChildTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_one);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        buttonOpenChildTwo= (Button) findViewById(R.id.buttonOpenChildTwo);
        buttonOpenChildTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getBaseContext(),ChildTwoActivity.class);
                startActivity(intent);
            }
        });
    }
}
