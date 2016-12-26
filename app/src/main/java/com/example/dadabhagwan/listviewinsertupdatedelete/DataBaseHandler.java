package com.example.dadabhagwan.listviewinsertupdatedelete;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by agile on 24-Oct-16.
 */

public class DataBaseHandler extends SQLiteOpenHelper {
    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "studentDataBase";

    // Contacts table name
    private static final String STUDENT_TABLE = "contacts";


    // Contacts Table Columns names
    private static final String STUDENT_ID = "id";
    private static final String STUDENT_FIRST_NAME = "fname";
    private static final String STUDENT_LAST_NAME = "lname";
    private static final String STUDENT_AGE = "age";
    private static final String STUDENT_EDUCATION = "edu";

    public DataBaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + STUDENT_TABLE + "("
                + STUDENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + STUDENT_FIRST_NAME + " TEXT,"
                + STUDENT_LAST_NAME + " TEXT," + STUDENT_AGE + " TEXT," + STUDENT_EDUCATION + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + STUDENT_TABLE);

        // Create tables again
        onCreate(db);
    }
}

    //    addContact()
    // Adding new contact
//    public void addContact(Contact contact) {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(KEY_NAME, contact.get_name()); // Contact Name
//        values.put(KEY_PH_NO, contact.get_phone_number()); // Contact Phone Number
//
//        // Inserting Row
//        db.insert(TABLE_CONTACTS, null, values);
//        db.close(); // Closing database connection
//    }


    // Getting All Contacts
//    public List<Contact> getAllContacts() {
//        List<Contact> contactList = new ArrayList<Contact>();
//        // Select All Query
//        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;
//
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery(selectQuery, null);
//
//        // looping through all rows and adding to list
//        if (cursor.moveToFirst()) {
//            do {
//                Contact contact = new Contact();
//                contact.set_id(Integer.parseInt(cursor.getString(0)));
//                contact.set_name(cursor.getString(1));
//                contact.set_phone_number(cursor.getString(2));
//                // Adding contact to list
//                contactList.add(contact);
//            } while (cursor.moveToNext());
//        }
//
//        // return contact list
//        return contactList;
//    }


    // Updating single contact
//    public int updateContact(Contact contact) {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(KEY_NAME, contact.get_name());
//        values.put(KEY_PH_NO, contact.get_phone_number());
//
//        // updating row
//        return db.update(TABLE_CONTACTS, values, KEY_ID + " = ?",
//                new String[] { String.valueOf(contact.get_id()) });
//    }
//
//
//    // Deleting single contact
//    public void deleteContact(Contact contact) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete(TABLE_CONTACTS, KEY_ID + " = ?",
//                new String[] { String.valueOf(contact.get_id()) });
//        db.close();

