package com.example.appnovavolunteer;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Inisialisasi View
        TextView tvRegister = findViewById(R.id.tvRegister);
        Button btnSignIn = findViewById(R.id.btnSignIn);

        // 2. Logik ke Halaman Register
        if (tvRegister != null) {
            tvRegister.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            });
        }

        // 3. Logik Sign In ke Home Page (DIPERBAIKI)
        if (btnSignIn != null) {
            btnSignIn.setOnClickListener(v -> {
                Toast.makeText(MainActivity.this, "Sign In Successful!", Toast.LENGTH_SHORT).show();

                // Navigasi ke HomeActivity
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);

                // FLAG ini sangat penting:
                // ia akan memadamkan stack Welcome, Role, dan MainActivity
                // supaya HomeActivity menjadi aktiviti utama yang baru.
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                startActivity(intent);

                // Menutup MainActivity secara kekal untuk sesi ini
                finish();
            });
        }
    }
}