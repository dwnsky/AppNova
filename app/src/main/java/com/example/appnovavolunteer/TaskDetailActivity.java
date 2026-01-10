package com.example.appnovavolunteer;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.appnovavolunteer.databinding.ActivityTaskDetailBinding;

public class TaskDetailActivity extends AppCompatActivity {

    // 1. Deklarasi binding
    private ActivityTaskDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // FIX: Move this to the top
        binding = ActivityTaskDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Now listeners will work
        binding.ivNoodles.setOnClickListener(v -> {
            startActivity(new Intent(this, FoodDetailActivity.class));
        });

        if (binding.btnBack != null) {
            binding.btnBack.setOnClickListener(v -> finish());
        }
    }


    }

