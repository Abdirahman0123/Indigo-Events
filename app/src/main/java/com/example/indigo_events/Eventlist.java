package com.example.indigo_events;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Eventlist extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventlist);}
    public void homeButton(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);}
    public void teamBuildingButton(View view) {
        Intent intent = new Intent(this, TeamBuilding.class);
        startActivity(intent);}
    public void gadElmaleh(View view) {
    Intent intent = new Intent(this, gadElmaleh.class);
    startActivity(intent);
    }
    public void champoin(View view){
        Intent intent = new Intent(this, Champoin.class);
        startActivity(intent);
    }
    public void londonCulture(View view){
        Intent intent = new Intent(this, LondonCulture.class);
        startActivity(intent);
    }
}