package iterator.ir.a017;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CustomTimePickerDialogFragment.OnCustomTimePickerClickListener {

    Button buttonShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buttonShow= (Button) findViewById(R.id.buttonShow);

        buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomTimePickerDialogFragment customTimePickerDialogFragment=new CustomTimePickerDialogFragment();
                customTimePickerDialogFragment.show(getSupportFragmentManager(),"customDialog1");
            }
        });
    }

    @Override
    public void onCustomTimePickerClick(View view) {
        TimePicker timePickerMain= (TimePicker) view;

        String time=String.format("%s:%s",timePickerMain.getCurrentHour(),timePickerMain.getCurrentMinute());
        Toast.makeText(getBaseContext(),time,Toast.LENGTH_LONG).show();
    }
}
