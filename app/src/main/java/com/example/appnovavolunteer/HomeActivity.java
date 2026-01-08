package com.example.appnovavolunteer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // 1. Cari butang guna ID yang betul-betul ada dalam XML babe
        ImageButton btnRewards = findViewById(R.id.btnRewardsNav); // Love Icon
        ImageButton btnProfile = findViewById(R.id.btnProfileNav); // Profile Icon
        android.widget.Button btnRedeem = findViewById(R.id.btnRedeem); // Butang Redeem

        // 2. Klik Love Icon (ID: btnRewardsNav) -> Ke Location Access
        if (btnRewards != null) {
            btnRewards.setOnClickListener(v -> {
                Intent intent = new Intent(HomeActivity.this, LocationAccess.class);
                startActivity(intent);
            });
        }

        // 3. Klik Profile Icon (ID: btnProfileNav) -> Ke Account Page
        if (btnProfile != null) {
            btnProfile.setOnClickListener(v -> {
                Intent intent = new Intent(HomeActivity.this, AccountActivity.class);
                startActivity(intent);
            });
        }

        // 4. Klik Butang Redeem (ID: btnRedeem) -> Ke Rewards Page
        if (btnRedeem != null) {
            btnRedeem.setOnClickListener(v -> {
                // Pastikan babe ada file RewardsActivity
                Intent intent = new Intent(HomeActivity.this, RewardsActivity.class);
                startActivity(intent);
            });
        }
    }
}
