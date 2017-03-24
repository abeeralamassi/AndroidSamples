package iterator.ir.a013;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listViewCountries;
    ArrayAdapter<String> arrayAdapter;
    String[] countries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        countries=getResources().getStringArray(R.array.countries);

        listViewCountries= (ListView) findViewById(R.id.listViewCountries);

        arrayAdapter=new ArrayAdapter<String>(this, R.layout.listview_custom_layout, R.id.textViewListItem,countries);
        listViewCountries.setAdapter(arrayAdapter);

        listViewCountries.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast toast=Toast.makeText(getBaseContext(),parent.getItemAtPosition(position).toString(),Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }
}
