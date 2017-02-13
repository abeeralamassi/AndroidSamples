package iterator.ir.a027;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button buttonSelectNetwork;
    int previousSelectedNetwork =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSelectNetwork= (Button) findViewById(R.id.buttonSelectNetwork);

        buttonSelectNetwork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerForContextMenu(v);
                openContextMenu(v);
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.menu_radio_button,menu);

        MenuItem itemWifi=menu.findItem(R.id.itemWifi);
        MenuItem itemBluetooth=menu.findItem(R.id.itemBluetooth);
        MenuItem itemData=menu.findItem(R.id.itemData);

        if (previousSelectedNetwork==1)
        {
            itemWifi.setChecked(true);
        }
        else if (previousSelectedNetwork==2)
        {
            itemBluetooth.setChecked(true);
        }
        else if (previousSelectedNetwork==3)
        {
            itemData.setChecked(true);
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if (item.getItemId()==R.id.itemWifi)
        {
            previousSelectedNetwork =1;
            Toast.makeText(getBaseContext(),"Wifi",Toast.LENGTH_LONG).show();
        }
        else if (item.getItemId()==R.id.itemBluetooth)
        {
            previousSelectedNetwork =2;
            Toast.makeText(getBaseContext(),"Bluetooth",Toast.LENGTH_LONG).show();
        }
        else if (item.getItemId()==R.id.itemData)
        {
            previousSelectedNetwork =3;
            Toast.makeText(getBaseContext(),"Data",Toast.LENGTH_LONG).show();
        }

        return super.onContextItemSelected(item);
    }
}
