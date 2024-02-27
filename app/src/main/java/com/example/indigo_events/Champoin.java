package com.example.indigo_events;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Champoin extends AppCompatActivity {
    // Create the activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_champoin);
    }
    // button to open MainActivity
    public void returnToHome(View view) {
        // intent to open MainActivity
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    // button to open EventList
    public void returnToEventList(View view) {
        // Intent to open EventList
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
