package com.example.madappnova;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ForgotPasswordPage1 extends AppCompatActivity {
    EditText etEmail;
    Button svBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_password_page1);

        etEmail = findViewById(R.id.etEmail);
        svBtn = findViewById(R.id.svBtn);

        svBtn.setOnClickListener(v -> {
            // Optional: validate inputs
            String email = etEmail.getText().toString();

            if(email.isEmpty()){
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            // After validation, go to next page
            Intent intent = new Intent(ForgotPasswordPage1.this, ForgotPasswordPage2.class); // replace with actual next page
            startActivity(intent);
        });
    }
}
