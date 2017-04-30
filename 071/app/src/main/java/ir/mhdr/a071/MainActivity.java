package ir.mhdr.a071;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.NumberPicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textViewMessage;
    CustomNumberPicker numberPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewMessage = (TextView) findViewById(R.id.textViewMessage);

        // the base way to do this in android
        // the font is placed on assets/fonts/BNazanin.ttf
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/BNazanin.ttf");
        textViewMessage.setTypeface(typeface);


        // for other views we need to extend view
        numberPicker = (CustomNumberPicker) findViewById(R.id.numberPicker);
        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(99);
        numberPicker.setValue(34);
    }
}
