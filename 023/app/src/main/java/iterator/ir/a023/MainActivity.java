package iterator.ir.a023;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ListView listViewCities;
    ArrayList<String> cities=new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewCities= (ListView) findViewById(R.id.listViewCities);

        String[] temp=getResources().getStringArray(R.array.cities);
        for (String city:temp)
        {
            cities.add(city);
        }

        arrayAdapter=new ArrayAdapter<String>(getBaseContext(), R.layout.custom_listview_layout,R.id.textViewCity,cities);

        listViewCities.setAdapter(arrayAdapter);

        registerForContextMenu(listViewCities);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.contextual_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo contextMenuInfo= (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        if (item.getItemId()==R.id.itemDelete)
        {
            cities.remove(contextMenuInfo.position);
            arrayAdapter.notifyDataSetChanged();
        }

        return super.onContextItemSelected(item);
    }
}
