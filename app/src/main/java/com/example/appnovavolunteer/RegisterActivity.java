package com.example.appnovavolunteer;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView; // Tambah import ini
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // 1. Logik Butang SIGN UP (Sedia ada)
        Button btnSignUp = findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(v -> {
            // Logik pendaftaran anda di sini...
            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        // 2. Logik Pautan "Already have an account? Sign in!"
        // Hubungkan ID dari XML ke Java
        TextView tvBackToLogin = findViewById(R.id.tvBackToLoginLink);

        if (tvBackToLogin != null) {
            tvBackToLogin.setOnClickListener(v -> {
                // Kembali ke MainActivity (Skrin Login)
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // Tutup RegisterActivity supaya tidak bertindan dalam backstack
            });
        }

        // 3. Logik Butang "Back" (Ikon panah di atas kiri)
        TextView btnBack = findViewById(R.id.btnBackToLogin);
        if (btnBack != null) {
            btnBack.setOnClickListener(v -> finish());
        }
    }
}