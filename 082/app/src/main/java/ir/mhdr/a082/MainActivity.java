package ir.mhdr.a082;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Country> countryList=new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateCountries();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // animate items with DefaultItemAnimator
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        // specify an adapter (see also next example)
        adapter = new CountryAdapter(countryList);
        recyclerView.setAdapter(adapter);
    }

    private void generateCountries()
    {
        Country country1=new Country();
        country1.setName("Iran");
        country1.setCapital("Tehran");

        Country country2=new Country();
        country2.setName("Netherlands");
        country2.setCapital("Amsterdam");

        Country country3=new Country();
        country3.setName("Turkey");
        country3.setCapital("Ankara");

        Country country4=new Country();
        country4.setName("Ukraine");
        country4.setCapital("Kiev");


        Country country5=new Country();
        country5.setName("Russia");
        country5.setCapital("Moscow");

        Country country6=new Country();
        country6.setName("Chile");
        country6.setCapital("Santiago");

        Country country7=new Country();
        country7.setName("United States");
        country7.setCapital("Washington, D.C.");

        countryList.add(country1);
        countryList.add(country2);
        countryList.add(country3);
        countryList.add(country4);
        countryList.add(country5);
        countryList.add(country6);
        countryList.add(country7);
    }
}
