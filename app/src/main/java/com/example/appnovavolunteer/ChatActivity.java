package com.example.appnovavolunteer;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class ChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        // 1. Inisialisasi butang navigasi (Updated to match your XML exactly)
        ImageButton btnHome = findViewById(R.id.navHome);
        ImageButton btnDonation = findViewById(R.id.navRewards); // matching android:id="@+id/navRewards"
        ImageButton btnProfile = findViewById(R.id.navProfile);  // matching android:id="@+id/navProfile"

        // 2. Klik Home Icon -> Ke HomeActivity
        if (btnHome != null) {
            btnHome.setOnClickListener(v -> {
                Intent intent = new Intent(ChatActivity.this, HomeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            });
        }

        // 3. Klik Donation/Love Icon -> Ke LocationAccess
        if (btnDonation != null) {
            btnDonation.setOnClickListener(v -> {
                Intent intent = new Intent(ChatActivity.this, LocationAccess.class);
                startActivity(intent);
            });
        }

        // 4. Klik Profile Icon -> Ke AccountActivity
        if (btnProfile != null) {
            btnProfile.setOnClickListener(v -> {
                Intent intent = new Intent(ChatActivity.this, AccountActivity.class);
                startActivity(intent);
            });
        }
    }
}