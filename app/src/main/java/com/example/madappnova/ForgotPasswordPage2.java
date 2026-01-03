package com.example.madappnova;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ForgotPasswordPage2 extends AppCompatActivity {
    EditText etPassword, etConfirmPassword;
    Button saveBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_password_page2);

        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        saveBtn = findViewById(R.id.saveBtn);

        saveBtn.setOnClickListener(v -> {
            // Optional: validate inputs
            String password = etPassword.getText().toString();
            String confirmPassword = etConfirmPassword.getText().toString();

            if(password.isEmpty() || confirmPassword.isEmpty()){
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            if(!password.equals(confirmPassword)){
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                return;
            }

            // After validation, go to next page
            Intent intent = new Intent(ForgotPasswordPage2.this, ForgotPasswordPage3.class); // replace with actual next page
            startActivity(intent);
        });
    }}