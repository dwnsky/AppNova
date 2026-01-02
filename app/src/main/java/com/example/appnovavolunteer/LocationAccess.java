package com.example.appnovavolunteer;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class LocationAccess extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_access);

        Button btnShareLocation = findViewById(R.id.btnShareLocation);
        TextView tvSkip = findViewById(R.id.tvSkip);

        // Jika user share location, bawa mereka ke HomeActivity
        btnShareLocation.setOnClickListener(v -> {
            Intent intent = new Intent(LocationAccess.this, HomeActivity.class);
            startActivity(intent);
        });

        // Skip juga bawa ke HomeActivity
        tvSkip.setOnClickListener(v -> {
            Intent intent = new Intent(LocationAccess.this, HomeActivity.class);
            startActivity(intent);
        });
    }
}