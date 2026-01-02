package com.example.appnovavolunteer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Cari ID butang Account di Bottom Navigation Bar
        // Dalam onCreate
        ImageButton btnDonation = findViewById(R.id.btnDonationNav);
        ImageButton btnAccount = findViewById(R.id.btnAccountNav);

// Klik Love Icon -> Pergi ke Location Access Page
        btnDonation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, LocationAccess.class);
                startActivity(intent);
            }
        });

// Klik Profile Icon -> Pergi ke Account Page
        btnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, AccountActivity.class);
                startActivity(intent);
            }
        });
    }
}
