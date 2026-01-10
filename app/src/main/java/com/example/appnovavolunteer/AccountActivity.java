package com.example.appnovavolunteer;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        // 1. Inisialisasi Butang Top Bar
        ImageButton btnBack = findViewById(R.id.btnBack);

        // 2. Inisialisasi Butang Bottom Navigation
        ImageButton navHome = findViewById(R.id.navHome);
        ImageButton navRewards = findViewById(R.id.navRewards);
        ImageButton navNotif = findViewById(R.id.navNotif);

        // 3. Inisialisasi Butang dalam List
        RelativeLayout btnSettings = findViewById(R.id.btnSettings);
        RelativeLayout btnPassword = findViewById(R.id.btnPassword);

        // TAMBAHAN: Inisialisasi Butang Logout
        RelativeLayout btnLogout = findViewById(R.id.btnLogout);

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

        // Navigasi ke Rewards
        if (navRewards != null) {
            navRewards.setOnClickListener(v -> {
                Intent intent = new Intent(AccountActivity.this, RewardsActivity.class); // Pastikan ini RewardsActivity
                startActivity(intent);
            });
        }

        // Navigasi ke Chat
        if (navNotif != null) {
            navNotif.setOnClickListener(v -> {
                Intent intent = new Intent(AccountActivity.this, ChatActivity.class);
                startActivity(intent);
            });
        }

        // --- LOGIK LOGOUT ---
        if (btnLogout != null) {
            btnLogout.setOnClickListener(v -> {
                Toast.makeText(this, "Logging out...", Toast.LENGTH_SHORT).show();

                // 1. Arahkan ke RoleActivity
                Intent intent = new Intent(AccountActivity.this, RoleActivity.class);

                // 2. FLAG_ACTIVITY_NEW_TASK dan FLAG_ACTIVITY_CLEAR_TASK
                // Sangat penting supaya pengguna tidak boleh tekan "Back" untuk masuk semula
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                startActivity(intent);

                // 3. Tutup activity ini
                finish();
            });
        }
    }
}