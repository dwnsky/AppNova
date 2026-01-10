package com.example.appnovavolunteer;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.appnovavolunteer.databinding.ActivityFridgeDetailBinding;

public class FridgeDetailActivity extends AppCompatActivity {
    private ActivityFridgeDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFridgeDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnSeeDetails.setOnClickListener(v -> {
            startActivity(new Intent(this, TaskDetailActivity.class));
        });

        binding.btnClose.setOnClickListener(v -> finish());
    }
}