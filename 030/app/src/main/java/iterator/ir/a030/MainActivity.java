package iterator.ir.a030;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {


    RadioGroup radioGroup;
    RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout= (RelativeLayout) findViewById(R.id.activity_main);
        radioGroup= (RadioGroup) findViewById(R.id.radioGroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId)
                {
                    case R.id.radioButtonRed:
                        layout.setBackgroundColor(getResources().getColor(R.color.red));
                        break;
                    case R.id.radioButtonBlue:
                        layout.setBackgroundColor(getResources().getColor(R.color.blue));
                        break;
                }
            }
        });
    }
}
