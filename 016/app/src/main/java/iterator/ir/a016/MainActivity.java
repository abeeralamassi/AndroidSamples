package iterator.ir.a016;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CustomDialogFragment.OnCustomDialogButtonClickListener {

    Button buttonShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonShow= (Button) findViewById(R.id.buttonShow);

        buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialogFragment customDialogFragment=new CustomDialogFragment();
                customDialogFragment.show(getSupportFragmentManager(),"customDialog1");
            }
        });
    }

    @Override
    public void onCustomDialogClick(View view) {
        switch (view.getId())
        {
            case R.id.buttonNo:
                Toast.makeText(this,"No",Toast.LENGTH_LONG).show();
                break;
            case R.id.buttonYes:
                Toast.makeText(this,"Yes",Toast.LENGTH_LONG).show();
        }
    }
}
