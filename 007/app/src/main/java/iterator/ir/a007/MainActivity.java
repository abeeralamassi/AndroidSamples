package iterator.ir.a007;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListAdapter;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView autoCompleteTextViewCities;
    String[] cities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        autoCompleteTextViewCities= (AutoCompleteTextView) findViewById(R.id.autoCompleteTextViewCities);

        cities=getResources().getStringArray(R.array.city_names);


        ArrayAdapter<String> arrayAdapterCities=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,cities);

        autoCompleteTextViewCities.setAdapter(arrayAdapterCities);
    }
}
