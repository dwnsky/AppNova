package com.example.appnova;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAuth = FirebaseAuth.getInstance();

        // 🔁 AUTO-REDIRECT LOGIC
        if (mAuth.getCurrentUser() != null) {
            // User already logged in
            startActivity(new Intent(this, LoginActivity.class));
        } else {
            // User not logged in
            startActivity(new Intent(this, HomeCustomerActivity.class));
        }

        // Kill MainActivity so user can't go back to it
        finish();
    }
}
