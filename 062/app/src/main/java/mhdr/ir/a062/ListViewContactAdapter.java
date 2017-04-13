package mhdr.ir.a062;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;


public class ListViewContactAdapter extends CursorAdapter {

    public ListViewContactAdapter(Context context, Cursor c) {
        super(context, c, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {

        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.listview_contacts_row,parent,false);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView textViewName= (TextView) view.findViewById(R.id.textViewName);
        TextView textViewPhone= (TextView) view.findViewById(R.id.textViewPhone);
        TextView textViewEmail= (TextView) view.findViewById(R.id.textViewEmail);

        String name=cursor.getString(cursor.getColumnIndex(DatabaseHandler.Schema_Contacts.COL2_NAME));
        String phone=cursor.getString(cursor.getColumnIndex(DatabaseHandler.Schema_Contacts.COL3_PHONE_NUMBER));
        String email=cursor.getString(cursor.getColumnIndex(DatabaseHandler.Schema_Contacts.COL4_EMAIL_ADDRESS));

        textViewName.setText(name);
        textViewPhone.setText(phone);
        textViewEmail.setText(email);
    }
}
