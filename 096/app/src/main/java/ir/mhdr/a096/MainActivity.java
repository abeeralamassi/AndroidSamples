package ir.mhdr.a096;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonShow= (Button) findViewById(R.id.buttonShow);

        buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                BottomSheetFragment bottomSheetFragment=new BottomSheetFragment();
                bottomSheetFragment.show(getSupportFragmentManager(),"bottomSheet");

            }
        });
    }
}
