package iterator.ir.a010;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    ToggleButton toggleButtonBluetooth;
    Switch switchWifi;
    TextView textViewWifi;
    TextView textViewBluetooth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toggleButtonBluetooth= (ToggleButton) findViewById(R.id.toggleButtonBluetooth);
        switchWifi= (Switch) findViewById(R.id.switchWifi);
        textViewBluetooth= (TextView) findViewById(R.id.textViewBluetooth);
        textViewWifi= (TextView) findViewById(R.id.textViewWifi);

        textViewBluetooth.setText("");
        textViewWifi.setText("");

        switchWifi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
                    textViewWifi.setText("Wifi is On");
                }
                else {
                    textViewWifi.setText("Wifi is Off");
                }
            }
        });


        switchWifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // both are correct
            }
        });

        toggleButtonBluetooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean isChecked=((ToggleButton) v).isChecked();

                if (isChecked)
                {
                    textViewBluetooth.setText("Bluetooth is On");
                }
                else {
                    textViewBluetooth.setText("Bluetooth is Off");
                }
            }
        });
    }
}
