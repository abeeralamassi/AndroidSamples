package iterator.ir.a042;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ExpandableListView expandableListViewProvinces;
    ArrayList<HeaderInfo> provonices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GenerateData();

        expandableListViewProvinces= (ExpandableListView) findViewById(R.id.expandableListViewProvinces);
        CustomAdapter adapter=new CustomAdapter(this,provonices);
        expandableListViewProvinces.setAdapter(adapter);
    }

    private void GenerateData()
    {
        provonices=new ArrayList<>();


        DetailInfo detailInfo1=new DetailInfo();
        detailInfo1.setCityName("Rasht");
        detailInfo1.setPopulation(1000000);


        DetailInfo detailInfo2=new DetailInfo();
        detailInfo2.setCityName("Lahijan");
        detailInfo2.setPopulation(700000);

        DetailInfo detailInfo3=new DetailInfo();
        detailInfo3.setCityName("Anzali");
        detailInfo3.setPopulation(800000);

        DetailInfo detailInfo4=new DetailInfo();
        detailInfo4.setCityName("Fouman");
        detailInfo4.setPopulation(200000);

        ArrayList<DetailInfo> cities1=new ArrayList<>();
        cities1.add(detailInfo1);
        cities1.add(detailInfo2);
        cities1.add(detailInfo3);
        cities1.add(detailInfo4);

        HeaderInfo headerInfo1=new HeaderInfo();
        headerInfo1.setProvoniceName("Guilan");
        headerInfo1.setCities(cities1);

        DetailInfo detailInfo5=new DetailInfo();
        detailInfo5.setCityName("Tehran");
        detailInfo5.setPopulation(10000000);


        DetailInfo detailInfo6=new DetailInfo();
        detailInfo6.setCityName("Hashtgerd");
        detailInfo6.setPopulation(700000);


        ArrayList<DetailInfo> cities2=new ArrayList<>();
        cities2.add(detailInfo5);
        cities2.add(detailInfo6);


        HeaderInfo headerInfo2=new HeaderInfo();
        headerInfo2.setProvoniceName("Tehran");
        headerInfo2.setCities(cities2);


        DetailInfo detailInfo7=new DetailInfo();
        detailInfo7.setCityName("Qazvin");
        detailInfo7.setPopulation(1000000);


        ArrayList<DetailInfo> cities3=new ArrayList<>();
        cities3.add(detailInfo7);

        HeaderInfo headerInfo3=new HeaderInfo();
        headerInfo3.setProvoniceName("Qazvin");
        headerInfo3.setCities(cities3);

        provonices.add(headerInfo1);
        provonices.add(headerInfo2);
        provonices.add(headerInfo3);
    }
}
