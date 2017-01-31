package iterator.ir.a014;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listViewCountries;
    String[] countries;
    ArrayAdapter<String> listViewArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countries=getResources().getStringArray(R.array.countries);

        listViewCountries= (ListView) findViewById(R.id.listviewCountries);

        listViewArrayAdapter=new ArrayAdapter<String>(getBaseContext(), R.layout.listview_countries_custom_layout, R.id.textViewListViewCountriesItem,countries);

        listViewCountries.setAdapter(listViewArrayAdapter);


        listViewCountries.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast toast=Toast.makeText(getBaseContext(),parent.getItemAtPosition(position).toString(),Toast.LENGTH_SHORT);
                toast.show();

                view.setSelected(true);
            }
        });
    }
}
