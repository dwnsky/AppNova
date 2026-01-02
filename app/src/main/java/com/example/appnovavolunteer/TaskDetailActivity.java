package com.example.appnovavolunteer;

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

        // 2. Inflate binding
        binding = ActivityTaskDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 3. Logik butang Back
        if (binding.btnBack != null) {
            binding.btnBack.setOnClickListener(v -> {
                finish(); // Tutup page ini dan balik ke page sebelum
            });
        }
    }
}
