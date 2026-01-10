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

        // 1. Initialize Buttons
        ImageButton btnRewardsNav = findViewById(R.id.btnRewardsNav);
        ImageButton btnNotifNav = findViewById(R.id.btnNotifNav);
        ImageButton btnProfileNav = findViewById(R.id.btnProfileNav);

        // 2. Navigation to LocationAccess (Love Icon)
        if (btnRewardsNav != null) {
            btnRewardsNav.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(HomeActivity.this, LocationAccess.class);
                    startActivity(intent);
                }
            });
        }

        // 3. Navigation to Chat (Bell Icon)
        if (btnNotifNav != null) {
            btnNotifNav.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(HomeActivity.this, ChatActivity.class);
                    startActivity(intent);
                }
            });
        }

        // 4. Navigation to Account (Profile Icon)
        if (btnProfileNav != null) {
            btnProfileNav.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(HomeActivity.this, AccountActivity.class);
                    startActivity(intent);
                }
            });
        }
    }
}