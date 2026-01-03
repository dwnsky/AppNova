package com.example.madappnova;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginPageSellerActivity extends AppCompatActivity {

    EditText etEmail2, etPassword2;
    Button btnSignUp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page_seller);

        // Find views

        etEmail2 = findViewById(R.id.etEmail2);
        etPassword2 = findViewById(R.id.etPassword2);
        btnSignUp2 = findViewById(R.id.btnSignUp2);

        // Button click
        btnSignUp2.setOnClickListener(v -> {
            // Optional: validate inputs
            String email = etEmail2.getText().toString();
            String password = etPassword2.getText().toString();

            if(email.isEmpty() || password.isEmpty()){
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            // After validation, go to next page
            Intent intent = new Intent(LoginPageSellerActivity.this, HomeSellerActivity.class); // replace with actual next page
            startActivity(intent);
        });

        TextView forgotPassword = findViewById(R.id.forgotPassword);

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginPageSellerActivity.this, ForgotPasswordPage1.class);
                startActivity(intent);
            }
        });
    }}
