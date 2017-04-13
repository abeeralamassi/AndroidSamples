package mhdr.ir.a062;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mahmood on 4/13/17.
 */

public class Contacts {
    private DatabaseHandler dbHandler;

    public Contacts(DatabaseHandler dbHandler) {
        this.dbHandler = dbHandler;
    }


    public long addContact(Contact contact) {
        SQLiteDatabase db = this.dbHandler.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DatabaseHandler.Schema_Contacts.COL2_NAME, contact.getName());
        values.put(DatabaseHandler.Schema_Contacts.COL3_PHONE_NUMBER, contact.getPhoneNumber());
        values.put(DatabaseHandler.Schema_Contacts.COL4_EMAIL_ADDRESS, contact.getEmailAddress());

        long inserted_id=db.insert(DatabaseHandler.Schema_Contacts.TABLE_NAME, null, values);
        db.close();

        return inserted_id;
    }

    public Cursor getContactCursor(int id)
    {
        SQLiteDatabase db = this.dbHandler.getReadableDatabase();


        String[] columns={
                DatabaseHandler.Schema_Contacts.COL1_ID,
                DatabaseHandler.Schema_Contacts.COL2_NAME,
                DatabaseHandler.Schema_Contacts.COL3_PHONE_NUMBER,
                DatabaseHandler.Schema_Contacts.COL4_EMAIL_ADDRESS
        };

        String selection=DatabaseHandler.Schema_Contacts.COL1_ID + " = ?";
        String[] selectionArgs={String.valueOf(id)};

        Cursor cursor = db.query(DatabaseHandler.Schema_Contacts.TABLE_NAME,columns,
                selection,
                selectionArgs, null, null, null, null);

        return cursor;
    }

    public Contact getContact(int id) {
        SQLiteDatabase db = this.dbHandler.getReadableDatabase();

        String[] columns={
                DatabaseHandler.Schema_Contacts.COL1_ID,
                DatabaseHandler.Schema_Contacts.COL2_NAME,
                DatabaseHandler.Schema_Contacts.COL3_PHONE_NUMBER,
                DatabaseHandler.Schema_Contacts.COL4_EMAIL_ADDRESS
        };

        String selection=DatabaseHandler.Schema_Contacts.COL1_ID + " = ?";
        String[] selectionArgs={String.valueOf(id)};

        Cursor cursor = db.query(DatabaseHandler.Schema_Contacts.TABLE_NAME,columns,
                selection,
                selectionArgs, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        Contact contact = new Contact(cursor.getInt(cursor.getColumnIndex(DatabaseHandler.Schema_Contacts.COL1_ID)),
                cursor.getString(cursor.getColumnIndex(DatabaseHandler.Schema_Contacts.COL2_NAME)),
                cursor.getString(cursor.getColumnIndex(DatabaseHandler.Schema_Contacts.COL3_PHONE_NUMBER)),
                cursor.getString(cursor.getColumnIndex(DatabaseHandler.Schema_Contacts.COL4_EMAIL_ADDRESS)));


        cursor.close();
        db.close();

        return contact;
    }

    public List<Contact> getAllContacts() {
        List<Contact> contactList = new ArrayList<Contact>();

        String selectQuery = String.format("SELECT * FROM %s", DatabaseHandler.Schema_Contacts.TABLE_NAME);

        SQLiteDatabase db = this.dbHandler.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Contact contact = new Contact(cursor.getInt(cursor.getColumnIndex(DatabaseHandler.Schema_Contacts.COL1_ID)),
                        cursor.getString(cursor.getColumnIndex(DatabaseHandler.Schema_Contacts.COL2_NAME)),
                        cursor.getString(cursor.getColumnIndex(DatabaseHandler.Schema_Contacts.COL3_PHONE_NUMBER)),
                        cursor.getString(cursor.getColumnIndex(DatabaseHandler.Schema_Contacts.COL4_EMAIL_ADDRESS)));

                contactList.add(contact);
            } while (cursor.moveToNext());
        }


        cursor.close();
        db.close();

        return contactList;
    }

    public Cursor getAllContactsCursor() {
        String selectQuery = String.format("SELECT * FROM %s", DatabaseHandler.Schema_Contacts.TABLE_NAME);

        SQLiteDatabase db = this.dbHandler.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        return cursor;
    }

    public List<Contact> getContactsByName(String name) {
        List<Contact> contactList = new ArrayList<Contact>();

        SQLiteDatabase db = this.dbHandler.getWritableDatabase();

        String[] columns={
                DatabaseHandler.Schema_Contacts.COL1_ID,
                DatabaseHandler.Schema_Contacts.COL2_NAME,
                DatabaseHandler.Schema_Contacts.COL3_PHONE_NUMBER,
                DatabaseHandler.Schema_Contacts.COL4_EMAIL_ADDRESS
        };

        String selection=DatabaseHandler.Schema_Contacts.COL2_NAME + " LIKE ?";
        String[] selectionArgs={name};

        Cursor cursor = db.query(DatabaseHandler.Schema_Contacts.TABLE_NAME,columns,selection,selectionArgs,null,null,null);

        if (cursor.moveToFirst()) {
            do {
                Contact contact = new Contact(cursor.getInt(cursor.getColumnIndex(DatabaseHandler.Schema_Contacts.COL1_ID)),
                        cursor.getString(cursor.getColumnIndex(DatabaseHandler.Schema_Contacts.COL2_NAME)),
                        cursor.getString(cursor.getColumnIndex(DatabaseHandler.Schema_Contacts.COL3_PHONE_NUMBER)),
                        cursor.getString(cursor.getColumnIndex(DatabaseHandler.Schema_Contacts.COL4_EMAIL_ADDRESS)));

                contactList.add(contact);
            } while (cursor.moveToNext());
        }


        cursor.close();
        db.close();

        return contactList;
    }

    public Cursor getContactsByNameCursor(String name) {

        SQLiteDatabase db = this.dbHandler.getWritableDatabase();

        String[] columns={
                DatabaseHandler.Schema_Contacts.COL1_ID,
                DatabaseHandler.Schema_Contacts.COL2_NAME,
                DatabaseHandler.Schema_Contacts.COL3_PHONE_NUMBER,
                DatabaseHandler.Schema_Contacts.COL4_EMAIL_ADDRESS
        };

        String selection=DatabaseHandler.Schema_Contacts.COL2_NAME + " LIKE ?";
        String[] selectionArgs={name};

        Cursor cursor = db.query(DatabaseHandler.Schema_Contacts.TABLE_NAME,columns,selection,selectionArgs,null,null,null);


        return cursor;
    }

    public int getContactsCount() {
        String countQuery = "SELECT  * FROM " + DatabaseHandler.Schema_Contacts.TABLE_NAME;
        SQLiteDatabase db = this.dbHandler.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();

        cursor.close();
        db.close();


        return count;
    }

    public int updateContact(Contact contact) {
        SQLiteDatabase db = this.dbHandler.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DatabaseHandler.Schema_Contacts.COL2_NAME, contact.getName());
        values.put(DatabaseHandler.Schema_Contacts.COL3_PHONE_NUMBER, contact.getPhoneNumber());
        values.put(DatabaseHandler.Schema_Contacts.COL4_EMAIL_ADDRESS, contact.getEmailAddress());


        int rows_affected = db.update(DatabaseHandler.Schema_Contacts.TABLE_NAME, values,
                DatabaseHandler.Schema_Contacts.COL1_ID + " = ?",
                new String[]{String.valueOf(contact.getId())});
        db.close();

        return rows_affected;
    }

    public int deleteContact(Contact contact) {
        SQLiteDatabase db = this.dbHandler.getWritableDatabase();
        int rows_affected=db.delete(DatabaseHandler.Schema_Contacts.TABLE_NAME,
                DatabaseHandler.Schema_Contacts.COL1_ID + " = ?",
                new String[]{String.valueOf(contact.getId())});
        db.close();

        return rows_affected;
    }
}
