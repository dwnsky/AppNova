package com.example.appnovavolunteer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.example.appnovavolunteer.databinding.ActivityFridgeResultBinding;

public class FridgeResultActivity extends AppCompatActivity {

    private ActivityFridgeResultBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFridgeResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Paksa marker berada di lapisan paling atas sekali
        binding.markerGreen.bringToFront();

        // Logik klik untuk ke page detail
        binding.markerGreen.setOnClickListener(v -> {
            Intent intent = new Intent(FridgeResultActivity.this, FridgeDetailActivity.class);
            startActivity(intent);
        });
    }
}