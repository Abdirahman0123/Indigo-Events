package com.example.indigo_events;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // Create the activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);}
    // button to open EventList
    public void displayEventsList(View view) {
        // Intent to open EventList
        Intent intent = new Intent(this, Eventlist.class);
        startActivity(intent);}

    // button to exit the application
    public void exitApp(View view) {
        // Create a confirmation dialogue for existing the app
        // If the user clicks on "Yes", exit the application.
        // If he clicks on "No", don`t exit the application
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setIcon(android.R.drawable.ic_dialog_alert);
        alert.setTitle("Exit the Application");
        alert.setMessage("Are you sure you want to Exit?");
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // exit the application
                System.exit(0);}});
        alert.setNegativeButton("No", null);
        alert.show();
    }
    // button to open ManageBooking
    public void manageBookings(View  view){
        // Intent to open ManageBooking
        Intent intent = new Intent(this, ManageBooking.class);
        startActivity(intent);}
}
