package com.example.mahmood.a085;

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
        country1.setImage(R.mipmap.iran);

        Country country2=new Country();
        country2.setName("Netherlands");
        country2.setCapital("Amsterdam");
        country2.setImage(R.mipmap.netherlands);

        Country country3=new Country();
        country3.setName("Turkey");
        country3.setCapital("Ankara");
        country3.setImage(R.mipmap.turkey);

        Country country4=new Country();
        country4.setName("Ukraine");
        country4.setCapital("Kiev");
        country4.setImage(R.mipmap.ukraine);


        Country country5=new Country();
        country5.setName("Russia");
        country5.setCapital("Moscow");
        country5.setImage(R.mipmap.russia);

        Country country6=new Country();
        country6.setName("United States");
        country6.setCapital("Washington, D.C.");
        country6.setImage(R.mipmap.usa);

        countryList.add(country1);
        countryList.add(country2);
        countryList.add(country3);
        countryList.add(country4);
        countryList.add(country5);
        countryList.add(country6);
    }
}
