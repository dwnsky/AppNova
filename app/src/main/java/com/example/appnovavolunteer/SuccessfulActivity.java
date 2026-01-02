package com.example.appnovavolunteer;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.appnovavolunteer.databinding.ActivitySuccessfulBinding; // Pastikan nama binding ikut nama fail XML babe

public class SuccessfulActivity extends AppCompatActivity {

    private ActivitySuccessfulBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 1. Setup View Binding
        binding = ActivitySuccessfulBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 2. Fungsi: Klik gambar 'successful' (250 Pts) untuk balik ke Home
        binding.ivFeaturedBanner.setOnClickListener(v -> {
            // Kita hantar user balik ke HomeActivity
            Intent intent = new Intent(SuccessfulActivity.this, HomeActivity.class);

            // Flag ini akan bersihkan 'stack' page lama supaya tak berat
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);

            startActivity(intent);
            finish(); // Tutup page successful ni
        });

        // 3. Logik Butang Redeem (Jika user nak redeem mata terus)
        binding.btnRedeem.setOnClickListener(v -> {
            // Tambah code ke page Redeem di sini jika perlu
        });

        // 4. Navigasi Bottom Bar (Contoh: Klik Account balik ke Profile)
        binding.btnAccountNav.setOnClickListener(v -> {
            // Intent intent = new Intent(this, ProfileActivity.class);
            // startActivity(intent);
        });

        // Tambahan: Jika babe nak butang DonationNav pun berfungsi
        binding.btnDonationNav.setOnClickListener(v -> {
            finish(); // Ataupun balik ke page donation
        });
    }
}