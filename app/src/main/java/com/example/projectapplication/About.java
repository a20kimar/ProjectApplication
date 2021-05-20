package com.example.projectapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        TextView t = findViewById(R.id.aboutText);
        t.setText("About\nThis application was made for people with an interest in ancient megalithic monuments and stonework." +
                "\nMore notably made by ancient civilization that we know very little about." +
                "\nThe app contains information about a few monuments and structures that might have been constructed in a way we're not familiar with.");
    }
}