package com.example.appnovavolunteer;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class RewardsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rewards);

        // 1. Inisialisasi Card Diskaun
        CardView cardBodyShop = findViewById(R.id.cardBodyShop);

        // 2. Inisialisasi Navigasi Bawah
        ImageButton btnHomeNav = findViewById(R.id.btnHomeNav);
        ImageButton btnProfileNav = findViewById(R.id.btnProfileNav);
        ImageButton btnNotificationNav = findViewById(R.id.btnNotificationNav);

        // --- LOGIK KLIK KAD DISKAUN ---
        if (cardBodyShop != null) {
            cardBodyShop.setOnClickListener(v -> {
                // Berpindah ke VoucherDetailActivity
                Intent intent = new Intent(RewardsActivity.this, VoucherDetailActivity.class);
                startActivity(intent);
            });
        }

        // --- NAVIGASI BAR BAWAH ---
        if (btnHomeNav != null) {
            btnHomeNav.setOnClickListener(v -> {
                startActivity(new Intent(this, HomeActivity.class));
            });
        }

        if (btnProfileNav != null) {
            btnProfileNav.setOnClickListener(v -> {
                startActivity(new Intent(this, AccountActivity.class));
            });
        }

        // Anda juga boleh tambah logik untuk butang Claim jika perlu
        Button btnClaim = findViewById(R.id.btnClaim);
        if (btnClaim != null) {
            btnClaim.setOnClickListener(v -> {
                // Logik tuntut mata
            });
        }
    }
}