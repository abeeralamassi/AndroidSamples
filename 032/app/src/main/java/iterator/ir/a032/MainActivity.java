package iterator.ir.a032;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.net.TrafficStatsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements FirstFragment.OnFragment1InteractionListener{

    RelativeLayout container1;
    RelativeLayout container2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        container1= (RelativeLayout) findViewById(R.id.relativeLayoutContainer1);
        container2= (RelativeLayout) findViewById(R.id.relativeLayoutContainer2);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();


        FirstFragment firstFragment=new FirstFragment();
        SecondFragment secondFragment=new SecondFragment();

        transaction.add(R.id.relativeLayoutContainer1,firstFragment);
        transaction.add(R.id.relativeLayoutContainer2,secondFragment);

        transaction.commit();
    }

    @Override
    public void onFragment1ButtonClicked(String name) {
        SecondFragment fragment= (SecondFragment) getSupportFragmentManager().findFragmentById(R.id.relativeLayoutContainer2);
        fragment.setTextViewMessage(name);
    }
}
