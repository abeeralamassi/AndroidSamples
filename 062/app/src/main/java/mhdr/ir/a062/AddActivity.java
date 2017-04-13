package mhdr.ir.a062;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {

    Button buttonAddContact;
    EditText editTextName;
    EditText editTextPhone;
    EditText editTextEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        buttonAddContact= (Button) findViewById(R.id.buttonAddContact);
        buttonAddContact.setOnClickListener(buttonAddContact_OnClickListener);

        editTextName= (EditText) findViewById(R.id.editTextName);
        editTextPhone= (EditText) findViewById(R.id.editTextPhone);
        editTextEmail= (EditText) findViewById(R.id.editTextEmail);
    }

    View.OnClickListener buttonAddContact_OnClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String name=editTextName.getText().toString();
            String phone=editTextPhone.getText().toString();
            String email=editTextEmail.getText().toString();


            Contact contact=new Contact(name,phone,email);

            DatabaseHandler databaseHandler=new DatabaseHandler(getBaseContext());
            Contacts contacts=new Contacts(databaseHandler);
            long newId= contacts.addContact(contact);

            if (newId>0)
            {
                Toast.makeText(getApplicationContext(),"New Data Saved",Toast.LENGTH_LONG).show();

                editTextName.setText("");
                editTextPhone.setText("");
                editTextEmail.setText("");
            }
        }
    };
}
