package com.example.appnovavolunteer;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

        // 1. Share Location - Bawa ke MapsActivity (Halaman Peta)
        btnShareLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LocationAccess.this, MapsActivity.class);
                startActivity(intent);
            }
        });

        // 2. Skip - Bawa terus ke HomeActivity (Tanpa set lokasi)
        tvSkip.setOnClickListener(v -> {
            Intent intent = new Intent(LocationAccess.this, HomeActivity.class);
            startActivity(intent);
        });
    }
}