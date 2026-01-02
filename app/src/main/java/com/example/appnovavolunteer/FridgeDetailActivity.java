package com.example.appnovavolunteer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.example.appnovavolunteer.databinding.ActivityFridgeDetailBinding;

public class FridgeDetailActivity extends AppCompatActivity {

    private ActivityFridgeDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 1. Setup View Binding untuk activity_fridge_detail.xml
        binding = ActivityFridgeDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 2. Butang 'See details' untuk ke page seterusnya (Task Details)
        binding.btnSeeDetails.setOnClickListener(v -> {
            // Un-comment kod bawah ini bila babe dah buat TaskDetailActivity nanti
            // Intent intent = new Intent(FridgeDetailActivity.this, TaskDetailActivity.class);
            // startActivity(intent);
        });

        // 3. Butang Close (X) di atas peta
        // Jika babe ada letak ImageButton id btnClose, guna kod ni untuk balik ke map asal
        if (binding.btnClose != null) {
            binding.btnClose.setOnClickListener(v -> finish());
        }

        // 4. Klik kawasan peta untuk balik ke page Legend (opsyenal)
        binding.mapResult.setOnClickListener(v -> {
            finish(); // Menutup activity ini dan kembali ke FridgeMapActivity
        });
    }
}