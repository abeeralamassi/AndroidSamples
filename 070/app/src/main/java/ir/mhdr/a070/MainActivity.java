package ir.mhdr.a070;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.NumberPicker;

public class MainActivity extends AppCompatActivity {

    NumberPicker numberPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberPicker= (NumberPicker) findViewById(R.id.numberPicker2);
        numberPicker.setMaxValue(99);
        numberPicker.setMinValue(0);
        numberPicker.setValue(25);
        numberPicker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
    }
}
