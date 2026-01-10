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

        // 2. Logic for 'Start delivery now' -> Goes to SuccessfulActivity
        binding.btnStartDelivery.setOnClickListener(v -> {
            Intent intent = new Intent(RequestSuccessActivity.this, SuccessfulActivity.class);
            startActivity(intent);
            // finish() prevents the user from coming back to this success screen when pressing back
            finish();
        });

        // 3. Setup Bottom Navigation
        setupBottomNav();
    }

    private void setupBottomNav() {
        // Attempting to find the bottom nav container
        View bottomBar = findViewById(R.id.bottomNav);
        if (bottomBar != null) {
            // Find the specific home button inside that container
            View homeBtn = bottomBar.findViewById(R.id.btnHomeNav);
            if (homeBtn != null) {
                homeBtn.setOnClickListener(v -> {
                    // Navigate to Home or simply finish to go back
                    Intent intent = new Intent(RequestSuccessActivity.this, HomeActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();
                });
            }
        }
    }
}