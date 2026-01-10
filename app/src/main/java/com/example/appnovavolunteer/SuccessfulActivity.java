package com.example.appnovavolunteer;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.appnovavolunteer.databinding.ActivitySuccessfulBinding;

public class SuccessfulActivity extends AppCompatActivity {

    private ActivitySuccessfulBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize Binding
        binding = ActivitySuccessfulBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 1. Back to Home via Banner/Image
        if (binding.ivFeaturedBanner != null) {
            binding.ivFeaturedBanner.setOnClickListener(v -> {
                Intent intent = new Intent(SuccessfulActivity.this, HomeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            });
        }

        // 2. BOTTOM NAVIGATION LOGIC (Following your new ID standard)

        // Home Navigation
        if (binding.navHome != null) {
            binding.navHome.setOnClickListener(v -> {
                Intent intent = new Intent(this, HomeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            });
        }

        // Rewards/Love Navigation
        if (binding.btnRewardsNav != null) {
            binding.btnRewardsNav.setOnClickListener(v -> {
                startActivity(new Intent(this, LocationAccess.class));
            });
        }

        // Notification/Chat Navigation
        if (binding.btnNotif != null) {
            binding.btnNotif.setOnClickListener(v -> {
                startActivity(new Intent(this, ChatActivity.class));
            });
        }

        // Profile/Account Navigation
        if (binding.btnProfileNav != null) {
            binding.btnProfileNav.setOnClickListener(v -> {
                startActivity(new Intent(this, AccountActivity.class));
            });
        }
    }
}