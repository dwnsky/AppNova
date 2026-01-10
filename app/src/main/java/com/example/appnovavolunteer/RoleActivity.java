package com.example.appnovavolunteer;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class RoleActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_role); // Your third XML

        findViewById(R.id.volunteerBtn).setOnClickListener(v -> {
            Intent intent = new Intent(RoleActivity.this, RegisterActivity.class);
            startActivity(intent);
        });

        // Optional: Handle customerBtn or sellerBtn here if needed
    }
}