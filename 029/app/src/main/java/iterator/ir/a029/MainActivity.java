package iterator.ir.a029;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonFirst;
    Button buttonSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final FragmentManager fragmentManager=getSupportFragmentManager();

        final FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();

        FirstFragment firstFragment=new FirstFragment();

        fragmentTransaction.add(R.id.relativeLayoutFragment,firstFragment);

        fragmentTransaction.commit();

        buttonFirst= (Button) findViewById(R.id.buttonFirstFragment);
        buttonSecond= (Button) findViewById(R.id.buttonSecondFragment);

        buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final FragmentManager fragmentManager=getSupportFragmentManager();

                final FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();

                FirstFragment firstFragment=new FirstFragment();

                fragmentTransaction.replace(R.id.relativeLayoutFragment,firstFragment);

                fragmentTransaction.commit();
            }
        });

        buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final FragmentManager fragmentManager=getSupportFragmentManager();

                final FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();

                SecondFragment secondFragment=new SecondFragment();

                fragmentTransaction.replace(R.id.relativeLayoutFragment,secondFragment);

                fragmentTransaction.commit();
            }
        });
    }
}
