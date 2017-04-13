package mhdr.ir.a062;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class ViewActivity extends AppCompatActivity {

    ListView listViewContacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        listViewContacts= (ListView) findViewById(R.id.listViewContacts);

        DatabaseHandler databaseHandler=new DatabaseHandler(ViewActivity.this);
        Contacts contacts=new Contacts(databaseHandler);
        Cursor cursor=contacts.getAllContactsCursor();

        ListViewContactAdapter adapter=new ListViewContactAdapter(ViewActivity.this,cursor);

        listViewContacts.setAdapter(adapter);
    }
}
