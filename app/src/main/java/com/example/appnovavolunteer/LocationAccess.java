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

        // 1. Inisialisasi Butang Utama
        Button btnShareLocation = findViewById(R.id.btnShareLocation);
        TextView tvSkip = findViewById(R.id.tvSkip);

        // 2. Inisialisasi Bottom Navigation Bar
        View navHome = findViewById(R.id.navHome);
        View btnRewardsNav = findViewById(R.id.btnRewardsNav); // Bar "Donation"
        View btnNotifNav = findViewById(R.id.btnNotifNav);
        View btnProfileNav = findViewById(R.id.btnProfileNav);

        // --- Logik Navigasi ---

        // Share Location -> Maps
        if (btnShareLocation != null) {
            btnShareLocation.setOnClickListener(v -> {
                startActivity(new Intent(LocationAccess.this, MapsActivity.class));
            });
        }

        // Skip -> Home
        if (tvSkip != null) {
            tvSkip.setOnClickListener(v -> {
                navigateTo(HomeActivity.class);
            });
        }

        // Navigasi Bar: Home (Ini yang anda terlepas sebelum ini)
        if (navHome != null) {
            navHome.setOnClickListener(v -> {
                navigateTo(HomeActivity.class);
            });
        }

        // Navigasi Bar: Donation (Hanya Toast kerana anda sudah di skrin ini)
        if (btnRewardsNav != null) {
            btnRewardsNav.setOnClickListener(v -> {
                // Skrin ini sekarang adalah skrin Donation/LocationAccess
            });
        }

        // Navigasi Bar: Chat
        if (btnNotifNav != null) {
            btnNotifNav.setOnClickListener(v -> {
                navigateTo(ChatActivity.class);
            });
        }

        // Navigasi Bar: Profile
        if (btnProfileNav != null) {
            btnProfileNav.setOnClickListener(v -> {
                navigateTo(AccountActivity.class);
            });
        }
    }

    // Fungsi helper untuk navigasi yang lancar
    private void navigateTo(Class<?> targetActivity) {
        Intent intent = new Intent(this, targetActivity);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }
}