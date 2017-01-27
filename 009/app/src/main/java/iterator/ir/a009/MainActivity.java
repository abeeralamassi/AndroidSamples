package iterator.ir.a009;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult=(TextView) findViewById(R.id.textViewResult);
    }

    protected void radioButton_onClick(View view)
    {
        Boolean checked=((RadioButton) view).isChecked();
        RadioButton selected=(RadioButton) view;

        switch (selected.getId())
        {
            case R.id.radioButtonApple:

                if (checked)
                {
                    textViewResult.setText("Apple");
                }

                break;
            case R.id.radioButtonOrange:

                if (checked)
                {
                    textViewResult.setText("Orange");
                }

                break;
            case R.id.radioButtonBanana:

                if (checked)
                {
                    textViewResult.setText("Banana");
                }

                break;
        }

    }
}
