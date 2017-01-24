package iterator.ir.a005;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonShow_onClick(View view)
    {
        Toast toast=Toast.makeText(this,"Hello",Toast.LENGTH_LONG);
        toast.show();
    }
}
