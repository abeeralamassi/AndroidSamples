package mhdr.ir.a062;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SearchActivity extends AppCompatActivity {

    Button buttonSearchContacts;
    EditText editTextSearchName;
    TextView textViewDisplayName;
    TextView textViewDisplayPhone;
    TextView textViewDisplayEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        buttonSearchContacts= (Button) findViewById(R.id.buttonSearchContacts);
        buttonSearchContacts.setOnClickListener(buttonSearchContacts_OnClickListener);

        editTextSearchName= (EditText) findViewById(R.id.editTextSearchName);
        textViewDisplayName= (TextView) findViewById(R.id.textViewDisplayName);
        textViewDisplayPhone= (TextView) findViewById(R.id.textViewDisplayPhone);
        textViewDisplayEmail= (TextView) findViewById(R.id.textViewDisplayEmail);
    }

    View.OnClickListener buttonSearchContacts_OnClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String nameToSearch=editTextSearchName.getText().toString();


        }
    };
}
