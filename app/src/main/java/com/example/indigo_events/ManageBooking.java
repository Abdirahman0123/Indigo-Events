package com.example.indigo_events;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ManageBooking extends AppCompatActivity {
    DbHelper DB;
    EditText editTextID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_booking);
        DB = new DbHelper(this);
        editTextID = (EditText) findViewById(R.id.IdEditText);
    }

    // Go back to Home Screen
    public void returnToHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    // Go back to Event List screen
    public void returnToEventList(View view) {
        Intent intent = new Intent(this, Eventlist.class);
        startActivity(intent);
    }
    // View Your Booking
    public void viewBooking (View view) {
        // get the reference id from the user
        String idText = editTextID.getText().toString();
        // if the user does not enter a reference id, display error
        // else get booking details from the database
        if (idText.length() == 0) {
            Toast.makeText(this, "Please enter your Reference Id", Toast.LENGTH_SHORT).show();
        }
        else {
            // pass the id to yourBooking method and store  method return to result.
            Cursor result = DB.yourBooking(idText);
            // if result is empty, display "No Booking found"
            if (result.getCount() == 0) {
                Toast.makeText(this, "No Booking found", Toast.LENGTH_SHORT).show();
                return; // exits the method
            }
            // create StringBuffer object to store booking details in result variable
            StringBuffer buffer = new StringBuffer();
            // Loop through the result and add the values to the buffer
            while (result.moveToNext()) {
                buffer.append("Id: " + result.getString(0) + "\n");
                buffer.append("Name: " + result.getString(1) + "\n");
                buffer.append("Email: " + result.getString(2) + "\n");
                buffer.append("Phone Number: " + result.getString(3) + "\n");
                buffer.append("Age: " + result.getString(4) + "\n");
                buffer.append("Event: " + result.getString(5) + "\n");
            }
            // create alert dialogue to display the booking details
            AlertDialog.Builder builder = new AlertDialog.Builder(ManageBooking.this);
            builder.setTitle("Your Booking");
            builder.setMessage(buffer.toString()); // set the message to the buffer object
            builder.setCancelable(true);
            builder.setNeutralButton(android.R.string.ok,
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }});
            AlertDialog alert = builder.create();
            alert.show();}
    }

    // Button Delete your Booking
    public  void cancelBooking(View view){
        // get the reference id from the user
        String idText = editTextID.getText().toString();
        // if the user does not enter a reference id, display error
        // else delete booking details from the database
        if (idText.length() == 0) {
            Toast.makeText(this, "Please enter your Reference Id", Toast.LENGTH_SHORT).show();
        } else {
            // create alert dialogue for delete confirmation
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setIcon(android.R.drawable.ic_dialog_alert);
            alert.setTitle("Cancel Booking");
            alert.setMessage("Do you want to Cancel your Booking?");
            alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    // if the user clicks on "Yes", deleteTheBooking method
                    // and pass the reference id to it
                    deleteTheBooking(idText);
                }});
            alert.setNegativeButton("No", null);
            alert.show();
            // clear editTextID
            editTextID.setText(" ");
        }
    }
    // delete the booking
    public void deleteTheBooking(String idText) {
        // deleteBooking method of the DbHelper class and store method return to checkDelete
        Boolean checkDelete = DB.deleteBooking(idText);
        // if checkDelete is false, display  No Booking found as there is no booking to delete
        // else display Done! Booking deleted
        if (checkDelete == false) {
            Toast.makeText(this, "No Booking found", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Done! Booking cancelled", Toast.LENGTH_SHORT).show();
        }
    }
}