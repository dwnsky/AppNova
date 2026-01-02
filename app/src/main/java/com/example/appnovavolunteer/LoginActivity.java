package com.example.appnovavolunteer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Inside LoginActivity.java onCreate method
        TextView tvRegister = findViewById(R.id.tvRegister);

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent moves you from Login to Register
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button signInBtn = findViewById(R.id.btnSignIn);
        TextView registerLink = findViewById(R.id.tvRegister); // Add this ID to your XML link

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Logic for signing in
                Toast.makeText(LoginActivity.this, "Signing In...", Toast.LENGTH_SHORT).show();
            }
        });

        registerLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // This moves from Login to Register screen
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
