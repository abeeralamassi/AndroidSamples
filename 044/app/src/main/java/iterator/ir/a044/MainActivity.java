package iterator.ir.a044;

import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment fragment=new PageFragment();
        Bundle bundle=new Bundle();
        bundle.putInt("pageNumber",10);
        fragment.setArguments(bundle);

        FragmentManager fragmentManager=getSupportFragmentManager();

        FragmentTransaction transaction= fragmentManager.beginTransaction();

        transaction.add(R.id.relativeLayoutFragmentContainer,fragment);

        transaction.commit();
    }

}
