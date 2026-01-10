package com.example.appnovavolunteer;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class LoadingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading); // Your second XML

        // Automatic transition after 3 seconds
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(LoadingActivity.this, RoleActivity.class);
            startActivity(intent);
            finish(); // Remove loading screen from backstack
        }, 3000);
    }
}