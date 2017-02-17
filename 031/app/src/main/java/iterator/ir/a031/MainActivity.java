package iterator.ir.a031;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements ChangeColorFragment.OnChangeColorFragmentInteractionListener{

    RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout= (RelativeLayout) findViewById(R.id.activity_main);

        FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();

        ChangeColorFragment changeColorFragment=new ChangeColorFragment();
        transaction.add(R.id.relativeLayoutFragmentContainer,changeColorFragment);

        transaction.commit();
    }

    @Override
    public void onChangeColorFragmentInteraction(int id) {
        switch (id)
        {
            case R.id.radioButtonRed:
                layout.setBackgroundColor(getResources().getColor(R.color.red));
                break;
            case R.id.radioButtonBlue:
                layout.setBackgroundColor(getResources().getColor(R.color.blue));
                break;
        }
    }
}
