package com.example.indigo_events;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LondonCulture extends AppCompatActivity {
    // Create the activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_london_culture);
    }
    // Button to open MainActivity
    public void returnToHome(View view) {
        // intent to open MainActivity
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    // Button to open EventList
    public void returnToEventList(View view) {
        // intent to open EventList
        Intent intent = new Intent(this, Eventlist.class);
        startActivity(intent);
    }
    // Button to open Booking
    public void bookEvent(View view) {
        // intent to open Booking
        Intent intent = new Intent(this, booking.class);
        startActivity(intent);
    }
}
