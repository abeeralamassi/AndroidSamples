package mhdr.ir.a062;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class DeleteActivity extends AppCompatActivity {

    Button buttonSearchContacts;
    EditText editTextSearchName;
    TextView textViewDisplayName;
    TextView textViewDisplayPhone;
    TextView textViewDisplayEmail;
    Button buttonDeleteContacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        buttonSearchContacts = (Button) findViewById(R.id.buttonDSearchContacts);
        buttonSearchContacts.setOnClickListener(buttonSearchContacts_OnClickListener);

        editTextSearchName = (EditText) findViewById(R.id.editTextDSearchName);
        textViewDisplayName = (TextView) findViewById(R.id.textViewDDisplayName);
        textViewDisplayPhone = (TextView) findViewById(R.id.textViewDDisplayPhone);
        textViewDisplayEmail = (TextView) findViewById(R.id.textViewDDisplayEmail);

        buttonDeleteContacts = (Button) findViewById(R.id.buttonDDeleteContacts);
        buttonDeleteContacts.setOnClickListener(buttonDeleteContacts_OnClickListener);
    }

    View.OnClickListener buttonSearchContacts_OnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            textViewDisplayName.setText("");
            textViewDisplayPhone.setText("");
            textViewDisplayEmail.setText("");

            String nameToSearch = editTextSearchName.getText().toString();

            DatabaseHandler databaseHandler = new DatabaseHandler(DeleteActivity.this);
            Contacts contacts = new Contacts(databaseHandler);

            List<Contact> matchedContacts = contacts.getContactsByName(nameToSearch);

            if (matchedContacts != null & matchedContacts.size() > 0) {
                Contact matchedContact = matchedContacts.get(0);

                textViewDisplayName.setText(matchedContact.getName());
                textViewDisplayPhone.setText(matchedContact.getPhoneNumber());
                textViewDisplayEmail.setText(matchedContact.getEmailAddress());
            } else {
                Toast.makeText(getBaseContext(), "no match", Toast.LENGTH_LONG).show();
            }

        }
    };

    View.OnClickListener buttonDeleteContacts_OnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            DatabaseHandler databaseHandler = new DatabaseHandler(DeleteActivity.this);
            Contacts contacts = new Contacts(databaseHandler);

            String nameToSearch = textViewDisplayName.getText().toString();

            List<Contact> matchedContacts = contacts.getContactsByName(nameToSearch);
            Contact matchedContact = matchedContacts.get(0);

            if (contacts.deleteContact(matchedContact) > 0) {
                Toast.makeText(DeleteActivity.this,"Contact Deleted",Toast.LENGTH_LONG).show();
            }
        }
    };
}
