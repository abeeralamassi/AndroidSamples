package mhdr.ir.a059;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AnimatedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animated);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.activity_back_in,R.anim.activity_back_out);
    }
}
