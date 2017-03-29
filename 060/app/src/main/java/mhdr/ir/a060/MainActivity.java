package mhdr.ir.a060;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonFirst;
    Button buttonSecond;
    FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirstFragment firstFragment=new FirstFragment();
        SecondFragment secondFragment=new SecondFragment();

        transaction= getSupportFragmentManager().beginTransaction();

        transaction.add(R.id.relativeLayoutContainer,firstFragment);

        transaction.commit();

        buttonFirst= (Button) findViewById(R.id.buttonFirst);
        buttonSecond= (Button) findViewById(R.id.buttonSecond);

        buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction=getSupportFragmentManager().beginTransaction();
                transaction.setCustomAnimations(R.anim.activity_back_in,R.anim.activity_back_out);

                FirstFragment firstFragment=new FirstFragment();
                transaction.replace(R.id.relativeLayoutContainer,firstFragment);

                transaction.commit();
            }
        });


        buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction=getSupportFragmentManager().beginTransaction();
                transaction.setCustomAnimations(R.anim.activity_back_in,R.anim.activity_back_out);

                SecondFragment secondFragment=new SecondFragment();
                transaction.replace(R.id.relativeLayoutContainer,secondFragment);

                transaction.commit();
            }
        });
    }
}
