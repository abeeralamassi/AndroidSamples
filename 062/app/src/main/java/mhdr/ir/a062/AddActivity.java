package mhdr.ir.a062;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddActivity extends AppCompatActivity {

    Button buttonAddContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        buttonAddContact= (Button) findViewById(R.id.buttonAddContact);
        buttonAddContact.setOnClickListener(buttonAddContact_OnClickListener);
    }

    View.OnClickListener buttonAddContact_OnClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {



        }
    };
}
