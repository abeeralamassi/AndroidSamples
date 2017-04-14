package iterator.ir.a039;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ChildTwoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_two);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
