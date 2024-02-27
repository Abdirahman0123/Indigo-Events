package com.example.indigo_events;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class booking extends AppCompatActivity {
    EditText nameEditText, emailEditText, phoneNumberEditText;
    EditText ageEditText,  eventEditText;
    DbHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        DB = new DbHelper(this);
        nameEditText = (EditText) findViewById(R.id.nameEditText);
        emailEditText = (EditText) findViewById(R.id.emailEditText);
        phoneNumberEditText = (EditText) findViewById(R.id.phoneNumberEditText);
        ageEditText = (EditText) findViewById(R.id.ageEditText);
        eventEditText = (EditText) findViewById(R.id.eventEditText);
    }
    public void returnToEventList(View view) {
        Intent intent = new Intent(this, Eventlist.class);
        startActivity(intent);
    }
    public void home(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    // book the event
    public void bookEvent(View view) {
        // get input data from the user
        String nameText = nameEditText.getText().toString();
        String emailText = emailEditText.getText().toString();
        String phoneNumberText = phoneNumberEditText.getText().toString();
        String ageText = ageEditText.getText().toString();
        String eventText = eventEditText.getText().toString();

        // declare a varaible to assign age as number
        int ageNumber;

        // if input not provided for each EditText, display error else insert booking details to the database
        // the first if condition checks if the user does not enter anything
        if (nameText.equals("") || emailText.equals("") || phoneNumberText.equals("")
                || ageText.equals("") || eventText.equals("")) {
            Toast.makeText(this, "All fields are required ", Toast.LENGTH_SHORT).show();

        } else {
            // convert ageText to ageNumber
            ageNumber = Integer.parseInt(ageText.toString());
            // check if the user is over 18
            if (ageNumber < 18) {
                Toast.makeText(this, "You must be 18 to attend events ", Toast.LENGTH_SHORT).show();
            } else {
                // get reference id for the booking
                int referenceId = idGenerator();
                // insert the booking to the database
                Boolean checkInsertion = DB.insertBooking(String.valueOf(referenceId), nameText, emailText,
                        phoneNumberText, ageNumber, eventText);
                /* check if insertion is successful. If it is,
                display confirmation and the reference Id */
                if (checkInsertion == true) {
                    // create alert dialgue to confirm the booking and display referenceId
                    AlertDialog.Builder builder = new AlertDialog.Builder(booking.this);
                    builder.setTitle("Booking Successfull");
                    builder.setMessage("Your reference Id " + referenceId);
                    builder.setCancelable(true);
                    builder.setNeutralButton(android.R.string.ok,
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();}});
                    AlertDialog alert = builder.create();
                    alert.show();}

                // clear EditTexts
                nameEditText.setText("");
                emailEditText.setText("");
                phoneNumberEditText.setText("");
                ageEditText.setText("");
                eventEditText.setText("");}
        }
    }
    // generate unique Id for bookings
    public int idGenerator() {
        int min = 0;
        int max = 100000;

        // // return the generated Id
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }
}

