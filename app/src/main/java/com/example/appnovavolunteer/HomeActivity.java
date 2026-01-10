package com.example.appnovavolunteer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View; // Tambah ini
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout; // Tambah ini
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // 1. Inisialisasi Navigation (Ikut jenis data yang betul)
        ImageButton btnDonationNav = findViewById(R.id.btnRewardsNav);
        LinearLayout btnHomeNav = findViewById(R.id.navHome); // DITUKAR: Dari ImageButton ke LinearLayout
        ImageButton btnChatNav = findViewById(R.id.btnNotifNav);
        ImageButton btnProfileNav = findViewById(R.id.btnProfileNav);

        // 2. Inisialisasi Butang Redeem
        Button btnRedeem = findViewById(R.id.btnRedeem);

        // Klik pada Layout Home
        if (btnHomeNav != null) {
            btnHomeNav.setOnClickListener(v -> {
                Toast.makeText(this, "You are at Home", Toast.LENGTH_SHORT).show();
            });
        }

        // Navigasi ke LocationAccess (Ikon Love)
        if (btnDonationNav != null) {
            btnDonationNav.setOnClickListener(v -> {
                startActivity(new Intent(HomeActivity.this, LocationAccess.class));
            });
        }

        // Navigasi ke Chat
        if (btnChatNav != null) {
            btnChatNav.setOnClickListener(v -> {
                startActivity(new Intent(HomeActivity.this, ChatActivity.class));
            });
        }

        // Navigasi ke Profile
        if (btnProfileNav != null) {
            btnProfileNav.setOnClickListener(v -> {
                startActivity(new Intent(HomeActivity.this, AccountActivity.class));
            });
        }

        // Butang Redeem
        if (btnRedeem != null) {
            btnRedeem.setOnClickListener(v -> {
                startActivity(new Intent(HomeActivity.this, RewardsActivity.class));
            });
        }
    }
}