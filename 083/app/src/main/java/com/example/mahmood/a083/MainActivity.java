package com.example.mahmood.a083;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.VectorEnabledTintResources;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    ViewFlipper viewFlipper;
    Button buttonPrevious;
    Button buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewFlipper= (ViewFlipper) findViewById(R.id.viewFlipper);
        //viewFlipper.setInAnimation();
        //viewFlipper.setOutAnimation();
        //viewFlipper.setFlipInterval(1000);
        //viewFlipper.startFlipping();

        buttonPrevious= (Button) findViewById(R.id.buttonPrevious);
        buttonNext= (Button) findViewById(R.id.buttonNext);

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.showNext();
            }
        });


        buttonPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.showPrevious();
            }
        });
    }


}
