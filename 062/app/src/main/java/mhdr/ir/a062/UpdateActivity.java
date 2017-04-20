package mhdr.ir.a062;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class UpdateActivity extends AppCompatActivity {

    Button buttonSearchContacts;
    EditText editTextSearchName;
    EditText editTextEditName;
    EditText editTextEditPhone;
    EditText editTextEditEmail;
    Button buttonEditContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        buttonSearchContacts = (Button) findViewById(R.id.buttonSearchContacts);
        buttonSearchContacts.setOnClickListener(buttonSearchContacts_OnClickListener);

        editTextSearchName = (EditText) findViewById(R.id.editTextSearchName);
        editTextEditName = (EditText) findViewById(R.id.editTextEditName);
        editTextEditPhone = (EditText) findViewById(R.id.editTextEditPhone);
        editTextEditEmail = (EditText) findViewById(R.id.editTextEditEmail);

        buttonEditContact= (Button) findViewById(R.id.buttonEditContact);
        buttonEditContact.setOnClickListener(buttonEditContact_OnClickListener);
    }

    View.OnClickListener buttonSearchContacts_OnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            editTextEditName.setText("");
            editTextEditPhone.setText("");
            editTextEditEmail.setText("");

            String nameToSearch = editTextSearchName.getText().toString();

            DatabaseHandler databaseHandler = new DatabaseHandler(UpdateActivity.this);
            Contacts contacts = new Contacts(databaseHandler);

            List<Contact> matchedContacts = contacts.getContactsByName(nameToSearch);

            if (matchedContacts != null & matchedContacts.size() > 0) {
                Contact matchedContact = matchedContacts.get(0);

                editTextEditName.setText(matchedContact.getName());
                editTextEditPhone.setText(matchedContact.getPhoneNumber());
                editTextEditEmail.setText(matchedContact.getEmailAddress());
            } else {
                Toast.makeText(getBaseContext(), "no match", Toast.LENGTH_LONG).show();
            }

        }
    };

    View.OnClickListener buttonEditContact_OnClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            DatabaseHandler databaseHandler=new DatabaseHandler(UpdateActivity.this);
            Contacts contacts=new Contacts(databaseHandler);

            String nameToSearch = editTextEditName.getText().toString();
            List<Contact> matchedContacts = contacts.getContactsByName(nameToSearch);
            Contact matchedContact = matchedContacts.get(0);

            String name=editTextEditName.getText().toString();
            String phone=editTextEditPhone.getText().toString();
            String email=editTextEditEmail.getText().toString();

            matchedContact.setName(name);
            matchedContact.setPhoneNumber(phone);
            matchedContact.setEmailAddress(email);

            if (contacts.updateContact(matchedContact)>0)
            {
                Toast.makeText(UpdateActivity.this,"Contact Updated",Toast.LENGTH_LONG).show();
            }
        }
    };
}
