package com.example.appnovavolunteer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import com.example.appnovavolunteer.databinding.ActivityRequestSuccessBinding;

public class RequestSuccessActivity extends AppCompatActivity {

    private ActivityRequestSuccessBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 1. Setup View Binding
        binding = ActivityRequestSuccessBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 2. Logik Butang 'Start delivery now'
        binding.btnStartDelivery.setOnClickListener(v -> {
            // Contoh: Bawa user balik ke Map atau senarai tugasan
            Intent intent = new Intent(RequestSuccessActivity.this, FridgeDetailActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // Untuk clear stack supaya tak boleh back ke page success lagi
            startActivity(intent);
            finish();
        });

        // 3. Setup Bottom Navigation (Optional tapi digalakkan)
        setupBottomNav();
    }

    private void setupBottomNav() {
        // Kita panggil secara terus dari View kalau Binding masih merajuk
        View bottomBar = findViewById(R.id.bottomNav);
        if (bottomBar != null) {
            bottomBar.findViewById(R.id.btnHomeNav).setOnClickListener(v -> {
                finish();
            });
        }
    }
}