package com.example.appnovavolunteer;

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

        // 1. Link the views using the correct XML IDs
        Button btnShareLocation = findViewById(R.id.btnShareLocation);
        TextView tvSkip = findViewById(R.id.tvSkip);
        View btnNotifNav = findViewById(R.id.btnNotifNav); // Corrected ID
        View btnProfileNav = findViewById(R.id.btnProfileNav);

        // 2. Share Location -> Maps
        btnShareLocation.setOnClickListener(v -> {
            startActivity(new Intent(LocationAccess.this, MapsActivity.class));
        });

        // 3. Skip -> Home
        tvSkip.setOnClickListener(v -> {
            startActivity(new Intent(LocationAccess.this, HomeActivity.class));
        });

        // 4. Notification/Chat (Functional)
        if (btnNotifNav != null) {
            btnNotifNav.setOnClickListener(v -> {
                startActivity(new Intent(LocationAccess.this, ChatActivity.class));
            });
        }

        // 5. Profile/Account
        if (btnProfileNav != null) {
            btnProfileNav.setOnClickListener(v -> {
                startActivity(new Intent(LocationAccess.this, AccountActivity.class));
            });
        }
    }
}