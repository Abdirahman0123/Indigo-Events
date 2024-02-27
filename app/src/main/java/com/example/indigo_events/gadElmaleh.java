package com.example.indigo_events;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class gadElmaleh extends AppCompatActivity {
    // Create the activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gad_elmaleh);
    }

    // Button to open MainActivity
    public void returnToHome(View view) {
        // intent to open MainActivity
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

     // Button to open Eventlist
    public void returnToEventList(View view) {
        // intent to open EventList
        Intent intent = new Intent(this, Eventlist.class);
        startActivity(intent);
    }
    // Button to open Booking
    public void bookEvent(View view) {
        // Intent to open Booking
        Intent intent = new Intent(this, booking.class);
        startActivity(intent);
    }
}
