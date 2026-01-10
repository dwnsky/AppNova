package com.example.appnovavolunteer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.example.appnovavolunteer.databinding.ActivityMapsBinding;

public class MapsActivity extends AppCompatActivity {

    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 1. Setup View Binding
        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 2. Klik butang Close (X) - Balik ke page sebelum (biasanya LocationAccess)
        if (binding.btnClose != null) {
            binding.btnClose.setOnClickListener(v -> finish());
        }

        // 3. Klik butang Next - Bawa ke page FridgeResultActivity
        if (binding.btnNext != null) {
            binding.btnNext.setOnClickListener(v -> {
                Intent intent = new Intent(MapsActivity.this, FridgeResultActivity.class);
                startActivity(intent);
            });
        }

        // 4. Bottom Navigation - Klik Home
        // Memastikan ID dalam include layout bottom_nav_bar adalah btnHomeNav
        if (binding.bottomNavBar != null && binding.bottomNavBar.btnHomeNav != null) {
            binding.bottomNavBar.btnHomeNav.setOnClickListener(v -> {
                Intent intent = new Intent(MapsActivity.this, HomeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            });
        }
    }
}