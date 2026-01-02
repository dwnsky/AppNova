package com.example.appnovavolunteer;

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

        // Apabila tekan Marker Hijau
        binding.markerGreen.setOnClickListener(v -> {
            binding.detailCard.setVisibility(View.VISIBLE);
            // Anda boleh tukar teks dalam kad secara dinamik
            // binding.tvFridgeName.setText("Fumo Pizza Café");
        });

        // Apabila tekan Marker Kelabu
        binding.markerGrey.setOnClickListener(v -> {
            // Mungkin tunjukkan mesej "This fridge is already assigned"
            binding.detailCard.setVisibility(View.GONE);
        });

        // Klik di kawasan peta untuk sembunyikan kad semula
        binding.mapBackground.setOnClickListener(v -> {
            binding.detailCard.setVisibility(View.GONE);
        });
    }
}