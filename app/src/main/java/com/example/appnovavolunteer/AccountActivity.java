package com.example.appnovavolunteer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        // 1.Inisialisasi Butang Top Bar
        ImageButton btnBack = findViewById(R.id.btnBack);

        // 2. Inisialisasi Butang Bottom Navigation
        ImageButton navHome = findViewById(R.id.navHome);
        ImageButton navRewards = findViewById(R.id.navRewards);
        ImageButton navNotif = findViewById(R.id.navNotif);
        // Note: navProfile tidak perlu listener kerana kita sudah berada di sini

        // 3. Inisialisasi Butang dalam List (Contoh: Settings)
        RelativeLayout btnSettings = findViewById(R.id.btnSettings);
        RelativeLayout btnPassword = findViewById(R.id.btnPassword);

        // --- LOGIK KLIK ---

        // Kembali ke halaman sebelumnya
        if (btnBack != null) {
            btnBack.setOnClickListener(v -> finish());
        }

        // Navigasi ke Home
        if (navHome != null) {
            navHome.setOnClickListener(v -> {
                Intent intent = new Intent(AccountActivity.this, HomeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            });
        }

        // Navigasi ke Location Access / Rewards
        if (navRewards != null) {
            navRewards.setOnClickListener(v -> {
                Intent intent = new Intent(AccountActivity.this, LocationAccess.class);
                startActivity(intent);
            });
        }

        // Navigasi ke Chat/Notification
        if (navNotif != null) {
            navNotif.setOnClickListener(v -> {
                Intent intent = new Intent(AccountActivity.this, ChatActivity.class);
                startActivity(intent);
            });
        }

        // Logik untuk Butang Settings (Hanya tunjuk mesej buat masa ini)
        if (btnSettings != null) {
            btnSettings.setOnClickListener(v ->
                    Toast.makeText(this, "Opening Settings...", Toast.LENGTH_SHORT).show());
        }
    }
}