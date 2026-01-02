package com.example.appnovavolunteer;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

    public class RegisterActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_register);

            // Link to the "Sign in!" text
            TextView tvBackToLogin = findViewById(R.id.tvBackToLoginLink);

            tvBackToLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 1. Show the "Clicked!" message
                    Toast.makeText(RegisterActivity.this, "Clicked!", Toast.LENGTH_SHORT).show();

                    // 2. Log it to the console
                    System.out.println("Sign in link clicked!");

                    // 3. Go back to Login (finish() closes the Register screen)
                    finish();
                }
            });
        }
    }
