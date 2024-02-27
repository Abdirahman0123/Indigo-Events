package com.example.indigo_events;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    // create the database
    public DbHelper(Context context) {
        // create EventBooking database with version 1
        super(context, "EventBookings.db", null, 1);
    }

    // create Bookings table
    @Override
    public void onCreate(SQLiteDatabase DB) {
        // Create Bookings table with its columns
        DB.execSQL(
                "create table Bookings(id TEXT primary key, fullName TEXT, email TEXT, phoneNumber TEXT, age INTEGER, eventName TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase Db, int i, int i1) {
        // drop the table if it already exists
        Db.execSQL("drop table if exists Bookings");
    }
    // insert booking details into the Bookings table
    public Boolean insertBooking(String id, String name, String email,
                                 String pNumber, int age, String event) {
        // open the database for reading and writing
        SQLiteDatabase Db = this.getWritableDatabase();
        // Contentvalues is used to store set of values (booking details).
        ContentValues contentValues = new ContentValues();
        /* put method takes table column name as a key and method
           parameter as value*/
        contentValues.put("id", id);
        contentValues.put("fullName", name);
        contentValues.put("email", email);
        contentValues.put("phoneNumber", pNumber);
        contentValues.put("age", age);
        contentValues.put("eventName", event);

        // insert contentValues (booking details) into Bookings table
        long result = Db.insert("Bookings", null, contentValues);
        /* check if the insertion is successful. If result is -1,
        insertion has failed so return false else return true */
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Boolean deleteBooking(String id) {
        // open the database for reading and writing
        SQLiteDatabase DB = this.getWritableDatabase();
        // rawQuery returns the booking the matches the id
        Cursor cursor = DB.rawQuery("select id from Bookings where id = ?", new String[]{id});

        // if cursor is empty, return false else delete the booking with specified id
        if (cursor.getCount() == 0) {
            return false;
        } else {
            // delete the booking
            long result = DB.delete("Bookings", "id=?", new String[]{id});
            /*if the result is -1, the deletion has failed
             return false, */
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }
    }

    // return booking details with the specified id
    public Cursor yourBooking(String id) {
        // open the database for reading and writing
        SQLiteDatabase Db = this.getWritableDatabase();
        // return the booking details with the specified id
        Cursor cursor = Db.rawQuery("select * from Bookings where id=?", new String[]{id});
        return cursor;
    }

}
