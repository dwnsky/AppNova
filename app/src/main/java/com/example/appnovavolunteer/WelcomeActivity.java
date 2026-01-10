package com.example.appnovavolunteer;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome); // Your first XML

        // You have two buttons in your XML: get_started_button and btnNext.
        // I'll set the listener for btnNext as per your requirement.
        findViewById(R.id.btnNext).setOnClickListener(v -> {
            Intent intent = new Intent(WelcomeActivity.this, LoadingActivity.class);
            startActivity(intent);
        });
    }
}