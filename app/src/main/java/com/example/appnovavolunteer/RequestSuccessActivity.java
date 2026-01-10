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

        // 2. Logic: 'Start delivery now' -> SEKARANG pergi ke UpdateDeliveryActivity
        binding.btnStartDelivery.setOnClickListener(v -> {
            Intent intent = new Intent(RequestSuccessActivity.this, DeliveryUpdateActivity.class);
            startActivity(intent);
            // Kita finish() supaya user tidak patah balik ke skrin "Accepted" ini
            // selepas mereka mula mengemas kini status penghantaran.
            finish();
        });

        // 3. Setup Bottom Navigation
        setupBottomNav();
    }

    private void setupBottomNav() {
        View bottomBar = findViewById(R.id.bottomNav);
        if (bottomBar != null) {
            View homeBtn = bottomBar.findViewById(R.id.btnHomeNav);
            if (homeBtn != null) {
                homeBtn.setOnClickListener(v -> {
                    Intent intent = new Intent(RequestSuccessActivity.this, HomeActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();
                });
            }
        }
    }
}