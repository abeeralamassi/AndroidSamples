package iterator.ir.a022;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listViewCities;
    String[] cities;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewCities= (ListView) findViewById(R.id.listViewCities);

        cities=getResources().getStringArray(R.array.cities);

        arrayAdapter=new ArrayAdapter<String>(getBaseContext(), R.layout.custom_listview_layout,R.id.textViewCity,cities);

        listViewCities.setAdapter(arrayAdapter);

        registerForContextMenu(listViewCities);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.contextual_menu,menu);
    }
}
