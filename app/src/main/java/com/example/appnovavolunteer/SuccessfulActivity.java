package com.example.appnovavolunteer;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
// Pastikan nama binding ni betul ikut nama file XML success babe
import com.example.appnovavolunteer.databinding.ActivitySuccessfulBinding;

public class SuccessfulActivity extends AppCompatActivity {

    private ActivitySuccessfulBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySuccessfulBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 1. Klik banner untuk balik ke Home (Ini OK kalau ID ivFeaturedBanner ada)
        if (binding.ivFeaturedBanner != null) {
            binding.ivFeaturedBanner.setOnClickListener(v -> {
                Intent intent = new Intent(SuccessfulActivity.this, HomeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish();
            });
        }

        // 2. PROBLEM: btnRedeem tak ada kat page Success. Kena COMMENT OUT!
        /* binding.btnRedeem.setOnClickListener(v -> {
             // Padam atau comment kod ni sebab butang ni kat Home je
        });
        */

        // 3. NAV BUTTONS: Kalau page success babe tak ada Bottom Nav, kena buang juga!
        // Kalau ada Bottom Nav kat XML success, pastikan ID dia betul.

        if (binding.btnDonationNav != null) {
            binding.btnDonationNav.setOnClickListener(v -> {
                finish();
            });
        }
    }
}