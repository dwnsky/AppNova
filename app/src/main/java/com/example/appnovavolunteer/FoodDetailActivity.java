package com.example.appnovavolunteer;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.appnovavolunteer.databinding.ActivityFoodDetailBinding;

public class FoodDetailActivity extends AppCompatActivity {
    private ActivityFoodDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFoodDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnBack.setOnClickListener(v -> finish());

        binding.btnRequest.setOnClickListener(v -> {
            Toast.makeText(this, "Request submitted for Noodles!", Toast.LENGTH_SHORT).show();
        });
    }
}